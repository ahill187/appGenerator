package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextBox implements ActionListener {

    private JTextField javaTextBox;
    private JLabel javaLabel;
    public int height = 30;

    public JTextField getTextBox() {
        return javaTextBox;
    }

    public void setTextBox(JTextField textBox) {
        this.javaTextBox = textBox;
    }

    public JLabel getLabel(){
        return this.javaLabel;
    }

    public void makeTextBox(String label, String defaultText, int x, int y){
        this.javaLabel = new JLabel(label);
        this.javaTextBox=new JTextField(defaultText,30);
        javaTextBox.setBounds(x,y, 200,this.height);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String textInput = this.getTextBox().getText();
    }
}
