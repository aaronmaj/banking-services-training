package com.banque.services.client;

import com.banque.services.soap.*;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import javax.xml.namespace.QName;

public class JaxWsProxyFactoryClient {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setWsdlLocation("http://18.221.54.25:8080/banque-webservice/banking?wsdl");
        factoryBean.setAddress("http://18.221.54.25:8080/banque-webservice/banking");
        factoryBean.setServiceName(
                new QName("http://soap.services.banque.com", "BanqueWebserviceSoapPort"));
        factoryBean.setServiceClass(BanqueWebserviceSoapPort.class);

        BanqueWebserviceSoapPort soapPort = (BanqueWebserviceSoapPort) factoryBean.create();

        Client client = soapPort.requeteClient("531.134/120.786");
        Compte compte = new Compte();
        compte.setNumero("21013120");
        compte.setIntitule(client.getNom() + " "+client.getPrenom());
        compte.setType(Type.COURANT);
        compte.setStatus(Status.OUVERT);
        compte.setCategorie(Categorie.INDIVIDUEL);
        compte.setSolde(50_000.0);
        compte.setClient(client);
        soapPort.requeteCreerCompte(compte);
    }
}
