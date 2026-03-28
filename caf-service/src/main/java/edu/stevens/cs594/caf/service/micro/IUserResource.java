package edu.stevens.cs594.caf.service.micro;

import edu.stevens.cs594.caf.service.dto.ImageDto;
import io.quarkus.oidc.token.propagation.AccessToken;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey="caf-images-api")
@Path("/users")
// TODO propoagate the access token from the webapp
@AccessToken
public interface IUserResource {

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    List<ImageDto> getImages(@PathParam("username") String username);

}
