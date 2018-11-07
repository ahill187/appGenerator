package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class CardPanel extends JPanel {

    PanelCards cards;
    AppBuilderGui gui;
    protected List<TextBox> textBoxes = new ArrayList<>();

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

    public void addInputBoxes(List<String> initialTextBoxes){
        int i = 0;
        for(String boxes : initialTextBoxes){
            TextBox textBox = new TextBox();
            textBoxes.add(textBox);
            textBox.makeTextBox(boxes,"", 50, 100+i*(textBox.height+50));
            textBox.getLabel().setLabelFor(textBox.getTextBox());
            this.add(textBox.getLabel());
            this.add(textBox.getTextBox());
            System.out.println(boxes);
            System.out.println(textBoxes.get(i));
            i += 1;
        }
    }
}
