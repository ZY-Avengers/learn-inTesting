package github.meifans.inTesting.base;

/**
 * Created by siyu on 2017/4/25.
 */
public class SingletonTest {

  static class SingletonByStaticInitialization {

    private static final SingletonByStaticInitialization INSTANCE = new SingletonByStaticInitialization();

    private SingletonByStaticInitialization() {
    }

    public static SingletonByStaticInitialization getInstance() {
      return INSTANCE;
    }

    public void show() {
      System.out.println("Singleton used static initialization in Java");
    }
  }

  enum SingletonByEnum {
    INSTANCE;

    public void show() {
      System.out.println("Singleton used Enum in Java");
    }
  }

  static class SingletonBySynchronized {

    private static SingletonBySynchronized INSTANCE = null;

    private SingletonBySynchronized() {
    }

    public static SingletonBySynchronized getINSTANCE() {
      if (INSTANCE == null) {
        synchronized (SingletonBySynchronized.class) {
          if (INSTANCE == null) {
            INSTANCE = new SingletonBySynchronized();
          }
        }
      }
      return INSTANCE;
    }

    public void show() {
      System.out.println("Singleton used Synchronized in Java");
    }
  }

  public static void main(String[] args) {
    SingletonByEnum.INSTANCE.show();
    SingletonBySynchronized.getINSTANCE().show();
    SingletonByStaticInitialization.getInstance().show();
  }
}
