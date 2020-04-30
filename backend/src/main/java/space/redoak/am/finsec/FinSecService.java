package space.redoak.am.finsec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FinSecService {

    @Autowired private ExchangeRepository exchangeRepository;
    @Autowired private QuoteRepository quoteRepository;
    @Autowired private DebentureRepository debentureRepository;



    public List<Exchange> getExchanges() {
        return exchangeRepository.findAll();
    }


    public List<Quote> getQuotes(final Integer instrumentId) {
        return quoteRepository.getQuotes(instrumentId);
    }

    public Page<DebentureEntity> getDebentures(Pageable pageRequest) {
        return debentureRepository.findAll(pageRequest);
    }

}