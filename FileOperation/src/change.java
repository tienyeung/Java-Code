import java.io.*;

public class change {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/apple/Downloads/FileOperation/src/hello.txt");//1.找到文件地址
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();//创建父目录
        }
        OutputStream output = new FileOutputStream(file);
        Writer out = new OutputStreamWriter(output);
        out.write("hello");
        out.close();


    }
}
