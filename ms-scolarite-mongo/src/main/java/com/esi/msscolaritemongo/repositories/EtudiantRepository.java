package com.esi.msscolaritemongo.repositories;

import com.esi.msscolaritemongo.entities.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EtudiantRepository extends MongoRepository<Etudiant, Long> {
    List<Etudiant> findEtudiantByIdFormation(Long idf);

}