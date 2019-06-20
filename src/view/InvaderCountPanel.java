package view;

import model.GameInfoProvider;
import model.GameObserver;
import util.PropertiesDiskStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.awt.Font.BOLD;

public class InvaderCountPanel extends JPanel implements GameObserver {

    private GameInfoProvider info;
    private int invaderCount;
    private List<BufferedImage> image;
    private Iterator<BufferedImage> imageIterator;

    public InvaderCountPanel(GameInfoProvider info){
        this.info = info;
        invaderCount =info.getInvaderCount();
        info.addObserver(this);

        List<String> imageNames = PropertiesDiskStorage.getInstance().getProperties("invader");
        image = new LinkedList<BufferedImage>();
        for (String name : imageNames)
            image.add(ImageCache.getInstance().getImage(name));
        imageIterator = image.iterator();

    }

    @Override
    public void gameChanged() {
        int newInvaderCount = info.getInvaderCount();
        if(invaderCount!=newInvaderCount){
            invaderCount = newInvaderCount;
            repaint();
        }

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D)g;

        g1.setPaint(Color.BLACK);

        g1.fill3DRect(0,0,getWidth(),getHeight(),false);


        if (!imageIterator.hasNext()) {
            imageIterator = image.iterator();
        }

            BufferedImage image = imageIterator.next();



            g1.drawImage(image,60,50,null);

            g1.setPaint(Color.GREEN);
            g1.drawString("INVADER COUNT",40,20);

            g1.drawLine(0,30,300,30);
            g1.drawString("The number of left :" + invaderCount,30,110);

            g1.setPaint(Color.BLACK);


        }





    }



