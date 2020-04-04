package file.practice.restore;

import java.io.File;
import java.io.FileNotFoundException;

public interface IFileService {
    static final String SAVE_DIR = "/Users/apple/Downloads/IOPractice/src/test"+ File.separator;
    public boolean save() throws FileNotFoundException, Exception;
}
