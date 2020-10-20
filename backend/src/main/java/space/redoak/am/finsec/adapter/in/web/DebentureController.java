package space.redoak.am.finsec.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.redoak.am.common.WebAdapter;
import space.redoak.am.finsec.domain.Debenture;
import space.redoak.am.finsec.application.port.in.DebentureUseCases;

/**
 *
 * @author glenn
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/finsec")
public class DebentureController {
    
    private final DebentureUseCases debentureUseCases;
    private final DebentureDtoMapper debentureDtoMapper;
    
    @GetMapping(value = "/debentures")
    public Page<DebentureDto> getDebentures(Pageable pageRequest) {
        Page<Debenture> debenturePage = debentureUseCases.getDebentures(pageRequest);
        return debentureDtoMapper.mapDebenturePageToDebentureDtoPage(debenturePage);
    }

    
}
