public class Arrays {
    public static void main(String args[]) {
//        SortArray arr = new SortArray(3);
        ReverseArray arr = new ReverseArray(3);
        System.out.println(arr.add(1));
        System.out.println(arr.add(2));
        System.out.println(arr.add(3));
        System.out.println(arr.add(5));
        arr.incrData(1);
        System.out.println(arr.add(4));
        int result[] = arr.getData();
        for(int tmp:result){
            System.out.println(tmp);
        }



    }
}

class Array{
    private int[] data;
    private int foot;
    public Array(int n){
        if(n>0){
            this.data = new int[n];
        }else{
            this.data = new int[1];
        }
    }
    public boolean add(int num){
        if(this.foot < this.data.length){
            data[this.foot++]=num;
            return true;
        }
        return false;

    }
    public void incrData(int num){//扩展数组
        int newData[] = new int[this.data.length+num];
        System.arraycopy(this.data,0,newData,0,this.data.length);
        this.data = newData;
    }
    public int[] getData(){
        return this.data;
    }
}

class SortArray extends Array{
    public SortArray(int len){
        super(len);
    }
    public int[] getData(){
        java.util.Arrays.sort(super.getData());
        return super.getData();
    }
}
class ReverseArray extends Array{
    public ReverseArray(int len){
        super(len);
    }
    public int[] getData(){
        int center = super.getData().length/2;
        int head=0;
        int tail=super.getData().length-1;
        for(int x=0;x<center;x++){
            int tmp = super.getData()[head];
            super.getData()[head]=super.getData()[tail];
            super.getData()[tail]=tmp;
            head++;
            tail--;
        }
        return super.getData();
    }
}