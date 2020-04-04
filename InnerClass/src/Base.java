
public class Base {
    public static void main(String args[]){
        Outer.Inner oi = new Outer().new Inner();
        oi.print();
    }
}

class Outer{
    private String msg = "hello";
    public void fun(){
        Inner in = new Inner();
        in.print();
    }
    class Inner{
        public void print(){
            System.out.println(Outer.this.msg);
        }
    }
}
