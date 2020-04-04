import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Answer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Responder mt = new Responder();//实例化callable子类
        FutureTask<String> taskA = new FutureTask<>(mt);//生成callable对象
        FutureTask<String> taskB = new FutureTask<>(mt);
        FutureTask<String> taskC = new FutureTask<>(mt);
        new Thread(taskA,"竞赛者A").start();//对每个callable对象建立线程
        new Thread(taskB,"竞赛者B").start();
        new Thread(taskC,"竞赛者C").start();
        System.out.println(taskA.get());//获取每个线程的状态
        System.out.println(taskB.get());
        System.out.println(taskC.get());

    }
}
class Responder implements Callable<String>{
    private boolean flag = false;//抢答状态，false表示任何人都未抢答到；

    @Override
    public String call() throws Exception {
        synchronized (this){
            if(!this.flag){
                this.flag = true;
                return Thread.currentThread().getName()+" 抢答成功";
            }else{
                return Thread.currentThread().getName()+" 抢答失败";
            }
        }
    }
}
