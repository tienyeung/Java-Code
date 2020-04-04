import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bufferedReader1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please input your AGE: ");
        String msg = input.readLine();
        if(msg.matches("\\d{1,3}")){
            int age = Integer.parseInt(msg);
            System.out.println("your age is "+age+ " years old!");
        }else {
            System.err.println("Wrong Format!");
        }
    }
}
