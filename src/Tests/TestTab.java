package Tests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shiny.box;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestTab {

    private Tab tab;
    private String fileName;

    @BeforeEach
    void runBefore(){
        this.fileName = "testingApp.R";
        Map<String, AppBrick> appBrickMap = new HashMap<>();
        Map<String, TabBox> tabBoxHash = new HashMap<>();
        this.tab = new Tab("tab1", "My Tab Title", appBrickMap, fileName);
        DataToWrite dataToWrite = new DataToWrite(fileName);
        try {
            dataToWrite.writeFile(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MapBrick mapBrick = new MapBrick(this.tab, dataToWrite, "map1", "100%");
        TabBox tabBox = new box("box", this.fileName, true, "Box1", "info",6,6);
        tabBoxHash.put("test1", tabBox);
        tab.setTabBoxHash(tabBoxHash);
        tabBox.addAppBrickHash("MapBrick", mapBrick);


    }

    @Test
    void testWriteUiTab(){
        try {
            tab.writeUiTab();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
