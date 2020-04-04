public class PC {
    public static void main(String[] args) {
        Messaged msg = new Messaged();
        new Thread(new Producer(msg),"线程A").start();
        new Thread(new Consumer(msg),"线程B").start();
    }
}
class Messaged{//公共资源
    private String title;
    private String content;
    public boolean flag = true;//true:允许生产，不允许消费；false:允许消费，不允许生产；
//
    public synchronized void set(String title,String content) throws InterruptedException {
        if(!this.flag){//如果在消费状态则等待
            try{
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.title = title;
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;//生产完毕改变状态
        super.notify();//唤醒等待的线程
    }
    public synchronized String get(){
        if(this.flag){//如果在生产则等待
            try{
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try {
            return this.title + " - " + this.content;
        }finally {
            this.flag = true;
            super.notify();
        }
    }
}
class Producer implements Runnable{
    private Messaged msg;
    public Producer(Messaged msg){
        this.msg = msg;
    }
    public void run(){
        for(int x =0 ; x < 100 ;x++){
            if(x%2==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    msg.set("jack","悔创阿里");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    msg.set("Pony","普通家庭");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Consumer implements Runnable{
    private Messaged msg;
    public Consumer(Messaged msg){
        this.msg = msg;
    }
    public void run(){
        for(int x = 0;x<100;x++){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" - "+this.msg.get());
    }}
}
