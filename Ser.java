import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ser{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888,3344);
        
        while(true){
        Socket s = ss.accept();
        Scanner sc = new Scanner(s.getInputStream());
        int number = sc.nextInt();
        
        number = number +2 ;
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println(number);
        }
        
    }
}