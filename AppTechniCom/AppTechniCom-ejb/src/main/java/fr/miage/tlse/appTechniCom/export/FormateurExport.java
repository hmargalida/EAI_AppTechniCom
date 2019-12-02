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
public class FormateurExport {
    
    private long idFormateur;
    private List<Competence> competences;
    
    public FormateurExport(long idFormateur, List<Competence> competences) {
        this.idFormateur = idFormateur;
        this.competences = competences;
    }

    public long getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(long idFormateur) {
        this.idFormateur = idFormateur;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }
}
