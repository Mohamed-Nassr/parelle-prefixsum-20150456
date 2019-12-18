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
public class parallel implements Runnable {
    private int index;
    private int[] numbers;
    private final CountDownLatch endController;
    public parallel(CountDownLatch endController, int[] numbers, int index) {
        this.endController = endController;
        this.numbers = numbers;
        this.index = index;
    }
    @Override
    public void run() {
        this.numbers[this.index] = this.numbers[this.index] + this.numbers[this.index-1];
//        endController.countDown();
    }
    
}
