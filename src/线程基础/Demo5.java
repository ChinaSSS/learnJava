package 线程基础;
//用户线程和守护线程
//当没有用户线程时虚拟机退出
//应用场景，退出程序后中断下载
public class Demo5 {
    public static void main(String[] args) {
        Myrunnable5 myrunnable5 = new Myrunnable5();
        Thread thread = new Thread(myrunnable5);
        //设置守护线程
        thread.setDaemon(true);
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println("main"+"=="+i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Myrunnable5 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"=="+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
