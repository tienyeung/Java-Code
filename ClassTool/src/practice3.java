import java.util.Random;

public class practice3 {
    public static void main(String[] args) {
        int num = 100000000;
        Coin coin = new Coin(num);
        System.out.println("正面次数："+coin.getFront());
    }
}
class Coin{
    private int front;
    private int back;
    private Random random = new Random();
    public Coin(int num){
        this.throwCoins(num);
    }
    public void throwCoins(int num){
        for(int x = 0; x < num;x++){
            int temp = random.nextInt(2);
            if(temp==0){
                this.front++;
            }else{
                this.back++;
            }
        }
    }
    public int getFront(){
        return this.front;
    }

    public int getBack() {
        return back;
    }
}
