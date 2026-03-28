package edu.stevens.cs594.caf.domain;


public class ImageFactory implements IImageFactory {

	@Override
	public Image createImage() {
		return new Image();
	}

	@Override
	public Comment createComment() {
		return new Comment();
	}

}
