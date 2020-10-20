package space.redoak.am.finsec.application.port.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import space.redoak.am.finsec.domain.Debenture;


/**
 * Use Cases associated with debentures.
 *
 * @author glenn
 */
public interface DebentureUseCases {

    /**
     * Retrieve all debentures from the exchange.
     * 
     * @param pageRequest
     * @return 
     */
    public Page<Debenture> getDebentures(Pageable pageRequest);

}
