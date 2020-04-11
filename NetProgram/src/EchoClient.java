import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost",9999);//define connect info
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while(flag){
            String input = getString("please input content:").trim();
            out.println(input);
            if(scan.hasNext()){
                System.out.println(scan.next());
            }
            if("byebye".equals(input)){
                flag = false;
            }
        }
        scan.close();
        out.close();
        client.close();
    }
    public static String getString(String prompt) throws IOException {
        System.out.println(prompt);
        String str = KEYBOARD_INPUT.readLine();
        return str;
    }
}
