package space.redoak.am.finsec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finsec")
public class FinSecController {


    @GetMapping(value = "/quotes/{symbol}")
    public List<Float> getQuotes(@PathVariable String symbol) {

        List<Float> list = new ArrayList<>();
        list.add(1.25f);
        list.add(1.30f);
        list.add(1.28f);

        return list;

    }
     
}