public class ComputerPC {
    public static void main(String[] args) {
        Resource1 res = new Resource1();
        new Thread(new Producer1(res)).start();
        new Thread(new Comsumer1(res)).start();

    }
}
class Computer{
    private static int count = 0;
    private String name;
    private int price;
    public Computer(String name,int price){//每实例化一次count即生产个数+1
        this.name = name;
        this.price = price;
        this.count++;
    }
    public String toString(){
        return "第"+count+"台名为"+this.name+"价格为"+this.price+"的新的电脑: ";
    }
}
class Resource1{
    private Computer computer;
    public synchronized void make() throws Exception{
        if(this.computer!=null) {
            super.wait();
        }
        this.computer = new Computer("Dell", 3999);
        System.out.println("生产"+this.computer);
        super.notifyAll();
    }
    public synchronized void get() throws Exception{
        if(this.computer==null){
            super.wait();
        }
        System.out.println("取出"+this.computer);
        this.computer = null;
        super.notifyAll();
    }

}
class Producer1 implements Runnable{
    private Resource1 resource;
    public Producer1(Resource1 resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int x = 0; x < 50;x++){
            try {
                this.resource.make();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Comsumer1 implements Runnable{
    private Resource1 resource;
    public Comsumer1(Resource1 resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int x = 0; x < 50;x++){
            try {
                this.resource.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
