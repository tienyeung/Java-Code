import java.io.*;

public class Print {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/apple/Downloads/FileOperation/src/hello.txt");
        PrintUtil pu = new PrintUtil(new FileOutputStream(file));
        //PrintWriter pw = new PrintWriter(new FileOutputStream(file));
        pu.println("name:Mike");
        pu.print(20);
        pu.close();

    }
}
class PrintUtil implements AutoCloseable{
    private OutputStream output;
    public PrintUtil(OutputStream output){//由外部决定输出的位置
        this.output = output;
    }
    public void print(String str){
        try {
            this.output.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String str){
        this.print(str+"\r\n");
    }
    public void print(long num){
        this.print(String.valueOf(num));
    }
    public void println(long num){
        this.println(String.valueOf(num));
    }

    @Override
    public void close() throws Exception {
        this.output.close();
    }
}
