package 线程基础;

import java.util.ArrayList;
import java.util.List;

//多线程共享数据
public class TongBu {
    public static void main(String[] args) {
        Run1 run1 = new Run1();
        Thread thread = new Thread(run1);
        Thread thread1 = new Thread(run1);
        thread.start();
        thread1.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//通过添加代码块进行同步
class Run1 implements Runnable{
    //共享的数据
    List<Integer> list = new ArrayList<>();
    //
    public Run1(){
        for(int i=0;i<10;i++){
            list.add(i);
        }
    }
    Object object = new Object();
    @Override
    public void run() {
        do {
            synchronized (object){
                System.out.println(list.size()+"--"+Thread.currentThread().getName());
                if(list.size()==0)break;
                list.remove(list.size()-1);
                try {
                    Thread.sleep(50); //sleep 阻塞线程但是不会丢失监听的权限 , 其他线程仍然无法获得cpu的时间片
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }while (list.size()>0);
    }
}
