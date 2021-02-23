
import entities.ReadCsvThread;
import entities.ReadJsonThread;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//jsonFile.json
//testFile.csv
//testFileFromXl.csv

public class Write {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext("entities");
        for(int i=0;i<args.length;i++){
            if(args[i].endsWith(".csv")){
                ReadCsvThread readCsvThread=context.getBean(ReadCsvThread.class);
                readCsvThread.setFileName(args[i]);
                readCsvThread.start();
            }else if(args[i].endsWith(".json")){
                ReadJsonThread readJsonThread=context.getBean(ReadJsonThread.class);
                readJsonThread.setFileName(args[i]);
                readJsonThread.start();
            }else if(args[i].endsWith(".xlsx")){
                //new ReadXlsxThread(args[i]).start();
            }else{
                System.out.println("Invalid file extension: "+args[i]);
            }
        }
    }
}
