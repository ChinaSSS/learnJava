package 线程基础;

public class Demo2 {
    //创建的方法
    //1 通过thread
    //2 通过实现runnable接口

    public static void main(String[] args) {
        myThread mythread = new myThread();
        mythread.start();

        myRunnable2 myrunnable = new myRunnable2();
        Thread thread = new Thread(myrunnable);
        thread.start();
    }
}

class myThread extends Thread{

    @Override
    public void run() {
        super.run();
        for(int i=0;i<15;i++){
            System.out.println(Thread.currentThread().getName()+"=="+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class myRunnable2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<15;i++){
            System.out.println(Thread.currentThread().getName()+"=="+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}