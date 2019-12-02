/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.tlse.appTechniCom.business;

import fr.miage.tlse.appTechniCom.export.FormateurExport;
import fr.miage.tlse.appTechniCom.export.FormateursTableExport;
import fr.miage.tlse.appTechniCom.export.SalleExport;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heloise
 */
@Local
public interface GestionTechniComLocal {
    
    public List<FormateurExport> getFormateursCompetents();    
    
    public List<SalleExport> getSallesEquipees();
    
    public void printMessage(FormateursTableExport formateurs);

}
