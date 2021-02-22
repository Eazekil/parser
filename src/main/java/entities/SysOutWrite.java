package entities;

import com.google.gson.Gson;

public class SysOutWrite {
    private   long id;
    private Object amount;
    private String currency;
    private String comment;
    private String fileName;
    private int line;
    private String result;

    public SysOutWrite(long id,Object amount, String currency, String comment, String fileName, int line, String result) {
        this.amount = amount;
        this.currency = currency;
        this.comment = comment;
        this.fileName = fileName;
        this.line = line;
        this.result = result;
        this.id=id;
        write();
    }
    public void write(){
        System.out.println(new Gson().toJson(this));
        //“id”:1, ”amount”:100, ”comment”:”оплата заказа”, ”filename”:”orders.csv”, ”line”:1, ”result”:”OK”
    }
}
