package com.dobby.utils.net;

    /*
        Utility class for performing HTTP GET requests.
        Created by Franklyn Dahlberg III, 2019.
                                                          */

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;

public class HttpGetRequester {

    private HttpURLConnection connection;
    private URL url;

    //Performs a GET request at the url specified in the input parameter and returns the result as a String.

    public String performGetRequest(String requestedUrl) {
        BufferedReader reader;
        String line;
        StringBuffer returnedContent=new StringBuffer();

        try {
            url=new URL(requestedUrl);
            connection=(HttpURLConnection)url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status=connection.getResponseCode();

            if(status>299) {
                reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                while((line=reader.readLine())!=null) {
                    returnedContent.append(line);
                }
            } else {
                reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while((line=reader.readLine())!=null) {
                    returnedContent.append(line);
                }
            }
            reader.close();

        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return returnedContent.toString();
    }

    public String performGetRequest(URL requestedUrl) {
        BufferedReader reader;
        String line;
        StringBuffer returnedContent=new StringBuffer();

        try {
            url=requestedUrl;
            connection=(HttpURLConnection)url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status=connection.getResponseCode();

            if(status>299) {
                reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                while((line=reader.readLine())!=null) {
                    returnedContent.append(line);
                }
            } else {
                reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while((line=reader.readLine())!=null) {
                    returnedContent.append(line);
                }
            }
            reader.close();

        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return returnedContent.toString();
    }

}
