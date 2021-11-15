package com.QLTV.utils;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class XImage {
      public static Image getappicon(){
        URL url = XImage.class.getResource("/com/QlTV/icon/logo.png");
        return new ImageIcon(url).getImage();
    }
}
