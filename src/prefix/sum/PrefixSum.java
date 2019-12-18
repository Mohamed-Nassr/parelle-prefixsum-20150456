/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefix.sum;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author mohamed
 */
public class PrefixSum {

    static ThreadPoolExecutor executor;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int n = 5;
        int input[] = new int[]{5,5,21,3,5};
        int output[] = new int[n];
       
        int numofthreads = Runtime.getRuntime().availableProcessors();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numofthreads);
      
        int size = n/numofthreads ;
        int Prefixsum[] = new int[numofthreads];
        int startIndex=0, endIndex=size;
        
        CountDownLatch latch = new CountDownLatch(numofthreads);
        CountDownLatch latch2 = new CountDownLatch(numofthreads);
         
        double currentTime = 0d;
        Date start, end;
        start = new Date();
         
        for(int i = 0 ; i < numofthreads ; i++){
            running Task = new running(startIndex ,endIndex ,n,i,1,0,input,output,Prefixsum,latch);
            executor.execute(Task);
            startIndex=endIndex;
            if (i<numofthreads-1) endIndex=endIndex+size; 
            else  endIndex=n;
        }
        latch.await();
        for(int i = 1 ; i<numofthreads; i++)
            Prefixsum[i]+=Prefixsum[i-1];
        startIndex=size;
        endIndex=startIndex+size;
        for(int i = 0 ; i < numofthreads ; i++){
            running Task = new running(startIndex ,endIndex ,n,i,0,1,input,output,Prefixsum,latch2);
            executor.execute(Task);
            startIndex=endIndex;
            if (i<numofthreads-1) endIndex=endIndex+size; 
            else endIndex=n;              
        }
    
        end = new Date();
       
        currentTime = end.getTime() - start.getTime();
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(output));
        System.out.println("parallel Time: " + (currentTime)+ " seconds.");
        executor.shutdown();
        normal sum = new normal(input);
        sum.getPrefixSum();
        System.out.println(Arrays.toString(input));

    }
    
}
