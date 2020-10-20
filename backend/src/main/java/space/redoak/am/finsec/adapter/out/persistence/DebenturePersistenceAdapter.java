package space.redoak.am.finsec.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import space.redoak.am.common.PersistenceAdapter;
import space.redoak.am.finsec.domain.Debenture;
import space.redoak.am.finsec.application.port.out.DebenturePort;


/**
 *
 * @author glenn
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class DebenturePersistenceAdapter implements DebenturePort {

    
    private final DebentureRepository debentureRepository;
    private final DebentureMapper debentureMapper;
    
    
    @Override
    public Page<Debenture> loadDebentures(Pageable pageRequest) {
        Page<DebentureEntity> entities = debentureRepository.findAll(pageRequest);
        Page<Debenture> pageableDebentures = debentureMapper.mapEntitiesToDomain(entities);
        return pageableDebentures;
    }
    
}
