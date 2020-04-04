import com.sun.javafx.runtime.async.BackgroundExecutor;

public class Factory {
    public static void main(String args[]){
        IFood food = Factory1.getInstance("bread");
        food.eat();
    }
}
interface IFood{
    public void eat();
}
class Factory1{
    public static IFood getInstance(String className){
        if("bread".equals(className)){
            return new Bread();
        }else if("milk".equals(className)){
            return new Milk();
        }else{
            return null;
        }
    }
}
class Bread implements IFood{
    public void eat(){
        System.out.println("BREAD...");
    }
}
class Milk implements IFood{
    public void eat(){
        System.out.println("MILK...");
    }
}