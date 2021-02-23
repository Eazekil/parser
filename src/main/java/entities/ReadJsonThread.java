package entities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;


@Component
public class ReadJsonThread extends Thread {
    private String fileName;
    HashMap currencyMap=new HashMap();

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        List<JsonFile> listJson=null;

        currencyMap.put("USD",null);
        currencyMap.put("EUR",null);
        currencyMap.put("RUB",null);
        currencyMap.put("GBP",null);
        currencyMap.put("CNY",null);
        currencyMap.put("BTC",null);

        try {
            Type listJsonType = new TypeToken<List<JsonFile>>() {}.getType();
            listJson = new Gson().fromJson(new FileReader(fileName),listJsonType);
            for(JsonFile jsonFile:listJson){
                String result=null;
                SysOutWrite sysOutWrite=new SysOutWrite();
                sysOutWrite.setId(new NumberId().getId());
                if(isNumeric(jsonFile.getAmount())){
                    sysOutWrite.setAmount(Double.parseDouble(jsonFile.getAmount()));
                }else{
                    sysOutWrite.setAmount(0);
                    result+="Сумма: "+jsonFile.getAmount()+" не является числом ";
                }
                if(currencyMap.containsKey(jsonFile.getCurrency())){
                    sysOutWrite.setCurrency(jsonFile.getCurrency());
                }else{
                    sysOutWrite.setCurrency(null);
                    result+=jsonFile.getCurrency()+" не является валютой ";
                }
                sysOutWrite.setComment(jsonFile.getComment());
                sysOutWrite.setFileName(fileName);
                if(isNumeric(jsonFile.getOrderId())){
                    sysOutWrite.setLine(Integer.parseInt(jsonFile.getOrderId()));
                }else{
                    sysOutWrite.setLine(0);
                    result+="Номер строки: "+jsonFile.getOrderId()+" не является числом ";
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