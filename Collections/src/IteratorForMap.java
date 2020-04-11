import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map无法直接使用Iterator，Map中存储的实际是Map.Entry,其封装了key和value
 * 因此Map相当于是单值存储，这就和Collection类似
 * 于是可以用一下方法实现Map集合的Iterator输出
 * 1.Map接口中entrySet()将Map转化为Set；
 * 2.Set接口中的iterator()将Set转为Iterator实例
 * 利用Iterator迭代输出获取每组Map.Entry对象
 */
public class IteratorForMap {
    public static void main(String[] args) {
        Map<String ,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        Set<Map.Entry<String, Integer>> set = map.entrySet();//1.
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();//2.
        while (iter.hasNext()){
            Map.Entry<String, Integer> me = iter.next();
            System.out.println(me.getKey()+"="+me.getValue());
        }


    }
}
