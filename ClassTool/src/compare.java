import java.util.Arrays;
import java.util.Comparator;

public class compare {
    public static void main(String[] args) {
        Person per[] = new Person[]{
                new Person("Jack",48),
                new Person("pony",49),
                new Person("Mike",20)
        };
        Arrays.sort(per,(Person o1,Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        System.out.println(Arrays.toString(per));


    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //   @Override
//    public int compareTo(Person per) {
//        return this.age - per.age;
//    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
//class PersonComparator implements Comparator<Person>{
//    @Override
//    public int compare(Person o1, Person o2) {
//        return o1.getAge()-o2.getAge();
//    }
//}