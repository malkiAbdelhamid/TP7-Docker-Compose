package com.esi.msscolaritemongo.repositories;


import com.esi.msscolaritemongo.entities.Etablissement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EtablissementRepository
        extends MongoRepository<Etablissement, Long> {
}