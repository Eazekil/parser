import com.opencsv.CSVReader;

import java.io.FileReader;

public class ReadCsvThread extends Thread {
    private String fileName;

    public ReadCsvThread(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void run() {
        try(CSVReader csvReader = new CSVReader(new FileReader(fileName))){
            csvReader.skip(1);//если заголовок отсутствует поставить 0
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                for (String cell : nextLine) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}