package web.rest;

import io.swagger.annotations.Api;
import repository.ProjectRepository;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Project;

@Path("/project")
@Api(value="/project", description = "Project resource")
public class ProjectResource {

    private ProjectRepository projectRepository = new ProjectRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}