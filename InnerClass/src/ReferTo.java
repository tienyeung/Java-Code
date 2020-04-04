public class ReferTo {
    public static void main(String args[]){
       IFunction<Integer,String> fun = String::valueOf;
       String str = fun.转换(100);
       System.out.println(str.length());
    }
}
@FunctionalInterface
//P为参数，R为返回值
interface IFunction<P,R>{
    public R 转换(P p);
}
