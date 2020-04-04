import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class practice2 {
    public static void main(String args[]) throws Exception{
        FutureTask<String> task = new FutureTask<>(new MyThread1());
        new Thread(task).start();
        System.out.println("result: "+task.get());
    }
}
class MyThread1 implements Callable<String>{
    @Override
    public String call() throws Exception{
        for(int x = 0; x < 10; x++){
            System.out.println("----start------"+x);
        }
        return "-----end----";
    }
}