package com.banque.services.core.persistence;

import com.banque.services.core.model.Compte;

import java.util.List;
import java.util.Optional;

public interface CompteDao {
    List<Compte> findAll();
    Optional<Compte> findbyId(Integer id);
    Integer save(Compte Compte);
    void delete(Compte Compte);

}
