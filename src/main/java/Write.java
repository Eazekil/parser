
public class Write {
    public static void main(String[] args) {
        System.out.println("i create a maven project");
        for(int i=0;i<args.length;i++){
            if(args[i].endsWith(".csv")){
                new ReadCsvThread(args[i]).start();
            }else if(args[i].endsWith(".json")){
                new ReadJsonThread(args[i]).start();
            }else if(args[i].endsWith(".xlsx")){
                //new ReadXlsxThread(args[i]).start();
                //new FileReadThread(args[i]).start();
            }else{
                System.out.println("Invalid file extension: "+args[i]);
            }
        }
    }
}
