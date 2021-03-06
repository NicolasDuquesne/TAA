package app;

import io.swagger.jaxrs.config.BeanConfig;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import web.rest.DepartmentResource;
import web.rest.EmployeeResource;
import web.rest.FunctionResource;
import web.rest.ProjectResource;
import web.rest.SwaggerResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RestApplication extends Application {

    public static void main(String[] args) {
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(new RestApplication());

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("0.0.0-alpha");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("web.rest");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);

        server.start(Undertow.builder().addHttpListener(9090, "0.0.0.0"));
    }

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();

        // REST endpoints
        resources.add(DepartmentResource.class);
        resources.add(EmployeeResource.class);
        resources.add(FunctionResource.class);
        resources.add(ProjectResource.class);

        // SWAGGER endpoints
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        resources.add(SwaggerResource.class);

        return resources;
    }
}