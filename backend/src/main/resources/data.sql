SET SCHEMA am;

MERGE INTO sm_exchange(symbol, descr)
  KEY(symbol)
 VALUES ('TSX', 'Toronto Stock Exchange')
       ,('TSXV', 'Toronto Venture Exchange')
       ,('NYSE', 'New York Stock Exchange')
       ,('NASDAQ', 'NASDAQ Stock Exchange')
;

