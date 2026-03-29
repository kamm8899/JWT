package edu.stevens.cs594.caf.thumbnail;

import jakarta.annotation.security.RolesAllowed;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@RequestScoped
@Path("/api/thumbnail")
// TODO require user role
@RolesAllowed("user")
public class ThumbnailResource {

    @Inject
    ThumbnailService thumbnailService;

    @Inject
    Logger logger;

    @Inject
    SecurityIdentity caller;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getThumbnail(@QueryParam("bucket") String bucketName,
                               @QueryParam("object") String objectKey,
                               @QueryParam("width") String width,
                               @QueryParam("height") String height) {

        // TODO log the following claims from the bearer token:
        // - principal
        // - roles of the principal
        logger.infof("Principal: %s", caller.getPrincipal().getName());
        logger.infof("Roles: %s", caller.getRoles());

        return thumbnailService.createThumbnail(bucketName, objectKey, Integer.parseInt(width), Integer.parseInt(height));
    }

}
