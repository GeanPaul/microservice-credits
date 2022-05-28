package com.nttdata.app.service;

import com.nttdata.app.document.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditService {

    Flux<Credit> getAllCredit();

    Mono<Credit> getFindAllByIdCredit(String id);

    Mono<Credit> createCredit(Credit credit);

    Mono<Credit> updateCredit(Credit credit);

    Mono<Void> deleteCredit(Credit credit);
}
