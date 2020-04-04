public class toString1 {
    public static void main(String args[]){
        Person perA = new Person("Mike",18);
        Person perB = new Person("Mike",18);

        System.out.println(perA);
        System.out.println(perA.equals(perB));

    }
}
class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "name:"+this.name+"、age:"+this.name;
    }
    public boolean equals(Object obj){
        if(!(obj instanceof Person)){
            return false;
        }
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        Person per = (Person) obj;
        return this.name.equals(per.name) && this.age == per.age;
    }
}
