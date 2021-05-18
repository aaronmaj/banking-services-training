package com.banque.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
@WebService(name = "BanqueWebservice")
public interface BanqueWebservice {
    @WebMethod(operationName = "auth", exclude = false)
    public abstract Client authentifier(long idClient, String password);

    @WebMethod(operationName = "comptes", exclude = false)
    public abstract List<Compte> comptes(long idClient);

    @WebMethod(operationName = "comptes", exclude = false)
    public abstract List<Client> clients(long idClient);

    @WebMethod(operationName = "virement", exclude = false)
    public abstract void virement(long numeroDebit, long numeroCredit, double montant);

}
