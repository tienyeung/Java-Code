import java.io.*;

public class CopyUtil {
    public static void main(String[] args) throws Exception {
        if(args.length!=2){
            System.out.println("参数不足！");
            System.exit(1);
        }
        long start = System.currentTimeMillis();
        FileUtil fu = new FileUtil(args[0],args[1]);
        if(new File(args[0]).isFile()){//file copy
            System.out.println(fu.copy() ? "File Success!":"Fail!");
        }else{//directory copy
            System.out.println(fu.copyDir() ? "Dir Success!":"Fail!");
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time: "+ (end-start));

    }
}
class FileUtil{
    private File srcFile;
    private File desFile;

    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }
    public FileUtil(String src,String des){
        this(new File(src),new File(des));
    }
    public boolean copy() throws Exception {
        if (!this.srcFile.exists()) {
            System.out.println("File Not Found!");
            return false;
        }

        return this.copyFileImpl(this.srcFile, this.desFile);

    }
    public boolean copyDir() throws Exception{
        try{
            this.copyImpl(this.srcFile);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    private void copyImpl(File file) throws Exception{
        if(file.isDirectory()){
            File results[] = file.listFiles();
            if(results!=null){
                for(int x=0;x<results.length;x++){
                    copyImpl(results[x]);
                }
            }
        }else {
            System.out.println(file.getPath());
            String newFilePath = file.getPath().replace(this.srcFile.getPath()+File.separator,"");
            File newFile = new File(this.desFile,newFilePath);
            this.copyFileImpl(file,newFile);
        }

    }
    private boolean copyFileImpl(File srcFile,File desFile) throws Exception{
        if(!desFile.getParentFile().exists()){
            desFile.getParentFile().mkdirs();//创建父目录
        }
        byte[] data = new byte[1024];
        InputStream input = null;
        OutputStream output = null;
        try{
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            int len = input.read(data);
            output.write(data,0,len);
            //input.transferTo(output);JDK1.9
            return true;
        }catch (Exception e){
            throw e;
        }finally {
            if(input!=null){
                output.close();
            }
            if(output!=null){
                output.close();
            }
        }
    }
}
