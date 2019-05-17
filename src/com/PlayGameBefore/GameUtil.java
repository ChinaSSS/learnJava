package com.PlayGameBefore;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameUtil {

    private GameUtil(){

    }

    public static Image getImage(String path){
        Image image = null;
            String str = GameUtil.class.getClassLoader().getResource(path).getFile();
            ImageIcon imageIcon = new ImageIcon(str);
            image = imageIcon.getImage();
        return image;
    }

}
