public class prishi2 {
    
    static int a = 100;
    static {
        System.out.println("inside static sample");
    }
}

class demo {
        static {
            System.out.println("inside static demo");
        }
    public static void main(String[] args) {
        System.out.println("inside main");
        System.out.println(prishi2.a);
    }
}
