package model;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Exceptions.boxTypeException;


public abstract class TabBox {

    private String fileName;
    private String boxType;
    private Map<String, TabBox> listOfTabBoxes = new HashMap<>();
    private List<String> boxTypeOptions = Arrays.asList("box", "sidebarLayout", "sidebarPanel",
            "mainPanel");
    protected DataToWrite dataToWrite;
    private Map<String, AppBrick> appBrickHash = new HashMap<>();

    public TabBox(String boxType, Map<String, TabBox> listOfTabBoxes, String fileName) {
        try {
            this.setBoxType(boxType);
        } catch (boxTypeException e) {
            e.printStackTrace();
            System.out.println("The boxType "+boxType+" is not an option");
        }
        this.listOfTabBoxes = listOfTabBoxes;
        this.fileName = fileName;
    }

    public TabBox(String boxType, String fileName) {
        try {
            this.setBoxType(boxType);
        } catch (boxTypeException e) {
            e.printStackTrace();
            System.out.println("The boxType "+boxType+" is not an option");
        }
        this.fileName = fileName;
    }

    public String getBoxType() {
        return boxType;
    }

    public void setBoxType(String boxType) throws boxTypeException {
        if(boxTypeOptions.contains(boxType)){
            this.boxType = boxType;
        } else {
            throw new boxTypeException();
        }
    }

    public Map<String, AppBrick> getAppBrickHash() {
        return appBrickHash;
    }

    public void addAppBrickHash(String key, AppBrick appBrick) {
        if(!this.appBrickHash.containsKey(key)) {
            this.appBrickHash.put(key, appBrick);
        }
    }

    public void startBox() throws IOException {
        this.dataToWrite = new DataToWrite(this.fileName);
        dataToWrite.addLine(this.boxType+"(");
        this.makeBox();
        this.addBricks();
        dataToWrite.addLine("),");
        dataToWrite.writeFile();


    }

    public abstract void makeBox() throws IOException;

    public void addBricks() throws IOException {
        if(!appBrickHash.isEmpty()){
            for(AppBrick appBrick : appBrickHash.values()){
                appBrick.writeUiBrick();
            }
        }
    }

}
