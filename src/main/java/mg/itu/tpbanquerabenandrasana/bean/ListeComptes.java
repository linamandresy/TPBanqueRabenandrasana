/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquerabenandrasana.bean;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpbanquerabenandrasana.ejb.GestionnaireCompte;
import mg.itu.tpbanquerabenandrasana.entities.CompteBancaire;

/**
 *
 * @author mandr
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @EJB
    GestionnaireCompte gc;

    private List<CompteBancaire> allComptes;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (allComptes == null) {
            allComptes = gc.getAllComptes();
        }
        return allComptes;
    }

}
