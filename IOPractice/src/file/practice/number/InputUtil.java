package file.practice.number;

import java.util.Scanner;

public class InputUtil {
    private InputUtil(){};
    public static int getInt(String prompt){
        boolean flag = true;
        int num = 0;
        while (flag){
            Scanner input = new Scanner(System.in);
            System.out.println(prompt);//打印提示信息
            if(input.hasNext("\\d+")){
                flag = false;
                num = Integer.parseInt(input.next("\\d+"));
            }else{
                System.err.println("Wrong Format!Try again~");
            }
        }
        return num;
    }
}
