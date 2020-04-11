import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClient {
    public static void main(String[] args) throws IOException {//client receive msg
        DatagramSocket client = new DatagramSocket(9999);//create client:9999
        byte data[] = new byte[1024] ;//receive msg
        DatagramPacket packet = new DatagramPacket(data, data.length);
        System.out.println("waiting for msg...");
        client.receive(packet);
        System.out.println("msg: "+new String(data,0,packet.getLength()));
        client.close();
    }
}
