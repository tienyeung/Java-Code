import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class base {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/apple/Downloads/FileOperation/src/hello.txt");
//        if(file.exists()){
//            file.delete();
//        }else {
//            System.out.println(file.createNewFile());
//        }
        long len = file.length();
        System.out.println("文件大小："+MathUtil.round(len,2));
        System.out.println("文件最后修改时间："+new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));

    }

}
class MathUtil{
    private MathUtil(){};
    public static double round(double num,int scale){
        return Math.round(Math.pow(10,scale))/Math.pow(10,scale);
    }
}
