public class practice3 {
    public static void main(String[] args) {
        for(int x = 0;x < 5;x++){
            new Thread(()->{
                for(int y = 0 ;y < 10;y++){
                    System.out.println(Thread.currentThread().getName()+" x: "+ y);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"线程-"+x).start();
        }

    }
}
//class MyThread2 implements Runnable{
//    public void run(){
//        System.out.println(Thread.currentThread().getName());
//
//    }
//}
