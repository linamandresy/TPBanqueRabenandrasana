/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquerabenandrasana.ejb;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import mg.itu.tpbanquerabenandrasana.entities.CompteBancaire;

/**
 *
 * @author mandr
 */
@Stateless
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root",
        password = "root",
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true"
        }
)
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;
    
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }
    
    public List<CompteBancaire> getAllComptes() {
        TypedQuery<CompteBancaire> query = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class); //em.createNamedQuery("CompteBancaire.findAll");
        return query.getResultList();
    }

    public int nbComptes() {
        Query query = em.createQuery("select count(c) from CompteBancaire c");
        return Integer.valueOf(query.getSingleResult().toString());
    }
    
    public CompteBancaire findById(String id) {
        return em.find(CompteBancaire.class, Long.valueOf(id));
    }
    
    public void transferer(CompteBancaire debit, CompteBancaire credit, int amount) {
        if(credit.getId()==debit.getId()) throw new EJBException("Compte de débit et crédit identique");
        debit = em.merge(debit);
        credit = em.merge(credit);
        debit.retirer(amount);
        credit.deposer(amount);
    }
}
