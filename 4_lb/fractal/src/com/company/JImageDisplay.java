package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class JImageDisplay extends JComponent{

    private BufferedImage image;

    JImageDisplay(int width, int height){
        image = new BufferedImage(width, height, image.TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(width, height));
    }

    //Переопределение метода
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g); //чтобы объекты отображались правильно
        g.drawImage(image, 0,0, image.getWidth(), image.getHeight(), null);
    }

    // устанавливает все пиксели
    //изображения в черный цвет
    public void clearImage(){
        for (int i = 0; i < image.getWidth(); i++){
            for (int j = 0; j < image.getHeight(); j++){
                image.setRGB(i,j,new Color(0, 0, 0).getRGB());//устанавливаем каждый пиксель в чёрный цвет
            }
        }
    }

    //устанавливает пиксель в определенный цвет
    public void drawPixel(int x, int y, int rgbColor){
        image.setRGB(x, y, rgbColor);
    }
}
