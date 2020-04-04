public class ToUp {
    public static void main(String args[]){
//        fun(new SonMessage());
        Message msg = new SonMessage();
        msg.print();
        SonMessage msg1 = (SonMessage) msg;
        msg1.fire();
    }
    public static void fun(Message msg){
        msg.print();
    }
}
class Message {
    public void print(){
        System.out.println("----Father------");
    }
}
class SonMessage extends Message{
    @Override
    public void print(){
        System.out.println("-----Son-----");
    }
    public void fire(){
        System.out.println("i can fire");
    }
}
