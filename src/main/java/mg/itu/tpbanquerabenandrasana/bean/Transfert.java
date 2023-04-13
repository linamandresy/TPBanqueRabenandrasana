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
@Named(value = "transfert")
@RequestScoped
public class Transfert {

    @EJB
    private GestionnaireCompte gc;
    
    private CompteBancaire debit;
    private CompteBancaire credit;
    private int amount;

    public CompteBancaire getDebit() {
        return debit;
    }

    public void setDebit(CompteBancaire debit) {
        this.debit = debit;
    }

    public CompteBancaire getCredit() {
        return credit;
    }

    public void setCredit(CompteBancaire credit) {
        this.credit = credit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    /**
     * Creates a new instance of Transfert
     */
    public Transfert() {
    }
    
    public String transferer() {
        gc.transferer(debit, credit, amount);
        return "listeComptes?faces-redirect=true";
    }
}
