CREATE SCHEMA IF NOT EXISTS am;

SET SCHEMA am;

------------------------------
-- Financial Securities Module
------------------------------

/*

DROP TABLE sm_eod_quote;
DROP TABLE sm_instrument;
DROP TABLE sm_exchange;
DROP TABLE sm_eod_quotes_staging;
DROP FUNCTION sm_load_eod_quotes;

CREATE UNLOGGED TABLE sm_eod_quotes_staging (
    symbol              VARCHAR,
    security_descr      VARCHAR,
    close_price         DECIMAL,
    volume_traded       VARCHAR
)
;

*/        
        
CREATE TABLE IF NOT EXISTS sm_exchange(
   id      IDENTITY PRIMARY KEY
  ,symbol  VARCHAR
  ,descr   VARCHAR
)
;




CREATE TABLE IF NOT EXISTS sm_instrument(
   id               IDENTITY PRIMARY KEY
  ,exchange_id      integer
  ,symbol           VARCHAR
  ,instrument_type  VARCHAR
  ,descr            VARCHAR
  ,create_dte       DATE
  ,instrument_status VARCHAR
  ,CONSTRAINT sm_instrument_exchange_id_fk FOREIGN KEY(exchange_id) REFERENCES sm_exchange(id)
)
;

CREATE UNIQUE INDEX  IF NOT EXISTS sm_instrument_exchange_symbol_fk ON sm_instrument(exchange_id, symbol)
;

CREATE TABLE IF NOT EXISTS sm_eod_quote(
   id             IDENTITY PRIMARY KEY
  ,instrument_id  integer
  ,read_dte       date
  ,close_price    NUMBER(8, 2)
  ,volume_traded  integer
  ,CONSTRAINT sm_eod_quote_instrument_id_fk FOREIGN KEY(instrument_id) REFERENCES sm_instrument(id)
)
;

CREATE UNIQUE INDEX  IF NOT EXISTS sm_eod_quote_instrument_id_read_dte_fk ON sm_eod_quote(instrument_id, read_dte)
;


CREATE TABLE IF NOT EXISTS sm_debenture_detail(
   instrument_id     integer PRIMARY KEY
  ,percentage        NUMBER
  ,issue_dte         date
  ,maturity_dte      date
  ,prospectus        VARCHAR
  ,underlying_instrument_id integer
  ,conversion_price  NUMBER(15, 2)
  ,comments          VARCHAR

  ,CONSTRAINT sm_debenture_detail_instrument_id_fk
     FOREIGN KEY(instrument_id)
     REFERENCES sm_instrument(id)
    
  ,CONSTRAINT sm_debenture_detail_underlying_id_fk
     FOREIGN KEY(underlying_instrument_id)
     REFERENCES sm_instrument(id)
    
)
;


CREATE OR REPLACE VIEW sm_quote_vw 
AS
SELECT i.id AS instrument_id, i.symbol, i.descr, i.instrument_type, i.instrument_status, q.close_price, q.volume_traded, q.read_dte
  FROM sm_instrument i
  LEFT JOIN sm_eod_quote q
         ON (q.instrument_id = i. id
			 AND
			 q.read_dte = (SELECT MAX(read_dte) FROM sm_eod_quote WHERE instrument_id = q.instrument_id)
			)
  ORDER BY i.descr
;


CREATE OR REPLACE VIEW sm_debenture_vw 
AS
SELECT q.instrument_id, q.symbol, q.descr, d.issue_dte, d.maturity_dte, d.percentage
       ,ROUND(d.percentage - ((q.close_price - 100.0) / (DATEDIFF(DAY, current_date, d.maturity_dte) / 365.0)), 3) AS effective_rate
       ,q.close_price, q.volume_traded, q.read_dte
       ,d.underlying_instrument_id, uq.symbol AS underlying_symbol
       ,uq.close_price AS underlying_close_price
       ,uq.read_dte AS underlying_read_dte
       ,d.conversion_price
       ,ROUND(100.0/d.conversion_price, 3) AS conversion_rate
       ,ROUND(uq.close_price * 100.0/d.conversion_price, 3) AS converted
       ,d.prospectus
       ,d.comments
  FROM sm_quote_vw q
  LEFT JOIN sm_debenture_detail d ON (d.instrument_id = q.instrument_id)
  LEFT JOIN sm_quote_vw uq ON (uq.instrument_id = d.underlying_instrument_id)
  WHERE q.instrument_type = 'D'
    AND q.instrument_status = 'A'
  ORDER BY q.symbol
;
