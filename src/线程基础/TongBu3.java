package 线程基础;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

//通过设置锁，达到线程同步的效果
public class TongBu3 {
    public static void main(String[] args) {
        Run3 run3 = new Run3();
        Thread thread = new Thread(run3);
        Thread thread1 = new Thread(run3);
        thread.start();
        thread1.start();
    }
}

 class Run3 implements Runnable {

        //create data
        private List<Integer> list = new ArrayList<>();
        //create clock
        private ReentrantLock lock;

        public Run3() {
            lock = new ReentrantLock();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
        }

        @Override
        public void run() {
            while (list.size() > 0) {
                lock.lock();
                System.out.println(list.size() + "--" + Thread.currentThread().getName());
                if(list.size()!=0) {
                    list.remove(list.size() - 1);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }

