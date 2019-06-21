package view;

import model.GameInfoProvider;

import javax.swing.*;
import java.awt.*;

/**
 * frame for holding the panel for Invader count
 */

public class InvaderCountFrame extends JFrame {

    /**
     * constructor for frame
     * @param info provides methods to access information about current state of game
     */
    public InvaderCountFrame(GameInfoProvider info){

        setTitle("Invader Count");
        setSize(200,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        add(new InvaderCountPanel(info));
        setVisible(true);
    }





}
