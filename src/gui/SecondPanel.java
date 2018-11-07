package gui;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondPanel extends CardPanel {

    private List<String> initialTextBoxes = Arrays.asList("Tab", "Number of Tabs", "Tab Titles");
    PanelCards cards;
    ButtonAction buttonAction;
    Button nextButton;
    String name;

    AppBuilderGui gui;

    @Override
    public PanelCards getCards() {
        return cards;
    }

    @Override
    public void setCards(PanelCards panelCards) {
        this.cards = panelCards;
    }

    public SecondPanel(AppBuilderGui gui, String name) {
        super(gui);
        this.name = name;
        this.makePanel();
    }

    public void makePanel(){

        this.addInputBoxes(initialTextBoxes);
        this.addNextButton();
        this.addPreviousButton();
    }
}

