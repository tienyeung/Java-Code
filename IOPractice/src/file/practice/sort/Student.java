package file.practice.sort;

public class Student implements Comparable<Student> {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", score=" + score ;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score>o.score){
            return -1;
        }else if(this.score<o.score){
            return 1;
        }else {
            return 0;
        }
    }
}
