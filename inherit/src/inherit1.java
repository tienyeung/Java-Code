public class inherit1 {
    public static void main(String args[]){
        Student stu = new Student("Jack",18,"THU");

        System.out.println("Name:"+stu.getName()+"、Age:"+stu.getAge()+
                "、School:"+stu.getSchool());

    }
}
class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person{
    private String school;
    public Student(String name ,int age, String school){
        super(name,age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}
