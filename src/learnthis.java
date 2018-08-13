public class learnthis {
    public static void main(String[] args) {
        Child child = new Child();
        child.show();
    }
}

class parent {
    public String  str;
    parent(){
        this(1);
    }
    parent(int i){
        this.str = "parent";
        this.show();
    }
    public void show() {
        System.out.println(this.str);
    }
}
class Child extends parent{
    public String str;
    Child(){}
    Child (int a){
        str = "Child";
    }
    public void show(){
        System.out.println(str);
        super.show();
    }
}