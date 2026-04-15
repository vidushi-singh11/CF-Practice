// BRUTE - FORCE APPROACH , NO PREFIX SUM ARRAY , FOR EVERY I LEFT AND RIGHT SUM IS CALCULATED VIA LOOP

// public class mte2 {
//     public static void main(String[] args) {

//         int[] arr = {1, 3, 5, 2, 2};
//         int n = arr.length;

//         boolean found = false;

//         for (int i = 0; i < n; i++) {

//             int left = 0;
//             int right = 0;

//             // Left sum: 0 to i-1
//             for (int j = 0; j < i; j++) {
//                 left = left + arr[j];
//             }

//            // Right sum: i+1 to n-1
//             for (int j = i + 1; j < n; j++) {
//                 right = right + arr[j];
//             }

//             // Check
//             if (left == right) {
//                 System.out.println("Equilibrium Index = " + i);
//                 found = true;
//                 break;
//             }
//         }

//         if (found == false) {
//             System.out.println(-1);
//         }
//     }
// }



// OPTIMIZED APPROACH - USING PREFIX SUM ARRAY ,
// P[0] = ARR[0] AND P[R] = ARR[0] SE LEKAR ARR[R] TK KA SUM
// ****AND TO GET LEFT SUM(L) = P[L-1] AND RIGHT SUM(R) = P[N-1]-P[R]****//

import java.util.Scanner;

public class mte2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        // Prefix sum array
        int[] prefix = new int[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // Find equilibrium index
        boolean found = false;

        for (int i = 0; i < n; i++) {

            int left;
            int right;

            // Left sum
            if (i == 0) {
                left = 0;
            } else {
                left = prefix[i - 1];
            }

            // Right sum
            right = prefix[n - 1] - prefix[i];

            // Check
            if (left == right) {
                System.out.println("Equilibrium Index = " + i);
                found = true;
                break;
            }
        }

        // If no equilibrium index found
        if (found == false) {
            System.out.println(-1);
        }
    }
}