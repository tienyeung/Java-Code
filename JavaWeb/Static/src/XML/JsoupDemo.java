package XML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

public class JsoupDemo {
    public static void main(String[] args) throws Exception {
        //从xml获取document
        //获取路径，通过类加载器获取资源
        String path = JsoupDemo.class.getClassLoader().getResource("XML/student.xml").getPath();
        System.out.println(path);
        //加载文档进内存
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取元素对象
        Elements elements = document.getElementsByTag("name");
//        System.out.println(elements.size());
        for(Element ele:elements){
            String text = ele.text();
            System.out.println(text);}

    }
}
