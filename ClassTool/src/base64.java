import java.util.Base64;

public class base64 {
    public static void main(String[] args) {
        String str = StringUtil.encode("xiaomi");
        System.out.println(str);
        System.out.println(StringUtil.decode(str));
    }
}
class StringUtil{
    private static final String SALT ="helloworld";//盐值
    private static final int REPEAT = 3;//重复加密3次

    public static String encode(String str){
        String temp = str+"{"+SALT+"}";
        byte [] data = temp.getBytes();//将字符串转为字符数组
        for(int x = 0;x<REPEAT;x++){
            data = Base64.getEncoder().encode(data);
        }
        return new String(data);
    }
    public static String decode(String str){
        byte data[] = str.getBytes();
        for(int x = 0;x<REPEAT;x++){
            data = Base64.getDecoder().decode(data);
        }
        return new String(data).replaceAll("\\{\\w+\\}"," ");
    }
}
