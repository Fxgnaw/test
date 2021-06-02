import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class test {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        System.out.println(Math.floor(Math.random()*5));

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        System.out.println("---------------------------------");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 15; i++) {
            pool.execute(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }));
        }
        pool.shutdown();
    }
}
