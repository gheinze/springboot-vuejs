package space.redoak.am.finsec;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

        List<Quote> quotes = finSecService.getQuotes(instrumentId);

        return quotes.stream()
            .map(q -> quoteDtoMapper.map(q))
            .collect(Collectors.toList())
            ;

    }

    @GetMapping(value = "/debentures")
    public Page<DebentureEntity> getDebentures(Pageable pageRequest) {
        return finSecService.getDebentures(pageRequest);
    }


    @PostMapping(value = "/debenture/{instrumentId}")
    public void updateDebentureDetails(
            @PathVariable Integer instrumentId,
            @RequestBody DebentureEditViewModel model
    ) {
        System.out.println("Model comments: " + model.getComments());
        
    }
    
}