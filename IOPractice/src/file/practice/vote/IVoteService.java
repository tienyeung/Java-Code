package file.practice.vote;

public interface IVoteService {
    public boolean inc(long sid);//根据编号进行增长
    public Student[] result();
    public Student[] showData();
}
