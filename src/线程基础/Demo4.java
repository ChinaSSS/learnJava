package 线程基础;
//自定义中断标记
public class Demo4 {

    public static void main(String[] args) {
        Myrunnable4 myrunnable4 = new Myrunnable4();
        Thread thread = new Thread(myrunnable4);
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println("the main_"+i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==5){
                //自定义标记中断线程
                myrunnable4.setFlag(false);
            }
        }
    }
}

class Myrunnable4 implements  Runnable{

    private boolean flag;

    public Myrunnable4(){
        this.flag = true;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            OUT:
            while(flag){
                System.out.println(Thread.currentThread().getName()+"=="+i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break OUT;
            }
        }
    }
}