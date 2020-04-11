import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SetBase {
    public static void main(String[] args) {
        Set<Persons> all = new TreeSet<>();
        all.add(new Persons("MIKE",20));
        all.add(new Persons("JACK",19));
        all.add(new Persons("JACK",19));
        all.add(new Persons("FRANK",18));
        all.add(new Persons("Jerry",18));
        System.out.println(all);

    }
}
class Persons implements Comparable<Persons>{
    private String name;
    private int age;

    public Persons(String name, int age) {
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
    public int compareTo(Persons o) {
        if(this.age>o.age){
            return -1;//降序
        }else if(this.age<o.age){
            return 1;
        }else {
            return this.name.compareTo(o.name);//字母顺序的比较
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return age == persons.age &&
                Objects.equals(name, persons.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
