import java.util.Timer;
import java.util.TimerTask;

public class Time {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(),0);

    }
}
class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Time: "+System.currentTimeMillis());
    }
}
