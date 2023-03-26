package com.example.mdbspringboot.creditAccounts;

import org.springframework.data.mongodb.repository.MongoRepository;

//@Repository
public interface CreditsRepository extends MongoRepository<Credits, String> {
}
