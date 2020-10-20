package space.redoak.am.finsec.domain;

import java.time.LocalDate;


/**
 *
 * @author glenn
 */
public record Debenture(
    Integer instrumentId,
    String symbol,
    String descr,
    LocalDate issueDte,
    LocalDate maturityDte,
    Float percentage,
    Float effectiveRate,
    Float closePrice,
    Integer volumeTraded,
    LocalDate readDte,
    Integer underlyingInstrumentId,
    String underlyingSymbol,
    Float underlyingClosePrice,
    LocalDate underlyingReadDte,
    Float conversionPrice,
    Float conversionRate,
    Float converted,
    String prospectus,
    String comments
) {
    
}


