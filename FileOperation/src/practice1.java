import java.io.File;

public class practice1 {
    public static void main(String[] args) {
        File file = new File("/Users/apple/Downloads/");
        listDirs(file);
    }
    public static void listDirs(File file){
        if(file.isDirectory()){
            File result[] = file.listFiles();
            for(int x = 0 ; x < result.length;x++){
                listDirs(result[x]);
            }
        }
        System.out.println(file);
    }}

