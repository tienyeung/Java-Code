package file.practice.sort;

import java.io.*;
import java.util.Scanner;

//文件的内容追加和读取
public class FileUtil {
    public static String load(File file){
        Scanner scan = null;
        try{
            scan = new Scanner(file);
            if(scan.hasNext()){
                String str = scan.next();
                return str;
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }finally {
            if(scan != null){
                scan.close();
            }
        }
    }
    public static boolean append(File file ,String content){
        PrintStream out = null;
        try{
            out = new PrintStream(new FileOutputStream(file,true));
            out.print(content);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }finally {
            if(out!=null){
                out.close();
            }
        }
    }
}
