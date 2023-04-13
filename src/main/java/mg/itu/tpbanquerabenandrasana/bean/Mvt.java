/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquerabenandrasana.bean;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import mg.itu.tpbanquerabenandrasana.ejb.GestionnaireCompte;
import mg.itu.tpbanquerabenandrasana.entities.CompteBancaire;

/**
 *
 * @author mandr
 */
@Named(value = "mvt")
@Dependent
public class Mvt {

    @EJB
    private GestionnaireCompte gc;

    private String idCompte;
    private CompteBancaire cb;

    /**
     * Creates a new instance of Mvt
     */
    public Mvt() {
    }

    public void loadCompte() {
        cb = gc.findById(idCompte);
        System.out.println("XXXXXXXXXXXmg.itu.tpbanquerabenandrasana.bean.Mvt.loadCompte()");
    }

    public String getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(String idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCb() {
        return cb;
    }

    public void setCb(CompteBancaire cb) {
        this.cb = cb;
    }

}
