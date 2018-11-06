package model;

import java.io.IOException;

public class MapBrick extends AppBrick {

    private String width;

    public MapBrick(Tab tab, DataToWrite dataToWrite, String brickId, int width) {
        super(tab, dataToWrite, brickId);
        //this.width = width;
    }
    public MapBrick(Tab tab, DataToWrite dataToWrite, String brickId, String width) {
        super(tab, dataToWrite, brickId);
        this.width = width;
    }

    @Override
    public void writeUiBrick() throws IOException {
        dataToWrite.addFunctionLine("leafletOutput");
        dataToWrite.addArgumentLine(brickId, "id", ",");
        dataToWrite.addArgumentLine(width, "width", "");
        dataToWrite.writeFile();
    }

    @Override
    public void writeServerBrick() {

    }
}
