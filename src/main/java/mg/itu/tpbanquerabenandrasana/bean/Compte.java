/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquerabenandrasana.bean;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import mg.itu.tpbanquerabenandrasana.ejb.GestionnaireCompte;
import mg.itu.tpbanquerabenandrasana.entities.CompteBancaire;

/**
 *
 * @author mandr
 */
@Named(value = "compte")
@RequestScoped
public class Compte {

    @EJB
    private GestionnaireCompte gc;
    
    private String nom ;
    private int solde;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    
    /**
     * Creates a new instance of Compte
     */
    public Compte() {
    }
    
    public String creer(){
        CompteBancaire cb = new CompteBancaire(nom, solde);
        gc.creerCompte(cb);
        return "listeComptes";
    }
}
