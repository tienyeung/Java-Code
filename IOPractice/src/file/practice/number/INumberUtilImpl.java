package file.practice.number;

public class INumberUtilImpl implements INumberUtil {
    @Override
    public int[] stat(int count) {
        int result[] = new int[2];
        int data[] = new int[count];
        for(int x = 0 ; x < data.length;x++){
            data[x] = InputUtil.getInt("请输入第"+ (x+1) +"个数字：");
        }
        result[0] = data[0];//max
        result[1] = data[0];//min
        for(int x = 0 ; x < data.length;x++){
            if(data[x]>result[0]){
                result[0] = data[x];
            }
            if(data[x]<result[0]){
                result[1] = data[x];
            }
        }
        return result;
    }
}

