public class DiyException {
    public static void main(String args[]){
        Food.eat(11);
    }
}

class BombException extends RuntimeException{
    public BombException(String str){
        super(str);
    }
}
class Food{
    public static void eat(int num) throws BombException{
        if(num>10){
            throw new BombException("Bomb!!!");
        }else{
            System.out.println("eat now");
        }
    }
}
