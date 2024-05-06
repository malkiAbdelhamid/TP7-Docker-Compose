package com.esi.msscolaritemongo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Etablissement {

    @Id
    private Long idEtablissement;
    private String nom;

    @JsonIgnore
    @DBRef
    private Collection<Etudiant> etudiants;
}
