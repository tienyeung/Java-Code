package cn.practice.proxy;
//传统开发（静态代理）：代理类，real类
//缺陷：主类需要明确知道代理类和其real类；一个代理类只为一个接口服务，若有多个接口则需编写多个代理类
public class StaticProxyDemo {
    public static void main(String[] args) {
         IMessage msg = new MessageProxy(new Message());
         msg.send();
    }
}
interface IMessage{
    public void send();

}
class Message implements IMessage{
    @Override
    public void send() {
        System.out.println("send Message!");
    }
}
class MessageProxy implements IMessage{
    //对于Message类的补充与完善
    private IMessage message;

    public MessageProxy(IMessage message) {
        this.message = message;
    }

    @Override
    public void send() {
        if(this.connect()){
            this.message.send();
            this.close();
        }
    }
    public boolean connect(){
        System.out.println("connecting...");
        return true;
    }
    public void close(){
        System.out.println("Channel Close!");
    }
}
