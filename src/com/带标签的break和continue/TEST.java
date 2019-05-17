package com.带标签的break和continue;
//outer是循环的标识而不是位置点的标识，与goto不能相提并论
import org.junit.jupiter.api.Test;

public class TEST {

    @Test
    public void test1() {
        OUTER://continue跳出标识的循环的本次循环
        for (int i = 0; i < 100; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue OUTER;
                }
            }
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        OUTER://指定是跳出的循环结构,而不是定位点
        for(int i=0;i<5;i++){
            for(int j=1;j<5;j++){
                for(int k=0;k<5;k++){
                    System.out.println("( "+i+" "+j+" "+k+" )");
                    if(i==j&&j==k){
                        break OUTER;
                    }
                }
            }
        }
    }
}
