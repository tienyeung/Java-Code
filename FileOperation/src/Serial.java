import com.sun.tools.classfile.ConstantPool;

import java.io.*;

public class Serial {
    private static final File SAVE_FILE =  new  File("/Users/apple/Downloads/FileOperation/src/hello.person");
    public static void main(String[] args) throws Exception {
        saveObject(new Person("Mike",20));
        System.out.println(loadObject());

    }
    public static void saveObject(Object obj) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);
        oos.close();
    }
    public static Object loadObject() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}
class Person implements Serializable{//person can be serializable
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
}
