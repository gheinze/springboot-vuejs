package space.redoak.am.finsec.application.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import space.redoak.am.finsec.domain.Debenture;


/**
 *
 * @author glenn
 */
public interface DebenturePort {

    Page<Debenture> loadDebentures(Pageable pageRequest);

}
