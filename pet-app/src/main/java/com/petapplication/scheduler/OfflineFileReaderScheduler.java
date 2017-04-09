package com.petapplication.scheduler;

import com.petapplication.requestDTO.PetInfoRequestDTO;
import com.petapplication.utility.CheckServerConnection;
import com.petapplication.utility.OfflineFile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by pradip on 4/3/17.
 */
@Component
public class OfflineFileReaderScheduler {

    private static final String API = "http://localhost:8080/api/save/?accessToken=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmMiLCJpZCI6MSwicHJvZmlsZSI6MSwic3RhdHVzIjoiYSIsImV4cCI6MTQ5MTQzODI1NX0.ZSyQjCtyGI7v9gzxvbMe9GQn0FMR2mR_zGY58FHgzxM";

//    @Scheduled(fixedRate = 5000)
    public void readLocalFile() {
        if (CheckServerConnection.isServerHasConnection()) {
            processFile();
        }

    }

    public void processFile() {
        File[] files = OfflineFile.getAllLocalFile();
        for (File file : files) {
            PetInfoRequestDTO petInfoRequestDTO = (PetInfoRequestDTO) readLocalFile(file);
            if (petInfoRequestDTO != null) {
                System.out.println(petInfoRequestDTO);
                sendFileToServer(petInfoRequestDTO);
                if (deleteFile(file)) {
                    System.out.println("File Has Been Deleted.");
                } else {
                    System.out.println("Failed To Delete File.");
                }
            }
        }

    }

    public static boolean deleteFile(File file) {
        if (file.exists()) {
            return file.delete();
        } else {
            System.out.println("File Not Exists");
        }
        return false;
    }

    public static void moveFile() {

    }

    public static <T> T readLocalFile(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            T object = (T) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendFileToServer(PetInfoRequestDTO petInfoRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(API, petInfoRequestDTO, Void.class);
//        System.out.println(infoRequestDTO);
    }
}
