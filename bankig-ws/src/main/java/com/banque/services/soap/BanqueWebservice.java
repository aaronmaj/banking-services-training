package com.banque.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;
import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.model.Transaction;

@WebService(name = "BanqueWebserviceSoapPort", targetNamespace = "http://soap.services.banque.com")
@XmlSeeAlso(AuthenticationHeader.class)
public interface BanqueWebservice {

    @WebMethod(operationName = "ajouterClientRequest", exclude = false)
    public abstract void ajouterClient(@WebParam(name = "client") @XmlElement(required = true)Client client);
    @WebMethod(operationName = "creerCompteRequest", exclude = false)
    public abstract void creerCompteRequest(@WebParam(name = "compte") @XmlElement(required = true)Compte compte);

    @WebMethod(operationName = "comptesRequest", exclude = false)
    public abstract List<Compte> comptes(@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "clientsRequest", exclude = false)
    public abstract List<Client> clients(@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "virementRequest", exclude = false)
    public abstract void virement(@WebParam(name = "numeroDebit") @XmlElement(required = true) String numeroDebit, @WebParam(name = "numeroCredit")@XmlElement(required = true)String numeroCredit, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "retraitRequest", exclude = false)
    public abstract double retrait(@WebParam(name = "numeroRetrait")@XmlElement(required = true)String numeroRetrait, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description, @WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "depotRequest", exclude = false)
    public abstract void depot(@WebParam(name = "numeroDepot")@XmlElement(required = true)String numeroDepot, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "balanceRequest", exclude = false)
    public abstract double balance(@WebParam(name = "numeroCompte")@XmlElement(required = true)String numeroCompte,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "historiqueRequest", exclude = false)
    public abstract List<Transaction> historique(@WebParam(name = "numeroCompte")@XmlElement(required = true)String  numeroCompte,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);
}
