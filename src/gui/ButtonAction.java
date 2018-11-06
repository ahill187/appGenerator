package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAction implements ActionListener {

    String name;
    PanelCards cards;
    boolean next = false;
    boolean previous = false;
    String cardName;

    //REQUIRES: buttonType is either "next", "previous" or the name of the card
    // you wish to show on the button click
    public ButtonAction(String name, PanelCards cards, String buttonType) {
        this.name = name;
        this.cards = cards;
        if(buttonType.equals("next")){
            this.next = true;
        } else if(buttonType.equals("previous")){
            this.previous = true;
        } else {
            this.cardName = buttonType;
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CardLayout cl = (CardLayout) cards.getLayout();
        if(next){
            cl.next(cards);
        } else if(previous){
            cl.previous(cards);
        }else{
            cl.show(cards, cardName);
        }
    }
}
