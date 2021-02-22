package entities;

import org.springframework.stereotype.Component;

@Component
public class ReadTxtThread extends Thread {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /*public ReadTxtThread(String fileName) {
        this.fileName = fileName;
    }*/


    @Override
    public void run() {
        System.out.println("my file is "+fileName);

    }
}
