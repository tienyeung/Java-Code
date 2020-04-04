package file.practice.number;

import java.util.Scanner;

public class JavaDemo1 {
    public static void main(String[] args) {
        INumberUtil inu = Factory.getInstance();
        int result[] = inu.stat(3);
        System.out.println("最大值："+result[0]+" 最小值："+result[1]);

    }
}




