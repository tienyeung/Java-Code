import java.util.Arrays;

public class pratice4 {
    public static void main(String[] args) {
        String input = "jack:20:98|mike:18:99|frank:21:98";
        String result[] = input.split("\\|");
        Student student[] =new Student[result.length];
        for(int x=0;x<result.length;x++){
            String temp [] = result[x].split("\\:");
            student[x] = new Student(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
        }
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));
    }
}
class Student implements Comparable<Student>{
    private String name ;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student stu) {
        if(this.score<stu.score){
            return 1;
        }else if(this.score>stu.score){
            return -1;
        }else{
            return this.age-stu.age;
        }
    }
}
