package model;

import java.io.FileWriter;
import java.io.IOException;

public abstract class AppBrick {

    protected Tab tab;
    protected TabBox tabBox;
    protected DataToWrite dataToWrite;
    protected String brickId;

    public AppBrick(Tab tab, DataToWrite dataToWrite, String brickId) {
        this.tab = tab;
        this.dataToWrite = dataToWrite;
        this.brickId = brickId;
    }

    public Tab getTab() {
        return tab;
    }

    public void setTab(Tab tab) {
        this.tab = tab;
        tab.addToAppBrickHash(brickId, this);
    }

    public TabBox getTabBox() {
        return tabBox;
    }

    public void setTabBox(TabBox tabBox) {
        this.tabBox = tabBox;
    }

    public abstract void writeUiBrick() throws IOException;
    public abstract void writeServerBrick();

    protected static void writeFile(DataToWrite dataToWrite) throws IOException {
        FileWriter fw = new FileWriter(dataToWrite.getFilename());

        for (String line : dataToWrite.getLinesOfText()) {
            fw.write(line);
        }

        fw.close();
    }
}
