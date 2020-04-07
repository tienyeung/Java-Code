import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetMethods {
    public static void main(String[] args) {
        Class cls = Person.class;
        Method methods[] = cls.getMethods();
//        Method methods[] = cls.getDeclaredMethods();
        for(Method met : methods){
            int mod = met.getModifiers();//获取修饰符
            System.out.print(Modifier.toString(mod)+" ");
            System.out.print(met.getReturnType()+" ");//获取返回类型
            System.out.print(met.getName()+"(");
            Class<?> params[] = met.getParameterTypes();//获取参数
            for(int x = 0; x < params.length; x++){
                System.out.print(params[x].getName());
                if(x < params.length-1){
                    System.out.print(",");
                }
            }
            System.out.print(")"+" ");
            Class<?> exp[] = met.getExceptionTypes();
            if(exp.length>0){
                System.out.print("throws ");
            }else{
                System.out.println();
            }
            for(int x = 0; x < exp.length; x++){
                System.out.println(exp[x].getName());
                if(x<exp.length-1){
                    System.out.print(",");
                }
            }
        }
    }

}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
