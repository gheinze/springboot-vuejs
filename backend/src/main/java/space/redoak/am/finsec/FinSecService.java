package space.redoak.am.finsec;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FinSecService {

    @Autowired private ExchangeRepository exchangeRepository;
    @Autowired private QuoteRepository quoteRepository;



    public List<Exchange> getExchanges() {
        return exchangeRepository.findAll();
    }


    public List<Quote> getQuotes(final Integer instrumentId) {
        return quoteRepository.getQuotes(instrumentId);
    }

}