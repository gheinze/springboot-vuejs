package space.redoak.am.finsec.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import space.redoak.am.finsec.domain.Debenture;


/**
 *
 * @author glenn
 */
@Component
class DebentureMapper {

    Debenture createDebenture(DebentureEntity entity) {
        return new Debenture(
                entity.getInstrumentId()
               ,entity.getSymbol()
               ,entity.getDescr()
               ,entity.getIssueDte()
               ,entity.getMaturityDte()
               ,entity.getPercentage()
               ,entity.getEffectiveRate()
               ,entity.getClosePrice()
               ,entity.getVolumeTraded()
               ,entity.getReadDte()
               ,entity.getUnderlyingInstrumentId()
               ,entity.getUnderlyingSymbol()
               ,entity.getUnderlyingClosePrice()
               ,entity.getUnderlyingReadDte()
               ,entity.getConversionPrice()
               ,entity.getConversionRate()
               ,entity.getConverted()
               ,entity.getProspectus()
               ,entity.getComments()
        );
        
    }
    
    
    Page<Debenture> mapEntitiesToDomain(Page<DebentureEntity> entities) {
        return entities.map(this::createDebenture);
    }
    
}
