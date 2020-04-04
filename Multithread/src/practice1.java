public class practice1 {
    public static void main(String args[]){
        MyThreads mt = new MyThreads();
        new Thread(mt,"票贩子A").start();
        new Thread(mt,"票贩子B").start();
        new Thread(mt,"票贩子C").start();
    }
}
class MyThreads implements Runnable{
    private int ticket = 10;
    public synchronized boolean sale(){
        if(this.ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" TICKET LEFT: "+ticket--) ;
            return true;
        }else{
            System.out.println("Null");
            return false;
        }
    }
    public void run(){
        while(this.sale()){

        }
    }
}
