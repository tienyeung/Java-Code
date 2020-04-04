public class Interface3 {
    public static void main(String args[]){
        IMessage3 msg = new MessageImpl3();
        if(msg.connect()){
            System.out.println(msg.getInfo());
        }
    }
}
interface IMessage3{
    public String getInfo();
    public default boolean connect(){//普通方法
        return true;
    }
}
class MessageImpl3 implements IMessage3{
    public String getInfo(){
        return "hello";
    }
}
