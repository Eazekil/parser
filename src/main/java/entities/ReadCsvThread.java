package entities;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class ReadCsvThread extends Thread {
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {


        try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                String[] s=reader.readLine().split(",");


                System.out.println(reader.readLine());
                System.out.println(NumberId.getId());
                //NumberId.setId(NumberId.getId()+1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


        /*try(CSVReader csvReader = new CSVReader(new FileReader(fileName))){
            csvReader.skip(1);
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                for (String cell : nextLine) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}