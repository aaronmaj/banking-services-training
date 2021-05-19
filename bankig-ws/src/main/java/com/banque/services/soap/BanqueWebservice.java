package com.banque.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
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

    @WebMethod(operationName = "requeteAjoutClient", exclude = false)
    @WebResult(name="reponseAjoutClient")
    public abstract String ajouterClient(@WebParam(name = "client") @XmlElement(required = true)Client client);
    @WebMethod(operationName = "requeteCreerCompte", exclude = false)
    @WebResult(name="reponseCreerCompte")
    public abstract String creerCompte(@WebParam(name = "compte") @XmlElement(required = true)Compte compte);

    @WebMethod(operationName = "listeComptes", exclude = false)
    @WebResult(name="listeCompteReponse")
    public abstract List<Compte> comptes(@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "listeClients", exclude = false)
    @WebResult(name="listeClientsReponse")
    public abstract List<Client> clients(@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "requetVirement", exclude = false)
    @WebResult(name="reponseVirement")
    public abstract String virement(@WebParam(name = "numeroDebit") @XmlElement(required = true) String numeroDebit, @WebParam(name = "numeroCredit")@XmlElement(required = true)String numeroCredit, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "requeteRetrait", exclude = false)
    @WebResult(name="reponseRetrait")
    public abstract double retrait(@WebParam(name = "numeroRetrait")@XmlElement(required = true)String numeroRetrait, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description, @WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "requeteDepot", exclude = false)
    @WebResult(name="reponseDepot")
    public abstract String depot(@WebParam(name = "numeroDepot")@XmlElement(required = true)String numeroDepot, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "requeteBalance", exclude = false)
    @WebResult(name="reponseBalance")
    public abstract double balance(@WebParam(name = "numeroCompte")@XmlElement(required = true)String numeroCompte,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "requeteHistorique", exclude = false)
    @WebResult(name="reponseHistorique")
    public abstract List<Transaction> historique(@WebParam(name = "numeroCompte")@XmlElement(required = true)String  numeroCompte,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);
}
