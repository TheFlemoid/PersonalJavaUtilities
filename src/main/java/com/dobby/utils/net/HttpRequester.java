package com.dobby.utils.net;

/*
    Utility class for performing HTTP GET requests.
    Created by Franklyn Dahlberg III, 2019.
                                                      */

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequester {

    private HttpURLConnection connection;
    private URL url;

    //Performs a GET request at the url specified in the input parameter
    //and returns the result as a String.

    public String performGetRequest(final String requestedUrl) {
        String returnedContentString;

        try {
            url = new URL(requestedUrl);
            returnedContentString = performGetRequest(url);

        } catch(MalformedURLException e) {
            returnedContentString = String.format("Malformed URL Error");
        }
          return returnedContentString;
    }

    public String performGetRequest(final URL requestedUrl) {
        BufferedReader reader;
        String line;
        StringBuffer returnedContent=new StringBuffer();

        try {
            url = requestedUrl;
            connection = (HttpURLConnection)url.openConnection();

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
            line = String.format("Malformed URL Error");
            returnedContent.append(line);
        } catch(IOException e) {
            line = String.format("Input/Output Error");
            returnedContent.append(line);
        } finally {
            connection.disconnect();
        }

        return returnedContent.toString();
    }

    public String performPostRequest(final String requestedUrl, final String postParams) {
        String returnedContent = null;

        try {
            url = new URL(requestedUrl);
            returnedContent = performPostRequest(url, postParams);
        }catch(MalformedURLException e) {
            returnedContent = String.format("Malformed URL Exception");
        }

        return returnedContent;
    }

    public String performPostRequest(final URL requestedUrl, final String postParams) {
        BufferedReader reader;
        String returnedContent = null;
        try {
            url = requestedUrl;
            connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            os.write(postParams.getBytes());
            os.flush();
            os.close();

            //Return from server
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuffer returnedBuffer = new StringBuffer();

                while((line = reader.readLine()) != null) {
                    returnedBuffer.append(line);
                }
                reader.close();
                returnedContent = returnedBuffer.toString();

            }else {
                System.out.println("POST request failed");
            }
        }catch(MalformedURLException e) {
            returnedContent = String.format("Malformed URL Exception");
        }catch(IOException e) {
            returnedContent = String.format("Input/Output Exception");
        }
        return returnedContent;
    }
}
