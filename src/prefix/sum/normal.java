/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefix.sum;

/**
 *
 * @author mohamed
 */
public class normal {
    int numbers[];
    normal(int []numbers){
        this.numbers = numbers;
    }
    public void getPrefixSum(){
        for(int i=1 ; i < this.numbers.length ; i++){
            this.numbers[i] = this.numbers[i-1] + this.numbers[i];
        }
    }
}
