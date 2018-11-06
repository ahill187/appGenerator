package shiny;

import model.DataToWrite;
import model.TabBox;

import java.io.IOException;
import java.util.Map;

public class box extends TabBox {

    private boolean solidHeader;
    private String title;
    private String status;
    private int width;
    private int height;

    public box(String boxType, Map<String, TabBox> listOfTabBoxes, String fileName,
               boolean solidHeader, String title, String status, int width, int height) {
        super(boxType, listOfTabBoxes, fileName);
        this.title = title;
        this.status = status;
        this.solidHeader = solidHeader;
        this.width=width;
        this.height=height;
    }

    public box(String boxType, String fileName,
               boolean solidHeader, String title, String status, int width, int height) {
        super(boxType, fileName);
        this.title = title;
        this.status = status;
        this.solidHeader = solidHeader;
        this.width=width;
        this.height=height;
    }

    @Override
    public void makeBox() throws IOException {
        System.out.println("Testing");
        this.dataToWrite.addArgumentLine(this.solidHeader, "solidHeader", ",");
        this.dataToWrite.addArgumentLine(this.title, "title", ",");
        this.dataToWrite.addArgumentLine(this.status, "status",",");
        this.dataToWrite.addArgumentLine(this.width, "width",",");
        this.dataToWrite.addArgumentLine(this.height, "height",",");
        this.dataToWrite.writeFile();
    }
}
