package cn.pracitce.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 当属性较多时，setter及getter的重复设置将带来大量工作；
 * 考虑利用反射机制简化工作
 */
public class SetDemo {
    public static void main(String[] args) {
        String value = "name:Mike|job:Teacher|empno:9527|salary:666.66|date:2020-02-02";
        Emp emp = ClassInstanceFactory.create(Emp.class,value);
        System.out.println(emp);
    }
}
class Emp{
    private String name;
    private String job;
    private Long empno;
    private Double salary;
    private Date date;
    public Emp(){};
    public Emp(String name, String job, Long empno, Double salary, Date date) {
        this.name = name;
        this.job = job;
        this.empno = empno;
        this.salary = salary;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Emp(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", empno=" + empno +
                ", salary=" + salary +
                ", date=" + date +
                '}';
    }
}
class ClassInstanceFactory{
    private ClassInstanceFactory(){}

    /**
     *实例化对象的创建
     * @param clazz 需要利用反射进行实例化的Class类对象
     * @param value 属性的值
     * @param <T>
     * @return 一个配置好属性的java类对象
     */
    public static <T> T create(Class<?> clazz,String value){
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtil.setValue(obj,value);
            return (T) obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
class BeanUtil{
    private BeanUtil(){};

    /**
     * 实现指定对象的属性设置==setter
     * @param obj 反射操作的实例化对象
     * @param value 传入值（属性:内容|属性：内容）
     */
    public static void setValue(Object obj,String value) {
        String results[] = value.split("\\|");
        for(int x = 0; x < results.length; x ++){
            String attval[] = results[x].split("\\:");//拆分属性和内容
            try {
                Field field = obj.getClass().getDeclaredField(attval[0]);//获取实例化对象的某属性
                Method setMethod = obj.getClass().getDeclaredMethod("set"+StringUtil.initCap(attval[0]),
                        field.getType());//获取实例化对象的某方法（方法名，参数类型）
                Object val = BeanUtil.convertAttributeValue(field.getType().getName(),attval[1]);
                setMethod.invoke(obj,val);//调用obj的此方法，并且进行赋值
            } catch (Exception e) {

            }

        }
    }

    /**
     * 属性类型的转换
     * @param type 属性的类型
     * @param value 将字符串转换为指定类型
     * @return invoke需要的Object
     */
    private static Object convertAttributeValue(String type,String value){
        if("long".equals(type)||"java.lang.Long".equals(type)){
            return Long.parseLong(value);
        }else if("int".equals(type)||"java.lang.int".equals(type)){
            return Integer.parseInt(value);
        }else if("double".equals(type)||"java.lang.double".equals(type)){
            return Double.parseDouble(value);
        }else if("java.util.Date".equals(type)){
            SimpleDateFormat sdf = null;
            if(value.matches("\\d{4}-\\d{2}-\\d{2}")){
                sdf = new SimpleDateFormat("YYYY-MM-dd");
            }else if(value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            }else {
                return new Date();//当前时间
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();
            }

        }
        return value;
    }

}
class StringUtil{
    //首字母大写
    public static String initCap(String str){
        if(str==null||"".equals(str)){
            return str;
        }
        if(str.length()==1){
            return str.toUpperCase();
        }else {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
    }
}
