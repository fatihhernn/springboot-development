class Bound<T extends A> {
    private T object;

    public Bound(T object) {
        this.object = object;
    }
    public void doRunTest(){
        this.object.displayClass();
    }
}
interface A{
    public void displayClass();
}
class B implements A {
    @Override
    public void displayClass() {
        System.out.println("Inside super class B");
    }
}
class C implements A {
    @Override
    public void displayClass() {
        System.out.println("Inside super class C");
    }
}
public class BoundedClass{
    public static void main(String[] args) {
        Bound<C> bec=new Bound(new C());
        bec.doRunTest();

        Bound<B> beb=new Bound(new B());
        beb.doRunTest();



    }
}
