package file.practice.sort;

public class Factory1 {
    private Factory1(){};
    public static IStudentService getInstance(){
        return new StudentServiceImpl();
    }
}
