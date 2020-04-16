package space.redoak.am.finsec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sm_exchange")
public class Exchange {

    private static final Long serialVersionUID = 1L;


    @Id
    private Integer id;
    private String symbol;
    private String descr;
  
}