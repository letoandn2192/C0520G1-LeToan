package access_modifier_static.practical;

public class AccessModifier {
    public static void main(String[] args) {
        B obj = new B();
        obj.mess();
        System.out.println(obj.a);
    }
}
///////////////////////Private/////////////////////////////
class A{
    private int a = 5;
    private void mess(){
        System.out.println("Hello");
    }
}
//////////////////////Default/////////////////////////////
class B{
    int a = 5;
    void mess(){
        System.out.println("Hello");
    }
}