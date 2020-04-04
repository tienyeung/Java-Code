public class practice {
    public static void main(String args[]){
        Students stu = new Students("Mike","Peking",'男',18,98.5,88);
        System.out.println(stu.getInfo());

    }
}
class Person1{
    private String name;
    private String addr;
    private char sex;
    private int age;

    public Person1(){}
    public Person1(String name,String addr){
        this(name,addr,'男',0);
    }
    public Person1(String name,String addr,char sex,int age){
        this.name = name ;
        this.addr =addr ;
        this.sex = sex;
        this.age = age;
    }
    public String getInfo(){
        return "姓名："+this.name+"、地址："+this.addr+"、性别:"+this.sex+"、年龄："+this.age ;
    }

}
class Students extends Person1{
    private double math ;
    private double english;
    public Students(){}
    public Students(String name ,String addr){
        super(name,addr);
    }
    public Students(String name,String addr,char sex,int age,double math,double english){
        super(name,addr,sex,age);
        this.math = math;
        this.english = english;

    }
    public String getInfo(){
        return super.getInfo()+"、数学："+this.math+"、英语："+this.english;
    }
}
