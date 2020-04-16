package space.redoak.am.finsec;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface ExchangeRepository extends Repository<Exchange, Long> {

    List<Exchange> findAll();

}