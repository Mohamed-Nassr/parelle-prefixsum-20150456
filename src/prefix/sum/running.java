/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefix.sum;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author mohamed
 */
public class running implements Runnable{
    int inner;
    int outer;
    int input[] ;
    int output[] ;
    int Prefixsum[];
    int startIndex ,endIndex;
    int n,i;
    CountDownLatch latch;
    
    
   public running(int startIndex,int endIndex, int n,int i ,int inner,int outer,int input[] ,int output[] ,int Prefixsum[],CountDownLatch latch ){
        this.inner = inner;
        this.input = input;
        this.outer=outer;
        this.output = output;
        this.Prefixsum = Prefixsum;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.n = n;
        this.i = i; 
        this.latch = latch;
       
   }
    @Override
    public void run() {
        if (inner == 1)  temp();
        else sum();
    }
    
    public void temp(){
        output[startIndex]=input[startIndex];
        for(int j = startIndex+1 ; j < endIndex ; j++)
           output[j]=output[j-1]+input[j];
        Prefixsum[i]+=output[endIndex-1];
        latch.countDown();
    }

    public void sum(){
        for(int j = startIndex ; j < endIndex ; j++)
            output[j]+=Prefixsum[i];
    }      
}
