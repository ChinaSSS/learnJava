package 线程基础;
//进程中断
public class Demo3 {

    public static void main(String[] args) {
        MYRUNNABLE3 myrunnable3 = new MYRUNNABLE3();
        Thread thread = new Thread(myrunnable3);
        thread.start();
        for(int i=0;i<12;i++){
            System.out.println("main"+"=="+i);
            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==8) {
                thread.interrupt();//抛出异常给线程--> runnable
            }
        }
    }
}

class MYRUNNABLE3 implements Runnable{
//主线程中断后抛出了异常，此处接收异常
    @Override
    public void run() {
        for(int i=0;i<15;i++){
            System.out.println(Thread.currentThread().getName()+"=="+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();//接收异常，接收了下面才检测的到
            }
            if(Thread.interrupted()){
                break;//检测是否中断，退出
            }
        }
    }
}

