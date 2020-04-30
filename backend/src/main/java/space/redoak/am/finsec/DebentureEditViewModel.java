package space.redoak.am.finsec;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter @Setter
public class DebentureEditViewModel {
    private Integer instrumentId;
    private LocalDate issueDte;
    private String underlyingSymbol;
    private Float conversionPrice;
    private Float conversionRate;
    private String prospectus;
    private String comments;
}
