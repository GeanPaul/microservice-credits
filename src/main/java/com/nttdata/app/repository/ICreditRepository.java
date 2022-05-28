package com.nttdata.app.repository;

import com.nttdata.app.document.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICreditRepository  extends ReactiveMongoRepository<Credit,String> {
}
