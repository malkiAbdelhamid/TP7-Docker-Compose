package com.esi.msscolaritemongo;

import com.esi.msscolaritemongo.entities.Etablissement;
import com.esi.msscolaritemongo.entities.Etudiant;
import com.esi.msscolaritemongo.repositories.EtablissementRepository;
import com.esi.msscolaritemongo.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class MsScolariteMongoApplication implements CommandLineRunner {

    @Autowired
    EtablissementRepository etablissementRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsScolariteMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Etablissement e1=etablissementRepository.save(new Etablissement(1L,"esi-sba",null));
        Etablissement e2=etablissementRepository.save(new Etablissement(2L,"univ-sba",null));

        etudiantRepository.save(new Etudiant(1L,"malki", Date.valueOf("1999-01-01"),"4isi",null,e1,1L,null,null));
        etudiantRepository.save(new Etudiant(2L,"ali", Date.valueOf("1995-08-11"),"4siw",null,e1,2L,null,null));
        etudiantRepository.save(new Etudiant(3L,"karim", Date.valueOf("1996-11-22"),"MatserSiC",null,e2,1L,null,null));
        etudiantRepository.save(new Etudiant(4L,"fouad", Date.valueOf("2000-02-15"),"MasterSiR",null,e2,1L,null,null));

    }
}

