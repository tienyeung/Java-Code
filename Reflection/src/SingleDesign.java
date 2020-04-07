public class SingleDesign {
    public static void main(String[] args) {
        for (int x = 0 ; x < 3;x++) {
            new Thread(()->{
                Singleton.getInstance().print();
            }, "单例线程"+x).start();
        }
    }
}
class Singleton{
    //单例设计/
    /**
     * 1.构造方法私有
     * 2.静态实例化对象初始为空，且不创建副本
     * 3.线程同步
     * 单例设计例子：Runtime类，Spring框架
     */
    private static int count ;
    private static volatile Singleton instance = null;
    private Singleton(){
        count++;
        System.out.println("实例化"+count+"次");
    }
//    public static synchronized Singleton getInstance(){
////        if(instance == null){
////            instance = new Singleton();
////        }
////        return instance;
////    }
    public static Singleton getInstance(){//上述实现存在效率问题
        if(instance == null) {//保证单例
            synchronized (Singleton.class) {
                if(instance == null) {//保证单线程进入
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public void print(){
        System.out.println(Thread.currentThread().getName()+" 单例设计启动");
    }
}
