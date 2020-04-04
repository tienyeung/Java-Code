package file.practice.vote;

import file.practice.number.INumberUtil;
import file.practice.number.INumberUtilImpl;

public class Factory {
    private Factory(){};
    public static IVoteService getInstance(){
        return new VoteServiceImpl();
    }
}
