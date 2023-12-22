package edu.upc.dsa.services;

import edu.upc.dsa.DenunciaManager;
import edu.upc.dsa.DenunciaManagerImp;
import edu.upc.dsa.models.Denuncia;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/denuncia", description = "Endpoint to denuncia Service")
@Path("/denuncia")
public class DenunciaService {
    private DenunciaManager dm;

    public DenunciaService(){
        this.dm = DenunciaManagerImp.getInstance();
    }
    @GET
    @ApiOperation(value = "get all denuncias", notes = "devuelve la lista de denuncias")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Denuncia.class, responseContainer="List"),
    })
    @Path("/getDenuncias")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDenuncias() {
        List<Denuncia> lDen = dm.getDenuncias();

        GenericEntity<List<Denuncia>> entity = new GenericEntity<List<Denuncia>>(lDen) {};
        return Response.status(201).entity(entity).build();
    }
    @PUT
    @ApiOperation(value = "Enviar denuncia", notes = "Envia una denuncia")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Actualización exitosa")
    })
    @Path("/addDenuncia")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDenuncia(Denuncia denuncia) {
        dm.addDenuncia(denuncia);
        return Response.status(201).build();
    }
}
