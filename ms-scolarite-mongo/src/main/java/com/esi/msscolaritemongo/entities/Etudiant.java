package com.esi.msscolaritemongo.entities;



import com.esi.msscolaritemongo.model.Formation;
import com.esi.msscolaritemongo.model.Virement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {

    @Id
    private Long idEtudiant;

    private String nom;


    private Date dateN;

    private String promo;

    private Date dateInscription;


    @DBRef
    private Etablissement etablissement;

    private Long idFormation;

      @Transient
      private Formation formation;

      @Transient
    List<Virement> virements;

}
