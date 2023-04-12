/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquerabenandrasana.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mg.itu.tpbanquerabenandrasana.entities.CompteBancaire;

/**
 *
 * @author mandr
 */
@Singleton
@Startup
public class Init {

    @EJB
    private GestionnaireCompte gc;

    @PostConstruct
    public void init() {
        if (gc.nbComptes() == 0) {
            CompteBancaire john = new CompteBancaire("John Lennon", 150000);
            CompteBancaire paul = new CompteBancaire("Paul McCartney", 950000);
            CompteBancaire ringo = new CompteBancaire("Ringo Starr", 20000);
            CompteBancaire georges = new CompteBancaire("Georges Harrisson", 100000);
            gc.creerCompte(paul);
            gc.creerCompte(john);
            gc.creerCompte(ringo);
            gc.creerCompte(georges);
        }

    }
}
