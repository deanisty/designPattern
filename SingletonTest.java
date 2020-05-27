package design;
import design.singleton.Singleton1;
import design.singleton.Singleton2;

public class SingletonTest {
    
    public static void main(String[] args)
    {
        // 饿汉模式
        // Singleton1 s1 = Singleton1.getInstance();
        // s1.SayHi();

        // 懒汉模式
        // Singleton2 s2 = Singleton2.getInstance();
        // s2.SayHi();

        // 多线程测试
        for(int i = 1; i < 10; i ++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Singleton2 s2 = Singleton2.getInstance();
                    System.out.println(s2.toString());
                }
                
            }).start();
        }

    }
}

// javac -encoding utf-8 -d .\classes\ .\design\SingletonTest.java
// java -classpath .\classes\ design.SingletonTest