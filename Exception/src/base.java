public class base {
    public static void main(String args[]){
        try{
            System.out.println(MyMath.div(10,0));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class MyMath{
    public static int div(int x,int y) throws Exception{
        int tmp = 0;
        System.out.println("start");
        try{
            tmp = x/y;
        }catch(Exception e){
            throw e;
        }finally {
            System.out.println("异常处理");
        }
        System.out.println("end");
        return tmp;
    }
}
