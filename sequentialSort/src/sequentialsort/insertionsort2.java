/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequentialsort;

/**
 *
 * @author danielbram
 */
public class insertionsort2 {

    public static void main(String[] args) {
        int[] A = {8, 6, 1, 2, 0};

        System.out.println("Data sebelum pengurutan");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        System.out.println("Tahap Pengurutan : ");
        for (int i = 1; i <= A.length - 1; i++) {
            int element = A[i];
            int j = i;
            while (j > 0 && (A[j - 1] > element)) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = element; 
            
            System.out.println("Tahap iterasi " + i);
            for (int k = 0; k < A.length; k++) {
                System.out.print(A[k] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Data setelah pengurutan");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

}
