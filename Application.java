import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java Ser\""); 
        
        Pattern p = Pattern.compile("\\s");
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> ports = new HashMap<>();

        while(true){
            System.out.print("application> ");       
            String sss = sc.nextLine();
            String[] sar = p.split(sss);
        
            if(sar[0].equals("connect")){
                String address = sar[1];
                String ssss[] = address.split(":");
                String ip = ssss[0];
                int port = Integer.parseInt(ssss[1]);
                System.out.println(port);
                String name = sar[3];
                ports.put(name, port);
                String portsString = mapToString(ports);
                System.out.println(portsString);
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -Dserver.port="+port+" -jar client.jar "+name+" "+portsString+"\""); 
            }
        }
    }
    public static String mapToString(Map<String, Integer> map) {  
        StringBuilder stringBuilder = new StringBuilder();  
       
        for (String key : map.keySet()) {  
         if (stringBuilder.length() > 0) {  
          stringBuilder.append(" ");  
         }  
         String value = Integer.toString(map.get(key)); 
         try {  
          stringBuilder.append((key != null ? URLEncoder.encode(key, "UTF-8") : ""));  
          stringBuilder.append("=");  
          stringBuilder.append(value != null ? URLEncoder.encode(value, "UTF-8") : "");  
         } catch (UnsupportedEncodingException e) {  
          throw new RuntimeException("This method requires UTF-8 encoding support", e);  
         }  
        }  
       
        return stringBuilder.toString();  
       } 

}