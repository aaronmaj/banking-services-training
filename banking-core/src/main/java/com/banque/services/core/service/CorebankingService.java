package com.banque.services.core.service;

import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.persistence.jpa.JpaClientDao;
import com.banque.services.core.persistence.jpa.JpaCompteDao;

import java.util.List;

public class CorebankingService {
    private final JpaClientDao clientDao;
    private final JpaCompteDao compteDao;

    public CorebankingService(JpaClientDao clientDao, JpaCompteDao compteDao) {
        this.clientDao = clientDao;
        this.compteDao = compteDao;
    }

    public List<Compte> comptes(){
        return compteDao.findAll();
    }

    public List<Client> clients(){
        return clientDao.findAll();
    }

    public double balance(String numCompte){
        return compteDao.findbyNum(numCompte).get().getSolde();
    }

    public void creerClient(Client client){
        clientDao.save(client);
    }
    public void creerComptet(Compte compte){
        compteDao.save(compte);
    }
}
