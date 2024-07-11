package com.projectImage.Image_Gallery;


import com.projectImage.Image_Gallery.controller.ImageController;
import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class ControllerTests {

    @Mock
    private ImageServices imageServices;

    @InjectMocks
    private ImageController imageController;
    private MockMvc mockMvc;

    private Image image1;
    private Image image2;
    private Image image3;
    private ArrayList<Image> imageList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();

        Image image1 = new Image();
        image1.setId(1L);
        image1.setTitle("árbol");
        image1.setDescription("picture of mountains, trees and a lake");
        image1.setUrl("https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/arbol.jpg?raw=true");
        image1.setFavorite(false);

        Image image2 = new Image();
        image2.setId(2L);
        image2.setTitle("hojas");
        image2.setDescription("picture of green leaves, yellow and orange leaves");
        image2.setUrl("https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/hojas.jpg?raw=true");
        image2.setFavorite(false);

        Image image3 = new Image();
        image3.setId(3L);
        image3.setTitle("lago");
        image3.setDescription("picture of mountains, trees and a lake in winter");
        image3.setUrl("https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/lago.jpg?raw=true");
        image3.setFavorite(false);

        imageList = new ArrayList<Image>();
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
    }

    @Test
    public void test_if_deleteImage_deletes_by_Id() {

        when(imageServices .deleteImage().getImage(2L).thenReturn(imageList));

        imageController.deleteImage(2L);

        verify(imageServices).deleteImage(2L);

    }



}
