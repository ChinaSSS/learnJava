package 线程基础;

public class ThreadDemo {
    //线程的创建
    //同继承thread 或者实现runnable接口

    public static void main(String[] args) {
        Myrunnable1 myrunnable = new Myrunnable1();
        Thread thread = new Thread(myrunnable);
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println("main"+"=="+i);
            if(i==5){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class Myrunnable1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"=="+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
