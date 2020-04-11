import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(9000);//connect to client
        String str = "hello,world!";
        DatagramPacket packet = new DatagramPacket(str.getBytes(),0,str.length(), InetAddress.getByName("localhost"),9999);
        server.send(packet);
        System.out.println("send msg!");
        server.close();
    }
}
