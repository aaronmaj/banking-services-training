package com.banque.services.soap;

import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.model.Transaction;
import com.banque.services.core.service.CorebankingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService
public class BanqueWebserviceImpl implements BanqueWebservice{

    @Autowired
    private CorebankingService corebankingService;

    @Override
    public List<Compte> comptes() {
        return corebankingService.comptes();
    }

    @Override
    public List<Client> clients() {
        return corebankingService.clients();
    }

    @Override
    public void virement(String numeroDebit, String numeroCredit, double montant, String description) {

    }

    @Override
    public double retrait(String numeroRetrait, double montant, String description) {
        return 0;
    }

    @Override
    public void virement(String numeroDepot, double montant, String description) {

    }

    @Override
    public double balance(String numeroCompte) {
        return 0;
    }

    @Override
    public List<Transaction> historique(String numeroCompte) {
        return null;
    }
}
