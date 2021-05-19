package com.banque.services.soap;

import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.model.Transaction;
import com.banque.services.core.service.CorebankingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@WebService
@XmlSeeAlso(AuthenticationHeader.class)
public class BanqueWebserviceImpl implements BanqueWebservice{

    @Autowired
    private CorebankingService corebankingService;

    @Override
    public List<Compte> comptes(AuthenticationHeader  authenticationHeader) {
        return corebankingService.comptes();
    }

    @Override
    public List<Client> clients(AuthenticationHeader  authenticationHeader) {
        return corebankingService.clients();
    }

    @Override
    public void virement(String numeroDebit, String numeroCredit, double montant, String description,AuthenticationHeader  authenticationHeader) {

    }

    @Override
    public double retrait(String numeroRetrait, double montant, String description,AuthenticationHeader  authenticationHeader) {
        return 0;
    }

    @Override
    public void depot(String numeroDepot, double montant, String description,AuthenticationHeader  authenticationHeader) {

    }

    @Override
    public double balance(String numeroCompte,AuthenticationHeader  authenticationHeader) {
        return 0;
    }

    @Override
    public List<Transaction> historique(String numeroCompte,AuthenticationHeader  authenticationHeader) {
        return null;
    }
}
