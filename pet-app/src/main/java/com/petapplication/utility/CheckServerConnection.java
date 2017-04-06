package com.petapplication.utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pradip on 4/2/17.
 */
public class CheckServerConnection {

    public static boolean isServerHasConnection() {
        try {
            URL url = new URL("http://localhost:8080/api/test");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println("=====Connected=====");
                return true;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isServerHasConnection());
    }
}
