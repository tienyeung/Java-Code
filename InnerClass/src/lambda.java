public class lambda {
    public static void main(String args[]){
        IMessage msg = (t1,t2)-> t1+t2;
        System.out.println(msg.add(1,2));
    }
}
@FunctionalInterface
interface IMessage{
    public int add(int x,int y);
}
