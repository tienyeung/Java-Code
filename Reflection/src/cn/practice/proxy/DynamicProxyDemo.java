package cn.practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理：所有功能一致的业务接口提供统一的代理处理类
 * 动态代理类不再和某个接口捆绑，可通过反射机制获取所有接口
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        IMessage msg = (IMessage) new DynaProxy().bind(new MessageReal());
        msg.send();
    }
}
interface IMessages{
    public void send();
}
class MessageReal implements IMessage{
    @Override
    public void send() {
        System.out.println("Send Message!");
    }
}
class DynaProxy implements InvocationHandler {
    private Object target;//真实业务对象

    /**
     * 真实业务对象同代理业务对象的绑定处理
     * @param target 真实业务对象
     * @return Proxy生成的代理业务对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public boolean connect(){
        System.out.println("connecting...");
        return true;
    }
    public void close(){
        System.out.println("Channel Close!");
    }
    @Override
    public Object invoke(Object pro, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法： "+method);
        Object returnData = null ;
        if(this.connect()){
            returnData = method.invoke(this.target,args);
            this.close();
        }
        return returnData;
    }
}