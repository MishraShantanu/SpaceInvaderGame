package view;

import model.GameInfoProvider;

import javax.swing.*;
import java.awt.*;

public class InvaderCountFrame extends JFrame {


    public InvaderCountFrame(GameInfoProvider info){

        setTitle("Invader Count");
        setSize(200,200);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        add(new InvaderCountPanel(info));
        setVisible(true);
    }





}
