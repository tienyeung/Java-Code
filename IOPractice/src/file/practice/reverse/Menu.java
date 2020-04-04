package file.practice.reverse;

import java.util.Arrays;

/**
 * 自定义可视化界面
 */

public class Menu {
    private IStringService iss ;
    public Menu(){
        this.iss = Factory.getInstance();
        this.choose();
    };
    public void choose(){
        this.show();
        String choose = InputUtil.getString("请按序号进行选择： ");
        switch(choose){
            case "1":{
                String str = InputUtil.getString("请输入追加数据： ");
                this.iss.append(str);
                choose();
            }
            case "2":{
                String result [] = this.iss.reverse();
                System.out.println(Arrays.toString(result));
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
        System.out.println("2：逆序显示所有数据");
        System.out.println("0：结束操作！");
        System.out.println("\n");

    }
}
