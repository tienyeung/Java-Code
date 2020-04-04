import java.util.Scanner;

public class scan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if(scan.hasNextInt()){
            int age = scan.nextInt();
        }else{
            System.err.println("err!");
        }
    }
}
