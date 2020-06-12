package design;
import design.singleton.Singleton1;
import design.singleton.Singleton2;
import design.singleton.Singleton3;
import design.singleton.Singleton4;
import design.singleton.Singleton5;

public class SingletonTest {
    
    public static void main(String[] args)
    {
        /*************** 饿汉模式 ****************/ 
        // Singleton1 s1 = Singleton1.getInstance();
        // s1.SayHi();

        /****************** 懒汉模式 **************/
        // Singleton2 s2 = Singleton2.getInstance();
        // s2.SayHi();
        
        /****************** 多线程测试 **************/
        // for(int i = 1; i < 10; i ++) {
        //     new Thread(new Runnable() {

        //         @Override
        //         public void run() {
        //             Singleton2 s2 = Singleton2.getInstance();
        //             System.out.println(Thread.currentThread().getId() + " " + s2);
        //         }
        //      
        //     }).start();
        // }

        /****************** 多线程安全 - 方法锁 **************/
//         for(int i = 1; i < 10 ; i ++) {
//             new Thread(new Runnable(){
// 
//                 @Override
//                 public void run() {
//                     Singleton3 s3 = Singleton3.getInstance();
//                     System.out.println(s3);
//                 }
//             }).start();
//         }

        /****************** 多线程安全 - 代码块锁 **************/
        for(int i = 1; i < 10; i++ ) {
            new Thread(new Runnable() {

                public void run() {
                    Singleton5 s5 = Singleton5.getInstance();
                    System.out.println(s5);
                }
            }).start();
        }

    }
}

/**
 * ======windows=======
 * 编译: javac -encoding utf-8 -d .\classes\ .\design\SingletonTest.java
 * 运行: java -classpath .\classes\ design.SingletonTest
 *
 * ======linux/mac=======
 * 编译: javac -d ./classes design/SingletonTest.java
 * 运行: java -classpath classes  design.SingletonTest
 */
