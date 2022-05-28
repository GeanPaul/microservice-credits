package com.nttdata.app.controller;

import com.nttdata.app.document.Credit;
import com.nttdata.app.service.impl.CreditServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    private CreditServiceImpl creditServiceImpl;


    @GetMapping
    public Flux<Credit> findAllCredit() {
        log.info("Credits get All");
        return creditServiceImpl.getAllCredit();

    }

    @GetMapping("/{id}")
    public Mono<Credit> findAllCreditById(@PathVariable String id) {
        log.info("Credits get id: " + id);
        return creditServiceImpl.getFindAllByIdCredit(id);

    }

    @PostMapping("/create")
    public Mono<Credit> saveCredit(@RequestBody Credit credit) {
        log.info("Credit created \n" + credit.toString());
        return creditServiceImpl.createCredit(credit);

    }

    @PutMapping("/update")
    public Mono<Credit> updateCredit(@RequestBody Credit credit) {

        Mono<Credit> mono = creditServiceImpl.getFindAllByIdCredit(credit.getIdCredit());
        return mono.flatMap(ac -> {
            ac.setTypeCredit(credit.getTypeCredit());
            ac.setNumberCredit(credit.getNumberCredit());
            ac.setCreditAmount(credit.getCreditAmount());
            ac.setAvailableBalance(credit.getAvailableBalance());
            ac.setIdCustomer(credit.getIdCustomer());
            log.info("Credits by id: " + credit.getIdCredit() + " " + "updated");
            return creditServiceImpl.updateCredit(ac);
        });
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCredit(@PathVariable String id) {
        Mono<Credit> mono = creditServiceImpl.getFindAllByIdCredit(id);
        return mono.flatMap(ac -> {
            log.info("Savings Account by id: " + id + " " + "delete");
            return creditServiceImpl.deleteCredit(ac);
        });


    }






}
