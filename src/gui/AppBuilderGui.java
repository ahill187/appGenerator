package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AppBuilderGui extends JFrame {


    private List<TextBox> textBoxes = new ArrayList<>();
    public PanelCards cards;
    CardLayout cardLayout;
    CardPanel card1;

    CardPanel card2;



    public AppBuilderGui(String title) throws HeadlessException {
        super(title);
        this.cardLayout = new CardLayout();
        this.cards = new PanelCards(this.cardLayout);
        card1 = new FirstPanel(this, "card1");
        card2 = new SecondPanel(this, "card2");
        this.setupPage();

    }


    public void setupPage(){
        //this.setLayout(new FlowLayout(FlowLayout.LEADING));
        cards.setLayout(cardLayout);
        cards.add(card1, "testing");
        cards.add(card2, "testing2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        this.add(cards);

        this.getContentPane().add(cards);
        this.setContentPane(cards);
        this.setVisible(true);
    }




    public static void main(String[] args) {
        new AppBuilderGui("R Shiny App Generator");
    }
}
