package entities;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.util.HashMap;

@Component
public class ReadCsvThread extends Thread {
    private String fileName;
    HashMap currencyMap=new HashMap();

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        currencyMap.put("USD",null);
        currencyMap.put("EUR",null);
        currencyMap.put("RUB",null);
        currencyMap.put("GBP",null);
        currencyMap.put("CNY",null);
        currencyMap.put("BTC",null);

        try(CSVReader csvReader = new CSVReader(new FileReader(fileName))){
            //csvReader.skip(1);
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                String result=null;
                SysOutWrite sysOutWrite=new SysOutWrite();
                sysOutWrite.setId(new NumberId().getId());
                if(isNumeric(nextLine[1])){
                    sysOutWrite.setAmount(Double.parseDouble(nextLine[1]));
                }else{
                    sysOutWrite.setAmount(0);
                    result+="Сумма: "+nextLine[1]+" не является числом ";
                }
                if(currencyMap.containsKey(nextLine[2])){
                    sysOutWrite.setCurrency(nextLine[2]);
                }else{
                    sysOutWrite.setCurrency(null);
                    result+=nextLine[2]+" не является валютой ";
                }
                sysOutWrite.setComment(nextLine[3]);
                sysOutWrite.setFileName(fileName);
                if(isNumeric(nextLine[0])){
                    sysOutWrite.setLine(Integer.parseInt(nextLine[0]));
                }else{
                    sysOutWrite.setLine(0);
                    result+="Номер строки: "+nextLine[0]+" не является числом ";
                }
                if(result==null){
                    sysOutWrite.setResult("OK");
                    sysOutWrite.write();
                }else{
                    sysOutWrite.setResult(result);
                    sysOutWrite.write();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}