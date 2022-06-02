package com.nttdata.app.repository;

import com.nttdata.app.document.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ICreditRepository  extends ReactiveMongoRepository<Credit,String> {

    Mono<Credit> findByIdCustomer(String idCustomer);
    Flux<Credit> findAllByIdCustomer(String idCustomer);

}
