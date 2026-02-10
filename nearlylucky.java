import java.util.*;
public class nearlylucky     {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m=0;
        int count=0;
        while(n!=0){
            
            m=(n%10);
            if(m==4 || m==7){
                count++;
            }
            n=n/10;
        }
        if (count==4 || count==7){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        sc.close();
    }
}
