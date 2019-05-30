package 线程基础.yield_;

//yield方法yield()让当前正在运行的线程回到可运行状态，以允许具有相同优先级的其他线程获得运行的机会。
// 因此，使用yield()的目的是让具有相同优先级的线程之间能够适当的轮换执行。
// 但是，实际中无法保证yield()达到让步的目的，因为，让步的线程可能被线程调度程序再次选中。

public class Demo {

    public static void main(String[] args) {
        Myrun myrun = new Myrun();
        Thread thread = new Thread(myrun);
        Myrun myrun1 = new Myrun();
        Thread thread1 = new Thread(myrun1);
        thread.start();
        thread1.start();

    }

}

class Myrun implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            if(Thread.currentThread().getName().equals("Thread-0")){
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+"=="+i);
        }
    }
}