public class Sort {
    public static void main(String [] args){
        int[] data = new int[]{8,9,10,7,3,1,6,5};
        Bubble.sort(data);
        Bubble.printArray(data);
    }
}
class Bubble{
    public static void sort(int[] data) {
        for(int y=0;y<data.length-1;y++){
            for(int x=0;x<data.length-y-1;x++){
                if(data[x]>data[x+1]){
                    int tmp=data[x];
                    data[x]=data[x+1];
                    data[x+1]=tmp;
                }
            }
        }
    }


    public static void printArray(int[] data){
        for(int x:data){
            System.out.println(x);
        }
    }
}
