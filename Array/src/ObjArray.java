public class ObjArray {
    public static void main(String args[]){
        Person per[] = new Person[3];
        per[0] = new Person("MIKE",20);
        per[1] = new Person("frank",19);
        per[2] = new Person("jack",18);
        for(Person x:per){
            System.out.println(x.getInfo());
        }

    }
}

class Person{
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getInfo() {
        return "name:" + this.name + "、age:" + this.age ;
    }


}
