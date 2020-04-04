package file.practice.vote;

import java.util.Arrays;

public class VoteServiceImpl implements IVoteService {
    private Student[] students = new Student[]{//初始化候选人
            new Student("Mike",1,0),
            new Student("Jack",2,0),
            new Student("Frank",3,0),
            new Student("Jerry",4,0),
    };
    @Override
    public boolean inc(long sid) {
        for(int x = 0; x < students.length; x++){
            if(this.students[x].getSid()==sid){
                this.students[x].setVote(this.students[x].getVote()+1);
                return true;
            }
        }
        return false;
    }

    @Override
    public Student[] result() {
        Arrays.sort(this.students);
        return this.students;
    }

    @Override
    public Student[] showData() {
        return this.students;
    }
}
