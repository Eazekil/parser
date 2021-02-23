package entities;

import com.google.gson.Gson;

public class SysOutWrite {
    private long id;
    private double amount;
    private String currency;
    private String comment;
    private String fileName;
    private int line;
    private String result;


    public SysOutWrite(long id,double amount, String currency, String comment, String fileName, int line, String result) {
        this.amount = amount;
        this.currency = currency;
        this.comment = comment;
        this.fileName = fileName;
        this.line = line;
        this.result = result;
        this.id=id;
    }

    public SysOutWrite(){}

    public void write(){
        System.out.println(new Gson().toJson(this));
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
