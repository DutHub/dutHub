package com.duthub.DutHub.bll.services;

import com.duthub.DutHub.bll.exceptions.FileNotFoundException;
import com.duthub.DutHub.bll.exceptions.FileStorageException;
import com.duthub.DutHub.bll.helpers.FileStorageProperties;
import com.duthub.DutHub.bll.interfaces.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileService implements IFileService {
    private final Path videoStorageLocation;
    private final Path previewStorageLocation;

    @Autowired
    public FileService(FileStorageProperties fileStorageProperties) {
        this.videoStorageLocation = Paths.get(fileStorageProperties.getUploadVideoDir())
                .toAbsolutePath().normalize();

        this.previewStorageLocation = Paths.get(fileStorageProperties.getUploadPreviewDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.videoStorageLocation);
            Files.createDirectories(this.previewStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeVideo(MultipartFile file) throws FileStorageException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            String newFileName = UUID.randomUUID().toString() + "." + StringUtils.cleanPath(file.getOriginalFilename());
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.videoStorageLocation.resolve(newFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return newFileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public String storePreview(MultipartFile file) throws FileStorageException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            String newFileName = UUID.randomUUID().toString() + "." + StringUtils.cleanPath(file.getOriginalFilename());
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.previewStorageLocation.resolve(newFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return newFileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadVideoAsResource(String fileName) {
        try {
            Path filePath = this.videoStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName, ex);
        }
    }

    public Resource loadPreviewAsResource(String fileName) {
        try {
            Path filePath = this.previewStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName, ex);
        }
    }
}
