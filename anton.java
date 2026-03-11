import java.util.*;
public class anton {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        String s = sc.next();
        int a=0;
        int d=0;
        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            if (c=='A') {
                a++;
            }
            if (c=='D') {
                d++;
            }
        }
        if (a>d) {
            System.out.println("Anton");
        }
        else if(a<d){
            System.out.println("Danik");
        }
        else
            System.out.println("Friendship");
        sc.close();
    }
    
}
