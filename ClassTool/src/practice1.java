import java.util.Arrays;
import java.util.Random;

public class practice1 {
    public static void main(String[] args) {
        int result[] = NumberFactory.create(10);
        System.out.println(Arrays.toString(result));

    }
}
class NumberFactory{
    private static Random random = new Random();
    /**
    *
    * @param: size of Arrays
    * @return: 返回随机数组，不包括0；
    */
    public static int [] create(int len){
        int data[] = new int[len];
        int foot = 0;
        while(foot<data.length){
            int num = random.nextInt(30);
            if(num!=0){
                data[foot++]=num;
            }
        }
        return data;
    }

}
