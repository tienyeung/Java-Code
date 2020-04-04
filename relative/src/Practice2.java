public class Practice2 {
    public static void main(String [] args){
        String str = "2020";
        System.out.println(isNumber(str)?"数字":"不是数字");


    }
    public static boolean isNumber(String str){
        char[] result = str.toCharArray();
        for(int x = 0;x<result.length;x++){
            if(result[x] < '0' || result[x] > '9'){
                return false;
            }
        }
        return true;
    }

}
