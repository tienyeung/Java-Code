import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import java.io.*;

public class Stream {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/apple/Downloads/FileOperation/src/hello.txt");//1.找到文件地址
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();//创建父目录
        }
        Reader in = new FileReader(file);
        char [] data = new char[1024];//开辟放置数据的字符数组
        int len = in.read(data);//将数据放置进数组，并返回其长度；
        System.out.println(new String(data,0,len));
        in.close();



    }
}
