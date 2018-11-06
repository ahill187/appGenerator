package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataToWrite {

    private String filename;
    private int numberOfLines;
    private List<String> linesOfText;

    public DataToWrite(String filename) {
        this.filename = filename;
        this.linesOfText = new ArrayList<>();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public List<String> getLinesOfText() {
        return linesOfText;
    }

    public void addLine(String line){
        this.linesOfText.add(line);
    }
    public void addArgumentLine(String line, String argument, String delimiter){
        String argumentLine = argument + "="+"\'"+line+"\'"+delimiter;
        this.addLine(argumentLine);
    }
    public void addArgumentLine(int line, String argument, String delimiter){
        String argumentLine = line+"="+Integer.toString(line)+delimiter;
        this.addLine(argumentLine);
    }

    public void addArgumentLine(boolean line, String argument, String delimiter){
        if(line){
            this.addLine(argument+"=TRUE"+delimiter);
        } else{
            this.addLine(argument+"=FALSE"+delimiter);
        }
    }

    public void addFunctionLine(String functionName){
        String functionLine = functionName+"(";
        this.addLine(functionLine);

    }
    public void removeLine(int line){
        this.linesOfText.remove(line);
    }

    public void writeFile(boolean append) throws IOException {
        FileWriter fw = new FileWriter(this.filename, append);

        for (String line : this.linesOfText) {
            fw.write(line);
        }

        fw.close();
    }

    public void writeFile() throws IOException {
        FileWriter fw = new FileWriter(this.filename, true);

        for (String line : this.linesOfText) {
            fw.write(line);
        }

        fw.close();
    }
}
