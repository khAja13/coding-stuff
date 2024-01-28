class A {
    int x = 69;
}

class B {
    float y = 69.69f;
}

class C {
    char c = 'p';
}

public class prishi {
    public static void main(String[] args) {
        System.out.println("Start");

        A a = new A();
        System.out.println(a.x);

        B b = new B();
        System.out.println(b.y);

        C c = new C();
        System.out.println(c.c);

        System.out.println("Stop");
    }
}