package com.malina.siteForInteriorDesigner.controller;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import com.malina.siteForInteriorDesigner.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")

public class PortfolioController {
    private final PortfolioService service;
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    public PortfolioController(PortfolioService service) {
        this.service = service;
    }

    @PostMapping("/portfolio/uploadPhoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println("FILENAME : " + fileName);

        Path path = Paths.get(uploadDir + "/" + fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        PortfolioEntity photo = new PortfolioEntity();
        photo.setPath("../src/assets/images/" + fileName);
        photo.setIndex(service.getLastIndex() + 1);
        service.addImage(photo);

        return "Photo uploaded successfully";
    }


    @GetMapping("/portfolio")
    public List<PortfolioEntity> getPortfolio() {
        List<PortfolioEntity> images = service.findAllImage();
        images.stream()
                .sorted(Comparator.comparingInt(PortfolioEntity::getIndex))
                .forEach(entity -> entity.setIndex(images.indexOf(entity)));
        service.saveAllImage(images);
        return service.findAllImage();
    }
    @PostMapping("/portfolio/add")
    public String addImage(@RequestBody PortfolioEntity image) {
        service.addImage(image);
        return "Image was added successfully...";
    }
    @GetMapping("/portfolio/{id}")
    public PortfolioEntity getImageById(@PathVariable("id") long id){
        return service.getImageById(id);
    }
    @PutMapping("/portfolio")
    public PortfolioEntity updateImage(@RequestBody PortfolioEntity image) {
        return service.updateImage(image);
    }
    @DeleteMapping("/portfolio/{id}")
    public String deleteImage(@PathVariable("id") long id){
        PortfolioEntity imageToDelete = service.getImageById(id);
        if (imageToDelete == null) {
            return "Error : image not found";
        }

        service.deleteImage(id);

        String imagePath = imageToDelete.getPath();
        String fileName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
        Path filePath = Paths.get(uploadDir + "/" + fileName);

        try {
            Files.delete(filePath);
        } catch (IOException e) {
            return "Error : deleting file";
        }

        return "Image was removed successfully";
    }


}
