/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquerabenandrasana.converter;

import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import mg.itu.tpbanquerabenandrasana.ejb.GestionnaireCompte;
import mg.itu.tpbanquerabenandrasana.entities.CompteBancaire;

/**
 *
 * @author mandr
 */
@FacesConverter(value="compteBancaireConverter",managed = true)
public class CompteBancaireConverter implements Converter<CompteBancaire>{

    @EJB
    private GestionnaireCompte gc;
    
    @Override
    public CompteBancaire getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null) return null;
        return gc.findById(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, CompteBancaire compteBancaire) {
        if(compteBancaire==null) return "";
        return String.valueOf(compteBancaire.getId());
    }
;
    
}
