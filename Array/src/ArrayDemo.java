public class ArrayDemo {
    public static void main(String [] args){
        int[] arr =new int[]{1,2,3,4,5,6,7,8,9};
        ArrayUtil1.rev(arr);
        ArrayUtil1.printArray(arr);
}}

class ArrayUtil1{
    public static void rev(int[] arr) {
        int center = arr.length/2;
        int head = 0;
        int tail = arr.length-1;
        for(int x = 0;x<center;x++){
            int tmp=arr[head];
            arr[head]=arr[tail];
            arr[tail]=tmp;
            head++;
            tail--;
        }

    }
    public static void printArray(int [] arr){
        for(int x:arr){
            System.out.println(x);
        }

    }
}
