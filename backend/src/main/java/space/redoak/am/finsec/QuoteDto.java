package space.redoak.am.finsec;

import java.time.LocalDate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QuoteDto {

    private final Integer id;
    private final Integer instrumentId;
    private final LocalDate readDte;
    private final Float closePrice;
    private final Integer volumeTraded;

}