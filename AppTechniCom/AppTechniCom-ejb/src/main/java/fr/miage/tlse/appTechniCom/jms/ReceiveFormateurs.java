/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.tlse.appTechniCom.jms;

import fr.miage.tlse.appTechniCom.business.GestionTechniCom;
import fr.miage.tlse.appTechniCom.export.FormateursTableExport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Heloise
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "Formateurs")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class ReceiveFormateurs implements MessageListener {
    
    
    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        try {
            FormateursTableExport formateurs = (FormateursTableExport) objectMessage.getObject();
            System.out.println("test test");
        } catch (JMSException ex) {
            Logger.getLogger(ReceiveFormateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
