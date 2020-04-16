package space.redoak.am.finsec;

import org.springframework.stereotype.Component;

@Component
public class QuoteDtoMapper {

    public QuoteDto map(Quote quote) {
        return new QuoteDto(
            quote.getId(),
            quote.getInstrumentId(),
            quote.getReadDte(),
            quote.getClosePrice(),
            quote.getVolumeTraded()
        );
    }

}