public class practice2 {
    public static void main(String args[]) {
        StringCount sc = new StringCount("want you to know one thing");
        System.out.println(sc.getInfo());
    }
}
class StringUtil{
    private String content;
    public StringUtil(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public String getInfo(){
        return this.getContent();
    }
}

class StringCount extends StringUtil{
    private int nCount;
    private int oCount;
    public StringCount(String content){
        super(content);
        this.getCount(content);
    }
    public void getCount(String str){
        char[] data = str.toCharArray();
        int [] countData = new int[2];
        for(int x=0;x<data.length;x++){
            if(data[x]=='n'||data[x]=='N'){
                this.nCount++;
            }
            if(data[x]=='o'||data[x]=='O'){
                this.oCount++;
            }
        }
    }
    public int getNCount(){
        return this.nCount;
    }
    public int getOCount(){
        return this.oCount;
    }
    public String getInfo(){
        return "N的个数："+this.nCount+"、O的个数："+this.oCount;
    }
}
