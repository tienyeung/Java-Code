package file.practice.restore;

public class factory {
    private factory(){};
    public static IFileService getInstance(){
        return new FileServiceImpl();
    }
}
