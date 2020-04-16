package space.redoak.am.finsec;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sm_eod_quote")
public class Quote {
    
    private static final Long serialVersionUID = 1L;


    @Id
    private Integer id;
    private Integer instrumentId;
    private LocalDate readDte;
    private Float closePrice;
    private Integer volumeTraded;
    
}