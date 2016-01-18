package web.rest;

import io.swagger.annotations.Api;
import repository.FunctionRepository;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Function;

@Path("/function")
@Api(value="/function", description = "Function resource")
public class FunctionResource {

    private FunctionRepository functionRepository = new FunctionRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Function> getAll() {
        return functionRepository.findAll();
    }
}