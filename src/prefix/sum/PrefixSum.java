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
public class PrefixSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] numbers = new int[]{0,5,5,21,3,5};
        System.out.println(numbers.length);
        int[] prefixSum;
        normal sum = new normal(numbers);
        prefixSum = sum.getPrefixSum();
        System.out.println(prefixSum.length);

        for(int i= 0; i<prefixSum.length;i++){
            System.out.print(prefixSum[i]);
        }
    }
    
}
