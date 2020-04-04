public class Interface2 {
    public static void main(String args[]){}
}
interface IMessage2{
    public abstract void getInfo();
}
interface IChannel2{
    boolean connect();

}
interface IService extends IMessage2,IChannel2{
    //接口的多继承
    public String service();
}

class MessageService implements IService{
    public void getInfo(){}
    public boolean connect(){
        return true;
    }
    public String service(){
        return "服务";
    }


}
