package edu.stevens.cs594.caf.service;

import edu.stevens.cs594.caf.service.dto.CommentDto;
import edu.stevens.cs594.caf.service.dto.ImageDto;
import edu.stevens.cs594.caf.service.micro.IApprovalResource;
import edu.stevens.cs594.caf.service.micro.IImageResource;
import edu.stevens.cs594.caf.service.micro.IUserResource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class ImageService implements IImageService {

    @Inject
    Logger logger;

    @RestClient
    IApprovalResource approvalResource;

    @RestClient
    IImageResource imageResource;

    @RestClient
    IUserResource userResource;

    @Override
    public void addImage(ImageDto imageDto) {
        imageResource.addImage(imageDto);
    }

    @Override
    public void removeImage(UUID id) {
        imageResource.removeImage(id);
    }

    @Override
    public void addComment(CommentDto commentDto) {
        imageResource.addComment(commentDto);
    }

    @Override
    public CommentDto getComment(UUID id) {
        return imageResource.getComment(id);
    }

    @Override
    public void removeComment(UUID id) {
        imageResource.removeComment(id);
    }

    @Override
    public List<ImageDto> getImages() {
        return imageResource.getImages();
    }

    @Override
    public ImageDto getImage(UUID imageId) {
        return imageResource.getImage(imageId);
    }

    @Override
    public List<ImageDto> getImages(String username) {
        if (username == null || username.isBlank()) {
            return imageResource.getImages();
        } else {
            return userResource.getImages(username);
        }
    }

    @Override
    public List<ImageDto> getImagesForApproval() {
        return approvalResource.getImagesForApproval();
    }

    @Override
    public void updateApproval(UUID id, boolean approved) {
        approvalResource.updateApproval(id, approved);
    }

}
