import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cli {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        String reg = args[1];
        Scanner sc = new Scanner(System.in);
        System.out.print(args[0]+"> ");
        int num,temp;
        Socket s = new Socket("127.0.0.1",8888);
        Scanner sin = new Scanner(s.getInputStream());
        
        

        
        Pattern p = Pattern.compile("\\s");

        

        System.out.println("do you want connect again : y Y");
        String c = sc.nextLine();

        Map<String,Integer> ports = new HashMap<>();
        for (int i = 1; i < args.length; i++){
            String[] little = args[i].split("=");
            ports.put(little[0],Integer.parseInt(little[1]));
        }
        

        while(true){
            System.out.print(args[0]+"> ");       
            String sss = sc.nextLine();
            String[] sar = p.split(sss);
        
            if(sar[0].equals("num")){
                System.out.println("Enter a number");
                num = sc.nextInt();
                PrintStream ps = new PrintStream(s.getOutputStream());
                ps.println(num);

                temp = sin.nextInt();
                System.out.println(temp);
            }
            if(sar[0].equals("list")){
                printList(ports);
            }
        }


        

    }
    public static void printList(Map<String,Integer> ports){
        for(String key : ports.keySet()){
            System.out.println(key +" : "+ports.get(key)); 
        }
    }
}