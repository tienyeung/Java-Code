public class Define {
    public static void main(String args[]){
        Point<Integer> point1 = new Point<Integer>();
        Point<String> point2 = new Point<>();
        point1.setX(10);
        point2.setY("20");
        System.out.println(point1.getX());
        System.out.println(point2.getY());
    }
}

class Point <T>{
    private T x;
    private T y;
    public void setX(T x){
        this.x = x;
    }
    public void setY(T y){
        this.y = y;
    }
    public T getX(){
        return this.x;
    }
    public T getY(){
        return this.y;
    }

}

