/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.rest;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.modelo.Libro;
import java.util.List;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/libros")
public class LibroRest {
    
    @EJB
    private LibroFacade libroFacade;

    @EJB
    private CapituloFacade capituloFacade;

    @EJB
    private AutorFacade autorFacade;
    
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        
        System.out.println("Entrando al metodo get del productos");
        Jsonb jsonb = JsonbBuilder.create();
        
        List<Libro> libro = libroFacade.findAll();
        return Response.ok(jsonb.toJson(libro)).header("Access-Control-Allow-Origin", "*").build();
        
    }
    
}
