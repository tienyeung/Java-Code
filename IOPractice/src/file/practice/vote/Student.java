package file.practice.vote;

public class Student implements Comparable<Student> {
    private String name;
    private long sid;
    private int vote;

    public Student(String name, long sid, int vote) {
        this.name = name;
        this.sid = sid;
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return
                "{name='" + name + '\'' +
                ", sid=" + sid +
                ", vote=" + vote+"}" ;
    }

    @Override
    public int compareTo(Student stu) {
        return stu.vote - this.vote;
    }
}
