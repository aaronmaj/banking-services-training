package com.banque.services.soap;

import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.model.Transaction;
import com.banque.services.core.service.CorebankingService;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@WebService(portName = "BanqueWebserviceSoapPort", serviceName = "BanqueWebservice", targetNamespace = "http://soap.services.banque.com", endpointInterface = "com.banque.services.soap.BanqueWebservice")
@XmlSeeAlso(AuthenticationHeader.class)
public class BanqueWebserviceImpl implements BanqueWebservice{

    private CorebankingService corebankingService;
    {
        corebankingService = new CorebankingService();
    }
    @Override
    public String ajouterClient(Client client) {
        corebankingService.creerClient(client);
        return "SUCCESS";
    }

    @Override
    public Client client(String cni) {
        return corebankingService.requeteClient(cni);
    }

    @Override
    public String creerCompte(Compte compte) {
        corebankingService.creerCompte(compte);
        return "SUCCESS";
    }

    @Override
    public List<Compte> comptes(AuthenticationHeader  authenticationHeader) {
        return corebankingService.comptes();

    }

    @Override
    public List<Client> clients(AuthenticationHeader  authenticationHeader) {
        return corebankingService.clients();
    }

    @Override
    public String virement(String numeroDebit, String numeroCredit, double montant, String description,AuthenticationHeader  authenticationHeader) {
        return "";
    }

    @Override
    public double retrait(String numeroRetrait, double montant, String description,AuthenticationHeader  authenticationHeader) {
        return 0;
    }

    @Override
    public String depot(String numeroDepot, double montant, String description,AuthenticationHeader  authenticationHeader) {
        return "SUCCESS";
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
