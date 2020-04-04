package file.practice.login;

public class UserServiceImpl implements IUserService {
    private int count;

    @Override
    public boolean isExit() {//输错3次自动退出
        return this.count >= 3;
    }

    @Override
    public boolean login(String name, String password) {
        this.count++;
        return "yang".equals(name) && "hello".equals(password);
    }
}
