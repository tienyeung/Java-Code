import java.lang.reflect.InvocationTargetException;

public class base {
    public static void main(String[] args) throws Exception{
        IMessage msg = Factory.getInstance("Message",IMessage.class);
        msg.send();
    }
}
interface IMessage{
    public void send();
}
class Message implements IMessage{
    @Override
    public void send() {
        System.out.println("信息发送！");

    }
}
interface IService{
    public void serve();
}
class Service implements IService{
    @Override
    public void serve() {
        System.out.println("服务！");
    }
}
class Factory{
    private Factory(){}
    @SuppressWarnings("uncheck")
    public static <T>T getInstance(String className,Class<T> clazz){
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}

