package entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


@Component
public class ReadJsonThread extends Thread {
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        ObjectMapper mapper = new ObjectMapper();
        List<JsonFile> listJson=null;
        try {
            Type listJsonType = new TypeToken<List<JsonFile>>() {}.getType();
            listJson = new Gson().fromJson(new FileReader(fileName),listJsonType);
            for(JsonFile jsonFile:listJson){
                //jsonFile.get
                //String firstName = (String) jo.get("firstName");

                new SysOutWrite(new NumberId().getId(),jsonFile.getAmount(),jsonFile.getCurrency(),jsonFile.getComment(),fileName,jsonFile.getOrderId(),"OK");
            }

            /*JsonFile jsonFile = mapper.readValue(new File(fileName), JsonFile.class);
            System.out.println(jsonFile.getAmount()+"  "+jsonFile.getOrderId());*/
        } catch (Exception e) {
            System.out.println(e);
        }
        /*if(listJson!=null){
            for(JsonFile jsonFile:listJson){
                new SysOutWrite(new NumberId().getId(),jsonFile.getAmount(),jsonFile.getCurrency(),jsonFile.getComment(),fileName,jsonFile.getOrderId(),"OK");
            }
        }*/




    }
}