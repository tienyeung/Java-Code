package file.practice.login;
//登陆失败的检测操作类
public class UserServiceProxy implements IUserService {
    private IUserService userService;
    public UserServiceProxy(IUserService userService){
        this.userService = userService;
    }
    @Override
    public boolean isExit() {
        return this.userService.isExit();
    }

    @Override
    public boolean login(String name, String password) {
        while(!this.isExit()){
            String inputData = InputUtil.getString("请输入登录信息： ");
            if(inputData.contains("/")){//输入了用户名及密码
                String temp[] = inputData.split("/");
                if(this.userService.login(temp[0],temp[1])){
                    return true;
                }else{
                    System.err.println("错误的用户名及密码!");
                }

                }else{//只输入了用户名
                    String pwd = InputUtil.getString("请务必输入密码： ");
                if(this.userService.login(inputData,pwd)){
                    return true;
                }else{
                    System.err.println("错误的用户名及密码!");
                }


            }
        }
        return false;
    }
}
