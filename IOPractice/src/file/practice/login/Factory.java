package file.practice.login;

public class Factory {
    private Factory(){}
    public static IUserService getInstance(){
        return new UserServiceProxy(new UserServiceImpl());
    }
}
