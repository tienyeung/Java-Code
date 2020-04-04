public class Practice1 {
    public static void main(String args[]){
        Person person = new Person("Mike",20);
        Person childA = new Person("Frank",19);
        Person childB = new Person("John",18);
        childA.setCar(new Car("Tesla3",300000.0));
        childB.setCar(new Car("Tesla ModelX",1000000.0));
        person.setChildren(new Person[]{childA,childB});

        Car car = new Car("BMW X5",200000.0);
        person.setCar(car);
        car.setPerson(person);
        //类间调用
        System.out.println(person.getCar().getInfo());
        System.out.println(car.getPerson().getInfo());
        for(Person x:person.getChildren()){
            System.out.println(x.getCar().getInfo());
        }


    }
}
class Car{
    private String name;
    private double price;
    private Person person;
    public Car(String name, double price){
        this.name = name;
        this.price = price;
    }
    public void setPerson(Person person){
        this.person = person;
    }
    public Person getPerson(){
        return this.person;
    }

    public String getInfo(){
        return "name:" + name + "、price:" + price;
    }

}
class Person{
    private String name;
    private int age;
    private Car car;
    //类内关系
    private Person children [];
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setChildren(Person children[]){
        this.children = children;
    }
    public Person[] getChildren(){
        return this.children;
    }
    public void setCar(Car car){
        this.car = car;
    }
    public Car getCar(){
        return this.car;
    }
    public String getInfo(){
        return "name:" + name + "、age:" + age;
    }
}
