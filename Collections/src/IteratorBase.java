import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorBase {
    public static void main(String[] args) {
        Set<String > all = new HashSet<>();
        all.add("hello");
        all.add("word");
        Iterator<String> iter = all.iterator();//实例化输出对象
        while(iter.hasNext()){
            String str = iter.next();
            System.out.println(str);
        }
    }
}
