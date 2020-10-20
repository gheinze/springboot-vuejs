package space.redoak.am.finsec.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import space.redoak.am.common.UseCase;
import space.redoak.am.finsec.domain.Debenture;
import space.redoak.am.finsec.application.port.in.DebentureUseCases;
import space.redoak.am.finsec.application.port.out.DebenturePort;

/**
 *
 * @author glenn
 */
@RequiredArgsConstructor
@UseCase
public class DebentureService implements DebentureUseCases {

    private final DebenturePort loadDebenturesPort;
    
    @Override
    public Page<Debenture> getDebentures(Pageable pageRequest) {
        return loadDebenturesPort.loadDebentures(pageRequest);
    }
    
}
