package com.teo2.prediosservices.repository;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.teo2.prediosservices.dto.ImageDTO;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Repository
public class AwsS3Repository {

    private final String TEO2_CARPETA_PRINCIPAL = "teo2-app-bucket";


    private final AmazonS3 s3Client;

    public AwsS3Repository(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public void createBucket() {
        if(s3Client.doesBucketExist(TEO2_CARPETA_PRINCIPAL)) {
            System.out.println("Bucket name is not available."
                    + " Try again with a different Bucket name.");
            return;
        }
        s3Client.createBucket(TEO2_CARPETA_PRINCIPAL);
    }

    public String guardarImagen(ImageDTO imageDTO, String predioId) {
        String base64Image = imageDTO.getBase64Image();
        byte[] imageBytes = Base64.getDecoder().decode(base64Image.getBytes());
        InputStream stream = new ByteArrayInputStream(imageBytes);
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(imageBytes.length);
        meta.setContentType("image/png");
        PutObjectResult putObjectResult = s3Client.putObject(new PutObjectRequest(
                TEO2_CARPETA_PRINCIPAL, imageDTO.getImageName(), stream, meta)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        StringBuilder imagenUrlBuilder  = new StringBuilder("https://");
        imagenUrlBuilder.append(TEO2_CARPETA_PRINCIPAL);
        imagenUrlBuilder.append(".s3.");
        imagenUrlBuilder.append(Regions.US_EAST_2.getName());
        imagenUrlBuilder.append(".amazonaws.com/");
        imagenUrlBuilder.append(imageDTO.getImageName());
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagenUrlBuilder.toString();
    }
}
