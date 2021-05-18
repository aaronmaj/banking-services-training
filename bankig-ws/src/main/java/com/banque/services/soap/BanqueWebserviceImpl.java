package com.banque.services.soap;

import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.persistence.jpa.JpaClientDao;
import com.banque.services.core.persistence.jpa.JpaCompteDao;

import javax.jws.WebService;
import java.util.List;

@WebService
public class BanqueWebserviceImpl implements BanqueWebservice{

    private JpaCompteDao jpaCompteDao;
    private JpaClientDao jpaClientDao;

    @Override
    public Client authentifier(long idClient, String password) {
        return null;
    }

    @Override
    public List<Compte> comptes(long idClient) {
        return null;
    }

    @Override
    public List<Client> clients(long idClient) {
        return null;
    }

    @Override
    public void virement(long numeroDebit, long numeroCredit, double montant) {

    }
}
