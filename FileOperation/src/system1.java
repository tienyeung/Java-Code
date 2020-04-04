import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class system1 {
    public static void main(String[] args) throws IOException {
        InputStream input = System.in;//键盘输入流
        System.out.println("please input : ");
        byte data[] = new byte[1024];
        int len = input.read(data);
        System.err.println("输出数据为: "+new String(data,0,len));

    }
}
