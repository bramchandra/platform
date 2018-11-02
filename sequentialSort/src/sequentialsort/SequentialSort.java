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
public class SequentialSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int[] a = {8, 2, 6, 1,0};
        int i, j, temp;

        System.out.println("Data sebelum Terurut");
        for (int x = 0; x < a.length; x++) {
            System.out.print(a[x] + " ");
        }
        System.out.println();

        System.out.println("Tahap pengurutan : ");
        for (i = 1; i < a.length; i++) {
            Thread.sleep(1000);
            for (j = i; j > 0 && a[j - 1] > a[j]; j--) {
                temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
            System.out.println("Hasil iterasi ke-" + i);
            for (int x = 0; x < a.length; x++) {
                System.out.print(a[x] + " ");
            }
            System.out.println();
        }
    }

}
