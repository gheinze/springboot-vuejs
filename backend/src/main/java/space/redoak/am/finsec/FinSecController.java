package space.redoak.am.finsec;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/finsec")
public class FinSecController {

    @Autowired private FinSecService finSecService;
    @Autowired private QuoteDtoMapper quoteDtoMapper;


    @GetMapping(value = "/exchanges")
    public List<Exchange> getExchanges() {
        return finSecService.getExchanges();
    }


    @GetMapping(value = "/quotes/{instrumentId}")
    public List<QuoteDto> getQuotes(@PathVariable Integer instrumentId) {

        List<Quote> quotes = finSecService.getQuotes(1);

        return quotes.stream()
            .map(q -> quoteDtoMapper.map(q))
            .collect(Collectors.toList())
            ;

    }
     
}