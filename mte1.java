// BRUTE FORCE APPROACH , NO PREFIX SUM ARRAY , FOR EVERY L & R  SUM IS CALCULATED VIA LOOP 

// import java.util.*;
// public class mte1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n= sc.nextInt();
//         int arr[] = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int q=sc.nextInt();
//         while (q-->0) {
//             int l= sc.nextInt();
//             int r = sc.nextInt();
//             int sum = 0;
//             for(int i=l;i<=r;i++){
//                 sum=sum +arr[i];
//             }
//             System.out.println(sum);;
//         }
//         sc.close();
//     }
// }
//


// OPTIMIZED APPROACH - USING PREFIX SUM ARRAY ,
//P[0]- = ARR[0] AND P[R] = ARR[0] SE LEKAR ARR[R] TK KA SUM


// ****AND TO GET SUM(L,R)= P[R]-P[L-1]****//




import java.util.*;
public class mte1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
         int p[]= new int[n];
         p[0]=arr[0];
         for(int i=1;i<n;i++){
            p[i]=p[i-1]+arr[i];
         }
        int q=sc.nextInt();
        while (q-->0) {
            int l= sc.nextInt();
            int r = sc.nextInt();
           if (l==0) {
            System.out.println(p[r]);
           }
           else
            System.out.println(p[r]-p[l-1]);;
        }
        sc.close();
    }
}
