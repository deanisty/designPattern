package design;
import design.singleton.Singleton1;
import design.singleton.Singleton2;
import design.singleton.Singleton3;

public class SingletonTest {
    
    public static void main(String[] args)
    {
        /*************** 饿汉模式 ****************/ 
        // Singleton1 s1 = Singleton1.getInstance();
        // s1.SayHi();

        /****************** 懒汉模式 **************/
        // Singleton2 s2 = Singleton2.getInstance();
        // s2.SayHi();

        // 多线程测试
        // for(int i = 1; i < 10; i ++) {
        //     new Thread(new Runnable() {

        //         @Override
        //         public void run() {
        //             Singleton2 s2 = Singleton2.getInstance();
        //             System.out.println(s2.toString());
        //         }
                
        //     }).start();
        // }

        /****************** 多线程安全模式 **************/
        for(int i = 1; i < 100 ; i ++) {
            new Thread(new Runnable(){

                @Override
                public void run() {
                    Singleton3 s3 = Singleton3.getInstance();
                    System.out.println(s3);
                }
            }).start();
        }

        // TODO 减小锁的粒度
    }
}

/**
 * ======windows=======
 * 编译: javac -encoding utf-8 -d .\classes\ .\design\SingletonTest.java
 * 运行: java -classpath .\classes\ design.SingletonTest
 */