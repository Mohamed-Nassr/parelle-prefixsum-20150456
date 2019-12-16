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
    public int[] getPrefixSum(){
        int[] prefix = new int[this.numbers.length];
        prefix[0] = this.numbers[0];
        for(int i=1 ; i < this.numbers.length ; i++){
            prefix[i] = prefix[i-1] + this.numbers[i];
        }
        return prefix;
    }
}
