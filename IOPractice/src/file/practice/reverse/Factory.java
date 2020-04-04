package file.practice.reverse;

import file.practice.restore.IFileService;

/**
 * 3、定义工厂类
 */

public class Factory {
    public static IStringService getInstance(){
        return new StringServiceImpl();
    }
}
