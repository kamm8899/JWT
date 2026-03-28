package edu.stevens.cs594.caf.service.micro;

import edu.stevens.cs594.caf.service.dto.ImageDto;
import io.quarkus.oidc.token.propagation.AccessToken;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.UUID;

@Path("/approval")
@RegisterRestClient(configKey="caf-images-api")
// TODO propoagate the access token from the webapp
@AccessToken
public interface IApprovalResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ImageDto> getImagesForApproval();

    @PUT
    @Path("{id}")
    void updateApproval(@PathParam("id") UUID id,
                        @QueryParam("approved") boolean approved);

}
