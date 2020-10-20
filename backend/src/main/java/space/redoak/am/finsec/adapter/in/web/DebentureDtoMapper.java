package space.redoak.am.finsec.adapter.in.web;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import space.redoak.am.finsec.domain.Debenture;

/**
 *
 * @author glenn
 */
@Component
public class DebentureDtoMapper {

    public DebentureDto createDebentureDto(Debenture debenture) {
        return new DebentureDto(
                debenture.instrumentId()
               ,debenture.symbol()
               ,debenture.descr()
               ,debenture.issueDte()
               ,debenture.maturityDte()
               ,debenture.percentage()
               ,debenture.effectiveRate()
               ,debenture.closePrice()
               ,debenture.volumeTraded()
               ,debenture.readDte()
               ,debenture.underlyingInstrumentId()
               ,debenture.underlyingSymbol()
               ,debenture.underlyingClosePrice()
               ,debenture.underlyingReadDte()
               ,debenture.conversionPrice()
               ,debenture.conversionRate()
               ,debenture.converted()
               ,debenture.prospectus()
               ,debenture.comments()
        );        
    }
    
    
    Page<DebentureDto> mapDebenturePageToDebentureDtoPage(Page<Debenture> debenturePage) {
        return debenturePage.map(this::createDebentureDto);
    }
    
}      
