public class practice2 {
    public static void main(String[] args) {
//        String email = "1067614540@qq.com";
//        if(Validator.isEmail(email)){
//            System.out.println("Yes!");
//        }else{
//            System.out.println("No!");
//        }
        String ip = "192.168.1.252";
        if(Validator.isIP(ip)){
            System.out.println("ip地址格式正确！");
        }else{
            System.out.println("ip地址格式错误！");
        }
    }
}
class Validator{
    private Validator(){};
    public static boolean isEmail(String email){
        if(email == null||"".equals(email)){
            return false;
        }
        String regex = "[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|net|com.cn|gov)";
        return email.matches(regex);
    }
    public static boolean isIP(String ip){
        if(ip == null||"".equals(ip)){
            return false;
        }
        String regex = "([12]?[0-9]?[0-9]\\.){3}([12]?[0-9]?[0-9])";
        if(ip.matches(regex)){
            String result[] = ip.split("\\.");
            for(int x = 0;x<result.length;x++){
                int temp = Integer.parseInt(result[x]);
                if(temp>255){
                    return false;
                }
            }
        }
        return true;

    }
}
