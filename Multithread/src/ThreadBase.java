public class ThreadBase {
    public static void main(String args[]){
        for(int x = 0;x < 3;x++){
            String title = "线程-"+x;
            new Thread(()->{
                for(int y = 0;y<10;y++){
                    System.out.println(title+" 运行： "+y);
                }
            }).start();
        }

    }
}


class MyThread implements Runnable{
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run(){
        for(int x = 0; x < 10; x++){
            System.out.println(this.title+" running:x = "+x);
        }
    }
}