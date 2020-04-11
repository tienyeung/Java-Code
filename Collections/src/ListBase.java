import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListBase {
    public static void main(String[] args) {
        List<Person> all = new ArrayList<>();
        all.add(new Person("mike",20));
        all.add(new Person("jack",18));
        all.remove(new Person("jack",18));//要覆写equals()，否则放进去的实例查找不到；
        //在进行删除操作时，实际上是用放进去的实例与List数组中的对象一一比较，这是用equals先定义好了两个对象相同的条件，在进行定位然后删除
        System.out.println(all);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Person)) return false;
        Person person = (Person) o;
        return this.name.equals(person.name) && this.age == person.age;
    }

}
