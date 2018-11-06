package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstPanel extends CardPanel {

    private List<TextBox> textBoxes = new ArrayList<>();
    private List<String> initialTextBoxes = Arrays.asList("App Title", "Number of Tabs", "Tab Titles");
    PanelCards cards;
    ButtonAction buttonAction;
    Button nextButton;
    String name;

    AppBuilderGui gui;

    public FirstPanel(AppBuilderGui gui, String name) {
        super(gui);
        this.name = name;
        this.makePanel();
    }

    public PanelCards getCards() {
        return cards;
    }

    public void setCards(PanelCards cards) {
        this.cards = cards;
    }

    public void makePanel(){
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
        this.addPreviousButton();
        this.addNextButton();

    }


}
