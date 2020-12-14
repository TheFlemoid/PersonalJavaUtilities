package com.dobby.utils.net;

    /*
        Utility class for performing image GET requests.
        Created by Franklyn Dahlberg III, 2019.
                                                          */

import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.io.IOException;

public class HttpImageGetter {

    public BufferedImage performImageRequest(String requestedUrl) {

        BufferedImage requestedImage=null;

        try {
            URL imageUrl=new URL(requestedUrl);
            requestedImage=ImageIO.read(imageUrl);

        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return requestedImage;
    }

    public BufferedImage performImageRequest(URL requestedUrl) {

        BufferedImage requestedImage=null;

        try {
            URL imageUrl=requestedUrl;
            requestedImage=ImageIO.read(imageUrl);

        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return requestedImage;
    }
}
