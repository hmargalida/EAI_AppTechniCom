/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.tlse.appTechniCom.export;

import java.util.List;

/**
 *
 * @author Heloise
 */
public class FormationExport {
    
    private long idFormation;
    private List<Competence> competencesRequises;
    private List<Equipement> equipementsRequis;
    
    public FormationExport(long idFormation) {
        this.idFormation = idFormation;
    }

    public FormationExport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(long idFormation) {
        this.idFormation = idFormation;
    }

    public List<Competence> getCompetencesRequises() {
        return competencesRequises;
    }

    public void setCompetencesRequises(List<Competence> competencesRequises) {
        this.competencesRequises = competencesRequises;
    }

    public List<Equipement> getEquipementsRequis() {
        return equipementsRequis;
    }

    public void setEquipementsRequis(List<Equipement> equipementsRequis) {
        this.equipementsRequis = equipementsRequis;
    }
    
}
