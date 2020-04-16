package space.redoak.am.finsec;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 */
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query(value = "SELECT *" +
            "  FROM sm_eod_quote" +
            "  WHERE instrument_id = :instrumentId" +
            "  ORDER BY read_dte"
            ,nativeQuery = true)
    List<Quote> getQuotes(@Param("instrumentId") Integer instrumentId);
}

