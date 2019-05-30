package 线程基础.线程优先级;


//优先级高的抢到cpu时间片的概率大


public class Demo {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.setPriority(Thread.MAX_PRIORITY);
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"=="+i);
            if(i==0){
                myThread.start();
            }
        }

    }

}

class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        setName("子线程");
        for(int i=0;i<100;i++){
            System.out.println(getName()+"=="+i);
        }
    }
}
