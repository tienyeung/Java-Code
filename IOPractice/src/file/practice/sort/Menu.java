package file.practice.sort;

import file.practice.reverse.Factory;
import file.practice.reverse.IStringService;
import file.practice.reverse.InputUtil;

import java.util.Arrays;

/**
 * 自定义可视化界面
 */

public class Menu {
    public Menu(){
        this.choose();
    };
    public void choose(){
        this.show();
        String choose = InputUtil.getString("请按序号进行选择： ");
        switch(choose){
            case "1":{
                String str = InputUtil.getString("请输入追加数据： ");
                IStudentService iss = Factory1.getInstance();
                iss.append(str);
                choose();
            }
            case "2":{
                IStudentService iss = Factory1.getInstance();
                System.out.println(Arrays.toString(iss.getDate()));
                choose();
            }
            case "0":{
                System.out.println("结束操作");
                System.exit(1);
            }
            default:{
                System.err.println("非法选项！");
                choose();
            }

        }
    }
    public void show(){
        System.out.println("1：追加字符串数据");
        System.out.println("2：显示所有学生数据");
        System.out.println("0：结束操作！");
        System.out.println("\n");

    }
}
