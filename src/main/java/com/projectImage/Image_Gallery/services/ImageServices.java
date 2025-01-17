package com.projectImage.Image_Gallery.services;

import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IImageRepository;

@Service
public class ImageServices {

    @Autowired
    IImageRepository iImageRepository;

    public void deleteImage(long id) {
        iImageRepository.deleteById(id);
    }

    public Image createImage(Image newImage){
        return iImageRepository.save(newImage);
    }

    public List<Image> getAllImages(){
        return (List<Image>) iImageRepository.findAll();
    }

    public Image getImageById(Long id) throws InstanceNotFoundException {
        Optional<Image> image = iImageRepository.findById(id);
        return image.orElseThrow(() -> new InstanceNotFoundException("Image not found with id " + id));
    }

    public void updateImage(Long id, Image newImage) {
        newImage.setId(id);
        iImageRepository.save(newImage);
    }

    public void tagImageAsFavorite(Long id) {
        Optional<Image> imageOptional = iImageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            image.setFavorite(true);
            iImageRepository.save(image);
        }
    }

}

