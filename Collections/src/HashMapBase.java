import java.util.HashMap;
import java.util.Map;

public class HashMapBase {
    public static void main(String[] args) {
        Map<String ,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("zero",null);
        map.put(null,0);
        System.out.println(map.get("one"));
        System.out.println(map.get(null));

    }
}
