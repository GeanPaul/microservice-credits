package com.nttdata.app.service.impl;

import com.nttdata.app.document.Credit;
import com.nttdata.app.repository.ICreditRepository;
import com.nttdata.app.service.ICreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements ICreditService {

    @Autowired
    private ICreditRepository creditRepository;


    @Override
    public Flux<Credit> getAllCredit() {
        return creditRepository.findAll();
    }

    @Override
    public Mono<Credit> getFindAllByIdCredit(String id) {
        return creditRepository.findById(id);
    }

    @Override
    public Mono<Credit> createCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Mono<Credit> updateCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Mono<Void> deleteCredit(Credit credit) {
        return creditRepository.delete(credit);
    }
}
