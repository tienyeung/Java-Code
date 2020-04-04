public class base {
    public static void main(String[] args) throws CloneNotSupportedException {
        Member memberA = new Member("Jack");
        Member memberB = (Member) memberA.clone();//
        System.out.println(memberA);
        System.out.println(memberB);

    }
}
class Member implements Cloneable{
    private String name;
    public Member(String name){
        this.name = name ;

    }

    @Override
    public String toString() {
        return super.toString() +
                " name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
