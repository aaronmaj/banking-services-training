package com.banque.services.core.persistence.jdbc;


import com.banque.services.core.model.Client;
import com.banque.services.core.persistence.ClientDao;

import java.util.List;
import java.util.Optional;

public class ClientJdbc implements ClientDao {
    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Optional<Client> findbyId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Integer save(Client compte) {
        return null;
    }

    @Override
    public void delete(Client compte) {

    }
}
