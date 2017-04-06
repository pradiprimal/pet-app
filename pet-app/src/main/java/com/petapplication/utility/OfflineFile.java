package com.petapplication.utility;

import com.petapplication.requestDTO.LoginRequestDTO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by pradip on 3/31/17.
 */
public class OfflineFile {

    public static final String OFFLINE_FILE_DIRECTIVE = "offlineFile";

    public static <T> void writeFileToLocally(T object) {
        try {
            File file = new File(OFFLINE_FILE_DIRECTIVE);
            if (!file.exists()) {
                file.mkdir();
            }
            String fileName = generateFileName("CUS");
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OFFLINE_FILE_DIRECTIVE + File.separator + fileName));
//            bufferedWriter.write(object);
            FileOutputStream outputStream = new FileOutputStream(OFFLINE_FILE_DIRECTIVE + File.separator + fileName + ".txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readLocalFile(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(OFFLINE_FILE_DIRECTIVE + File.separator + fileName);
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

    public static File[] getAllLocalFile() {
        File file = new File(OFFLINE_FILE_DIRECTIVE);
        return file.listFiles();

    }

    public static String generateFileName(String fileType) {
        String currentTime = DateUtils.getCurrentMillisecond(new Date());
        return new StringBuilder().append(fileType).append(currentTime).toString();
    }

    public static void main(String[] args) {
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setPassword("123456789");
        loginRequestDTO.setUserName("test test test");
        writeFileToLocally(loginRequestDTO);
        File[] files = getAllLocalFile();
        System.out.println(files.length);
        for (File file : files) {
            file.delete();
        }
//        System.out.println(requestDTO);

    }
}
