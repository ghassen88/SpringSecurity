package com.example.demo.Repositories;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Etudiant;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

}
