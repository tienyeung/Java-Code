package file.practice.number;

public class Factory {
    private Factory(){};
    public static INumberUtil getInstance(){
        return  new INumberUtilImpl() ;
    }
}
