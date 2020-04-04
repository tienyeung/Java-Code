package file.practice.restore;

import java.io.File;

public class JavaDemo2 {

    static {
        File file = new File(IFileService.SAVE_DIR);
        if(!file.exists()){
            file.mkdir();
        }
    }
    public static void main(String[] args) throws Exception {
        IFileService ifs = factory.getInstance();
        if(ifs.save()){
            System.out.println("创建成功！");
        }else{
            System.err.println("创建失败！");
        }
    }
}
