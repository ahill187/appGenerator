package gui;

import javax.swing.*;

public abstract class CardPanel extends JPanel {

    PanelCards cards;
    AppBuilderGui gui;

    public CardPanel(AppBuilderGui gui) {
        this.cards = gui.cards;
        this.gui = gui;
    }

    public boolean equals(CardPanel card){
        return card.getName().equals(this.getName());
    }

    public abstract PanelCards getCards();
    public abstract void setCards(PanelCards panelCards);

    public void addNextButton(){
        this.addButton("Next", "next");
    }


    public void addPreviousButton(){
        this.addButton("Previous", "previous");
    }


    public void addButton(String buttonText, String buttonType){
        ButtonAction buttonAction = new ButtonAction(buttonText, cards, buttonType);
        Button button = new Button(buttonType, this.gui);
        button.addActionListener(buttonAction);
        this.add(button);
    }
}
