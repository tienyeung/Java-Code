public class Interface1 {
    public static void main(String args[]){
        IMessage msg = new MessageImpl();
        System.out.println(msg.getInfo());
        //接口相互转型
        IChannel chl = (IChannel) msg;
        System.out.println(chl.connect());
        //与Object转型
        Object obj = chl;
        IChannel chl2 = (IChannel) obj;
        System.out.println(chl2.connect());

    }
}

interface IMessage{
    public static final String INFO = "hello";
    public abstract String getInfo();

}
interface IChannel{
    public abstract boolean connect();
}
class MessageImpl implements IMessage,IChannel{
    public String getInfo(){
        if(this.connect()){
        return "get a msg...";
        }
        return "missing";
    }
    public boolean connect(){
        System.out.println("connecting......");
        return true;
    }
}
