import java.util.*;
public class  fastexponentiation {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        int a =sc.nextInt();
        int n= sc.nextInt();
        long ans = power(a,n);
        System.out.println(ans);
    }
    public static long power(int a , int n){
        if(n==0){
            return 1;
        }

        if(n%2==0){
            long temp = power(a ,n/2);
            return temp*temp;
        }
        else{
            return a*power(a,n-1);
        }
    }
}
