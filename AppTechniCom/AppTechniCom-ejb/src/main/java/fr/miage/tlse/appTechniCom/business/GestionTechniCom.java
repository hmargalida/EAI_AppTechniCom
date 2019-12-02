/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.tlse.appTechniCom.business;

import fr.miage.tlse.appTechniCom.export.Competence;
import fr.miage.tlse.appTechniCom.export.Equipement;
import fr.miage.tlse.appTechniCom.export.FormateurExport;
import fr.miage.tlse.appTechniCom.export.FormateursTableExport;
import fr.miage.tlse.appTechniCom.export.FormationExport;
import fr.miage.tlse.appTechniCom.export.SalleExport;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Heloise
 */
@Stateless
public class GestionTechniCom implements GestionTechniComLocal {

    @Override
    public List<FormateurExport> getFormateursCompetents() {
        // AVANT JMS : création d'un jeu de données pour tester la fonction
        // JMS : Réception de la liste de tous les formateurs et de la formation en question
        List<FormateurExport> tousLesFormateurs = new ArrayList<>();
        List<Competence> competences1 = new ArrayList<>();
        competences1.add(Competence.BD);
        competences1.add(Competence.JAVA);
        List<Competence> competences2 = new ArrayList<>();
        competences2.add(Competence.GESTIONPROJET);
        FormateurExport formateur1 = new FormateurExport(0, competences1);
        FormateurExport formateur2 = new FormateurExport(1, competences2);
        tousLesFormateurs.add(formateur1);        
        tousLesFormateurs.add(formateur2);
        List<Competence> competences = new ArrayList<>();
        competences.add(Competence.BD);
        competences.add(Competence.JAVA);
        FormationExport formation = new FormationExport(0);
        formation.setCompetencesRequises(competences);
        
        List<FormateurExport> formateursCompetents = new ArrayList<>();
        for(FormateurExport formateur : tousLesFormateurs) {
            if(formateur.getCompetences().containsAll(formation.getCompetencesRequises())) {
                formateursCompetents.add(formateur);
            }
        }
        return formateursCompetents;
    }

    @Override
    public List<SalleExport> getSallesEquipees() {
        // AVANT DE METTRE EN PLACE LE JMS
        List<SalleExport> toutesLesSalles = new ArrayList<>();
        List<Equipement> equipement = new ArrayList<>();
        FormationExport formation = new FormationExport(0);
        formation.setEquipementsRequis(equipement);
        
        List<SalleExport> sallesEquipees = new ArrayList<>();
        for(SalleExport salle : toutesLesSalles) {
            if(salle.getListeEquipements().containsAll(formation.getEquipementsRequis())) {
                sallesEquipees.add(salle);
            }
        }
        return sallesEquipees;
    }
    
    @Override
    public void printMessage(FormateursTableExport formateurs) {
        System.out.println(formateurs.toString());
    }
}
