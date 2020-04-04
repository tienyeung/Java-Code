public class enums {
    public static void main(String args[]){
//        Color a = Color.BLUE;
//        for(Color c:Color.values()){
//            System.out.println(c.ordinal()+"-"+c.name());
//
//        }
        IMessages msg = Color.BLUE;
        System.out.println(msg.getMessage());

    }
}
interface IMessages{
    public String getMessage();
}
enum Color implements IMessages{
    RED("红色"),GREEN("绿色"),BLUE("蓝色");
    private String title;
    private Color(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }
    public String getMessage(){
        return this.title;
    }
}
