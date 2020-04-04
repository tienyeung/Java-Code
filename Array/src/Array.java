public class Array {
    public static void main(String[] args) {
//        int[] date = new int[]{1, 2, 3};
        ArrayUtil util = new ArrayUtil(new int[]{1, 2, 3});
        System.out.println("Total: " + util.getSum() + " Average:" + util.getAvg());
        System.out.println("Max: " + util.getMax() + " Min:" + util.getMin());


    }
}



class ArrayUtil {
    private double avg;
    private int sum = 0;
    private int max;
    private int min;

    public ArrayUtil(int[] date) {
        this.max = date[0];
        this.min = date[0];
        for (int d : date) {
            this.sum += d;
            if (d > max) {
                this.max = d;
            }
            if (d < min) {
                this.min = d;
            }
        }
        this.avg = this.sum / date.length;


    }


    public int getSum() {
        return this.sum;
    }

    public double getAvg() {
        return this.avg;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

}

