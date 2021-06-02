## banking-services

Example de projet pour une formation dispensée sur les Web Services en Java.  
Le projet comporte 5 modules
1. Un module pour la persistance des données : __banking-core__
2. Un module pour les Web Services de type SOAP : __banking-ws__
3. Un module pour les Web Services de type REST : __banking-rest__
4. Un module pour les Clients SOAP : __client-soap__
5. Un module pour les Clients REST : __client-rest__

## Mise en place et développement
Les Web Services utilisent l’implémentation __APACHE CXF__
Pour chaque projet de Web Service utiliser l'archetype suivant pour generer le squelette du projet:
`mvn archetype:generate  -Dfilter=org.apache.cxf.archetype:`
L'execution de la commande prompte une série de choix qui vous guideront à la création du POM de votre projet

## Configuration de la base de données 
Pour le module d’accès aux bases de données`banking-core`, éditez le fichier `src/main/resources/META-INF/persistence.xml` 
et configurez les informations relatives à votre base de données :
```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="banking-pu" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>com.banque.services.core.model.Client</class>
        <class>com.banque.services.core.model.Compte</class>
        <class>com.banque.services.core.model.Transaction</class>
        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/CoreBanking"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="a@@812pas"/>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect"/>
            <property name="hibernate.useUnicode" value="true"/>
            <property name="hibernate.characterEncoding" value="utf-8"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>
```
## Builds et deploiement
- Lancez la commande `mvn clean install` pour compiler chaque module ou tous les modules a la fois
- Placez le(s) fichier(s) .war file (banking-ws.war, banking-services,..) dans le repertoire `webapps` de Tomcat
