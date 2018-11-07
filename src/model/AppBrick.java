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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppBrick appBrick = (AppBrick) o;

        if (tab != null ? !tab.equals(appBrick.tab) : appBrick.tab != null) return false;
        if (tabBox != null ? !tabBox.equals(appBrick.tabBox) : appBrick.tabBox != null) return false;
        return brickId != null ? brickId.equals(appBrick.brickId) : appBrick.brickId == null;
    }

    @Override
    public int hashCode() {
        int result = tab != null ? tab.hashCode() : 0;
        result = 31 * result + (tabBox != null ? tabBox.hashCode() : 0);
        result = 31 * result + (brickId != null ? brickId.hashCode() : 0);
        return result;
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
