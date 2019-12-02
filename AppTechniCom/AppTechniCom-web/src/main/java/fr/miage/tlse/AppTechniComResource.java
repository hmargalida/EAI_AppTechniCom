/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.tlse;

import com.google.gson.Gson;
import fr.miage.tlse.appTechniCom.business.GestionTechniComLocal;
import fr.miage.tlse.appTechniCom.export.FormateurExport;
import fr.miage.tlse.appTechniCom.export.SalleExport;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Heloise
 */
@Path("appTechnicom")
@RequestScoped
public class AppTechniComResource {

    GestionTechniComLocal gestionTechniCom = lookupGestionTechniComLocal();

    @Context
    private UriInfo context;
    
    private final GestionTechniComLocal gestionFormateur = lookupGestionTechniComLocal();
    
    private final Gson gson = new Gson();

    /**
     * Creates a new instance of AppTechnicomResource
     */
    public AppTechniComResource() {
    }

    /**
     * Retrieves representation of an instance of fr.miage.tlse.AppTechnicomResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AppTechnicomResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    private GestionTechniComLocal lookupGestionTechniComLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (GestionTechniComLocal) c.lookup("java:global/AppTechniCom-ear/AppTechniCom-web-1.0-SNAPSHOT/GestionTechniCom!fr.miage.tlse.appTechniCom.business.GestionTechniComLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    @Path("getFormateursCompetents") 
    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public String getFormateursCompetents() {
        List<FormateurExport> formateursCompetents = gestionTechniCom.getFormateursCompetents();
        String jsonString = gson.toJson(formateursCompetents);
        return jsonString;
    }
    
    @Path("getSallesEquipees") 
    @Produces(MediaType.APPLICATION_JSON)
    @GET()
    public String getSallesEquipees() {
        List<SalleExport> sallesEquipees = gestionTechniCom.getSallesEquipees();
        String jsonString = gson.toJson(sallesEquipees);
        return jsonString;
    }
}
