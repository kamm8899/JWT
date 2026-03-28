package edu.stevens.cs594.caf.service.micro;

import edu.stevens.cs594.caf.service.dto.CommentDto;
import edu.stevens.cs594.caf.service.dto.ImageDto;
import io.quarkus.oidc.token.propagation.AccessToken;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.UUID;

@RegisterRestClient(configKey="caf-images-api")
@Path("/images")
// TODO propoagate the access token from the webapp
@AccessToken
public interface IImageResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void addImage(ImageDto imageDto);

    @DELETE
    @Path("{id}")
    void removeImage(@PathParam("id") UUID imageId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void addComment(CommentDto commentDto);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    CommentDto getComment(@PathParam("id") UUID id);

    @DELETE
    @Path("{id}")
    void removeComment(@PathParam("id") UUID id) throws SecurityException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ImageDto> getImages();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ImageDto getImage(@PathParam("id") UUID imageId);

}
