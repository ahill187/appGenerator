package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MetaData {

    public String appTitle = "Burden of COPD in Canada";
    private String dataFile = "testing.csv";




    public void CSVReader() {



            String csvFile = this.dataFile;
            String line = "";
            String cvsSplitBy = ",";

            try (
        BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);

                    System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

                }

            } catch (
        IOException e) {
                e.printStackTrace();
            }

        }

    }


