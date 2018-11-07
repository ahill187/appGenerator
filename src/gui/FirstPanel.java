package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstPanel extends CardPanel {

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
        this.addInputBoxes(initialTextBoxes);
        this.addPreviousButton();
        this.addNextButton();

    }


}
