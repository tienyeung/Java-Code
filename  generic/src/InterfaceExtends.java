public class InterfaceExtends {
    public static void main(String args[]){
        IMessage<String> msg = new MessageImpl();
        System.out.println(msg.echo("hello"));
    }
}
interface IMessage<T>{
    public String echo(T t);
}
class MessageImpl implements IMessage<String>{
    public String echo(String t){
        return "子类 ："+t;
    }
}
