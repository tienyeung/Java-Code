import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private static class ClientThread implements Runnable{
        //BIO
        private Socket client = null;
        private Scanner scan = null;
        private PrintStream out = null;
        private boolean flag = true;

        public ClientThread(Socket client) throws IOException {
            this.client = client;
            this.scan = new Scanner(client.getInputStream());
            this.scan.useDelimiter("\n");
            this.out = new PrintStream(client.getOutputStream());
        }

        @Override
        public void run() {
            while(flag){
                if(scan.hasNext()){
                    String val = scan.next().trim();
                    if("byebye".equalsIgnoreCase(val)){
                        out.println("Bye~");
                        this.flag = false;
                    }else{
                        out.println("[Echo]"+val );
                    }
                }
            }
            try {
                scan.close();
                out.close();
                client.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("Waiting...");
        //receive msg from Client,then send msg back to Client
        boolean flag = true;
        while(flag){
            Socket client = server.accept();//client connect
            new Thread(new ClientThread(client)).start();
        }

        server.close();
    }
}
