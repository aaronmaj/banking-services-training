package com.banque.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.model.Transaction;

@WebService(name = "BanqueWebservice")
public interface BanqueWebservice {

    @WebMethod(operationName = "comptes", exclude = false)
    public abstract List<Compte> comptes();

    @WebMethod(operationName = "comptes", exclude = false)
    public abstract List<Client> clients();

    @WebMethod(operationName = "virement", exclude = false)
    public abstract void virement(String numeroDebit, String numeroCredit, double montant, String description);

    @WebMethod(operationName = "retrait", exclude = false)
    public abstract double retrait(String numeroRetrait, double montant, String description);

    @WebMethod(operationName = "depot", exclude = false)
    public abstract void virement(String numeroDepot, double montant, String description);

    @WebMethod(operationName = "depot", exclude = false)
    public abstract double balance(String numeroCompte);

    @WebMethod(operationName = "depot", exclude = false)
    public abstract List<Transaction> historique(String  numeroCompte);
}
