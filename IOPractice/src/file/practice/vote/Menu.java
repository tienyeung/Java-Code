package file.practice.vote;

import file.practice.reverse.IStringService;

import java.util.Arrays;

/**
 * 自定义可视化界面
 */

public class Menu {
    private IVoteService voteService ;
    public Menu(){
        this.voteService = Factory.getInstance();
        this.vote();
    }
    public void vote(){
        Student stu [] = this.voteService.showData();
        for(Student temp:stu){
            System.out.println(temp.getSid()+": "+temp.getName()+" ["+temp.getVote()+"]");
        }
        int num = 1;
        while(num!=0){
            num = Integer.parseInt(InputUtil.getString("请输入编号： "));
            if(num!=0 && !this.voteService.inc(num)){
                System.err.println("此选号无效，请重新输入！");
            }
        }
        System.out.println("最终投票结果：");
        Student results[] = this.voteService.result();
        for(Student temp:results){
            System.out.println(temp.getSid()+": "+temp.getName()+" ["+temp.getVote()+"]");
        }
        System.out.println(results[0].getName()+"同学以"+results[0].getVote()+"票当选！");

    }
}
