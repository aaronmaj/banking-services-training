package com.banque.services.core.persistence;


import com.banque.services.core.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientDao {
    List<Client> findAll();
    Optional<Client> findbyId(Integer id);
    Integer save(Client compte);
    void delete(Client compte);
}
