public class ThreadLocall {
    public static void main(String[] args) {
        new Thread(()->{
            Message msg = new Message();
            msg.setMsg("No.1");
            Channel.set(msg);
            Channel.send();
        },"发送者A").start();
        new Thread(()->{
            Message msg = new Message();
            msg.setMsg("No.2");
            Channel.set(msg);
            Channel.send();
        },"发送者B").start();
        new Thread(()->{
            Message msg = new Message();
            msg.setMsg("No.3");
            Channel.set(msg);
            Channel.send();
        },"发送者C").start();

    }
}
class Channel{
//    private static Message msg;
    private static final ThreadLocal<Message> THREADLOCAL=new ThreadLocal<Message>();

    public static void set(Message m) {
        THREADLOCAL.set(m);
    }

    public static void send() {
        System.out.println(Thread.currentThread().getName()+" 消息："+THREADLOCAL.get().getMsg());
    }
}
class Message{
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
