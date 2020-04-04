package file.practice.vote;

import java.util.Scanner;

public class InputUtil {
    private InputUtil(){};
    public static String getString(String prompt){
        boolean flag = true;
        String str = null;
        while (flag){
            Scanner input = new Scanner(System.in);
            System.out.println(prompt);//打印提示信息
            if(input.hasNext()){//如果有输入
                str = input.next().trim();
                if(!"".equals(str)) {//如果输入不为空值
                    flag = false;//结束循环
                }else{
                    System.err.println("输入不允许为null！");
                }
            } else {//如果没输入
                System.err.println("输入不允许为空！");
            }
        }
        return str;
    }

}
