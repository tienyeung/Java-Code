public class ArrayTool {
    public static void main(String args[]){
        int[] arr = new int[]{1,3,6,2,5,4,10};
        int[] brr = new int[]{11,22,33,44,55,66};
        System.arraycopy(arr,2,brr,3,2);
        ArrayUtil2.printArray(brr);
    }
}
class ArrayUtil2{

    public static void printArray(int [] arr){
        for(int x:arr){
            System.out.println(x);
        }

    }
}
