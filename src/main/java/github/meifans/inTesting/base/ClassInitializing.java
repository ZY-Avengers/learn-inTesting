package github.meifans.inTesting.base;

/**
 * @author pengfei.zhao
 */
public class ClassInitializing {

    static ClassInitializing classInitializing = new ClassInitializing();
    static int a = 2;
    static int b = 0;

    static {
        System.out.println(ClassInitializing.a + " " + ClassInitializing.b);
    }

    public ClassInitializing() {
        a++;
        b++;
        System.out.println(ClassInitializing.a + " " + ClassInitializing.b);
    }

    public static void main(String[] args) {
        System.out.println(ClassInitializing.a + " " + ClassInitializing.b);
    }

}
