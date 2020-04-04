public class Abstracts {
    public static void main(String args[]){
        Action robotAction = new Robot("robot");
        robotAction.command(Action.EAT);
        Action humanAction = new Human();
        humanAction.command(5);
        Action pigAction = new Pig();
        pigAction.command(16);


    }
}

abstract class Action{
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 10;
    public void command(int code){
        switch (code){
            case EAT:{
                this.eat();
                break;
            }
            case SLEEP:{
                this.sleep();
                break;
            }
            case WORK:{
                this.work();
                break;
            }
            case EAT+SLEEP+WORK:{
                this.eat();
                this.sleep();
                this.work();
                break;
            }

        }
    }
    public abstract void eat();
    public abstract void sleep();
    public abstract void work();


}

class Robot extends Action{
    private String name;
    public Robot(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(this.name+" eat battery");
    }
    public void sleep(){}
    public void work(){
        System.out.println(this.name+"work everyday without relax");
    }
}
class Human extends Action{
    public void eat(){
        System.out.println("eat rice");
    }
    public void sleep(){
        System.out.println("sleep at night");
    }
    public void work(){
        System.out.println("work at workdays");
    }
}
class Pig extends Action{
    public void eat(){
        System.out.println("eat shit");
    }
    public void sleep(){
        System.out.println("sleep all day");
    }
    public void work(){}
}
