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

/**
 * invader count panel which hold the count no and the image of invader
 */
public class InvaderCountPanel extends JPanel implements GameObserver {
    /**
     * info : the current state of game
     * invader count : number of invader left
     * image: list of invader buff.
     * imageIterator: iterator for iterating through image
     */
    private GameInfoProvider info;
    private int invaderCount;
    private List<BufferedImage> image;
    private Iterator<BufferedImage> imageIterator;

    /**
     * create frame having count of invader left & image of invader
     * moving on kill
     * @param info current state of game
     */

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

    /**
     * for repainting
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D)g;

        g1.setPaint(Color.BLACK);

        g1.fill3DRect(0,0,getWidth(),getHeight(),false);


        if (!imageIterator.hasNext()) {
            imageIterator = image.iterator();
        }

            BufferedImage image = imageIterator.next();

            g1.drawImage(image,40,50,100,70,null);

            g1.setPaint(Color.GREEN);
            g1.drawString("INVADER COUNT",40,20);

            g1.drawLine(0,30,300,30);
            g1.drawString("The number of left :" + invaderCount,30,130);

            g1.setPaint(Color.BLACK);


        }





    }



