package shiny;

import model.DataToWrite;

import java.io.IOException;

public class TabItem {

    private String tabName;
    private DataToWrite dataToWrite;


    public TabItem(String tabName, String filename) {
        this.tabName = tabName;
        this.dataToWrite = new DataToWrite(filename);
    }

    public void startTabItem() throws IOException {
        dataToWrite.addLine("tabItem(tabName="+tabName+",");
        dataToWrite.writeFile();
        dataToWrite.removeLine(0);
    }

    public void endTabItem() throws IOException {
        dataToWrite.addLine("),");
        dataToWrite.writeFile();
        dataToWrite.removeLine(0);
    }
}
