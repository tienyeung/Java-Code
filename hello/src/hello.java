import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.sound.midi.SysexMessage;

public class hello {
    public static void main(String [] args){
        Book book = new Book("JAVA",38);
        Book book1 = new Book("JSP",20);
        System.out.println(book.getInfo());
        System.out.println(book1.getInfo());
        System.out.println(Book.getSum());

    }
}
class Book{
    private int bid;
    private String  title;
    private int price;
    private static int count=0;
    public Book(){}
    public Book(String title,int price){
        this.bid=count+1;
        this.title = title;
        this.price = price;
        count++;
    }
    public String getInfo(){
        return "the"+this.bid+"book:"+"title: "+this.title+"price: "+this.price;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public String getTitle(){
        return this.title;
    }
    public int getPrice(){
        return this.price;
    }
    public static String getSum(){
        return "the sum of book is :"+count;
    }
}