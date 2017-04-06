package com.petapplication.utility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

/**
 *
 * @author admin
 */
@Component
public class FileProcessorUtils {

    public static final String FILE_DIRECTIVE = "petImage";

    public static final int BUFFER_SIZE = 1024000;

    public static String writeImageAndReturnPath(String base64StringImage) {
        File file = new File(FILE_DIRECTIVE);
        if (!file.exists()) {
            file.mkdir();
        }
        byte[] bs = Base64Utils.decodeFromString(base64StringImage);
        String currentDateTime = DateUtils.getCurrentMillisecond(new Date());
        String fileName = currentDateTime + ".jpg";
        String fileUpload = FILE_DIRECTIVE + File.separator + fileName;
        try {
            BufferedOutputStream bufferedOutputStream;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileUpload));
                bufferedOutputStream.write(bs);
                bufferedOutputStream.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileProcessorUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileProcessorUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileName;
    }

    public static String decodeImageIntoString(String imagePath) {
        byte[] bs = new byte[BUFFER_SIZE];
        String fileLocation = FILE_DIRECTIVE + File.separator + imagePath;
        try {
            InputStream inputStream = new FileInputStream(fileLocation);

            BufferedInputStream bufferedOutputStream = new BufferedInputStream(inputStream, BUFFER_SIZE);
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            int i;
            while ((i = bufferedOutputStream.read(bs, 0, bs.length)) != -1) {
                arrayOutputStream.write(bs, 0, i);
            }
            bufferedOutputStream.close();
            arrayOutputStream.flush();
            bs = arrayOutputStream.toByteArray();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileProcessorUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileProcessorUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        String imageEncode = Base64Utils.encodeToString(bs);
        return imageEncode;
    }
}
