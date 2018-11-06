package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {

    AppBuilderGui appBuilderGui;
    PanelCards cards;

    public Button(Action a, AppBuilderGui appBuilderGui) {
        super(a);
        this.appBuilderGui = appBuilderGui;
        this.cards = appBuilderGui.cards;
    }

    public Button(String buttonLabel, AppBuilderGui appBuilderGui){
         super(buttonLabel);
         this.appBuilderGui = appBuilderGui;
         this.cards = appBuilderGui.cards;
    }

}
