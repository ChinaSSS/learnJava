package 线程基础;

import java.util.ArrayList;
import java.util.List;

//通过同步方法，达到同步的效果
public class TongBu2 {
    public static void main(String[] args) {
        Run2 run2 = new Run2();
        Thread thread = new Thread(run2);
        Thread thread1 = new Thread(run2);
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Run2 implements Runnable{

    public List<Integer> list = new ArrayList<>();

    public Run2(){
        for(int i=0;i<10;i++){
            list.add(i);
        }
    }

    @Override
    public synchronized void run() {
        while(list.size()>0) {
            //添加关键字synchronized变成同步方法-->
            System.out.println(list.size() + "==" + Thread.currentThread().getName());
            list.remove(list.size()-1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
}