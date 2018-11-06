package gui;

import javax.swing.*;
import java.awt.*;

public class PanelCards extends JPanel {

    public PanelCards() {
        super();
    }

    public PanelCards(LayoutManager layout) {
        super(layout);
    }

    public void add(CardPanel cardPanel, Object constraints) {
        super.add(cardPanel, constraints);
    }

    public boolean containsCard(CardPanel card){
        for(Component component : this.getComponents()){
            if(card.equals(component)){
                return true;
            }
        }
        return false;
    }
}
