

public class addsub {
    public static void main(String[] args) {
        Resource res = new Resource();
        AddThread at = new AddThread(res);
        SubThread st = new SubThread(res);
        new Thread(at,"加法线程A").start();
//        new Thread(at,"加法线程B").start();
        new Thread(st,"减法线程X").start();
//        new Thread(st,"减法线程Y").start();
    }
}
class Resource{
    private int num = 0;
    private boolean flag = true;
    public synchronized void add() throws Exception{
        if(!this.flag){
            super.wait();
        }
//        Thread.sleep(100);
        this.num++;
        System.out.println(Thread.currentThread().getName()+"-执行加法操作-num:"+this.num);
        this.flag = false;
        super.notifyAll();
    }
    public synchronized void sub() throws Exception{
        if(this.flag){
            super.wait();
        }
//        Thread.sleep(200);
        this.num--;
        System.out.println(Thread.currentThread().getName()+"-执行减法操作-num:"+this.num);
        this.flag = true;
        super.notifyAll();
    }
}

class AddThread implements Runnable{
    private Resource resource;
    public AddThread(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int x = 0;x<50;x++){
            try{
                this.resource.add();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
class SubThread implements Runnable{
    private Resource resource;
    public SubThread(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int x = 0;x<50;x++){
            try{
                this.resource.sub();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}