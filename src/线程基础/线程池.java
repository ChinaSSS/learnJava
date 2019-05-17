package 线程基础;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class 线程池 {

    //创建线程池


    public void PoolTest(){
        //单一的线程池，一次只能存放一个线程，串行运行
        ExecutorService eServer = Executors.newSingleThreadExecutor();
        //往线程池中添加线程
        eServer.execute(new MyRunnable());
        eServer.execute(new MyRunnable());
        eServer.execute(new MyRunnable());
        //关闭线程池
        eServer.shutdown();
    }

    public void PoolTest2(){
        //设置固定容量的线程池
        ExecutorService eServer = Executors.newFixedThreadPool(3);
        eServer.execute(new MyRunnable());
        eServer.execute(new MyRunnable());
        eServer.execute(new MyRunnable());
        eServer.shutdown();
    }

    public void PoolTest3(){
        //大小没用限制可以缓存的Pool
        //缺点线程个数是不可控的
        ExecutorService eServer = Executors.newCachedThreadPool();
        eServer.execute(new MyRunnable());
        eServer.execute(new MyRunnable());
        eServer.execute(new MyRunnable());
        eServer.execute(new MyRunnable());
        eServer.execute(new MyRunnable());
        eServer.shutdown();
    }

    @Test
    public void PoolTest4(){
        //可以延时处理
        ScheduledExecutorService eServer = Executors.newScheduledThreadPool(5);
        eServer.schedule(new MyRunnable(),1, TimeUnit.MILLISECONDS);
        eServer.shutdown();
    }


    class MyRunnable implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<5;i++){
                System.out.println(i);
            }
            System.out.println(Thread.currentThread().getName()+" 结束");
        }
    }
}
