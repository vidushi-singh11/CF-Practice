import java.util.Scanner;
public class bitmasking {
    public static void print(int n){
        if(n == 0){
            return ;
        }
        int x = n%2;
        print(n/2);
        System.out.println(x);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int [] worker = new int[n];
        for(int i = 0;i<n;i++){
            int no_of_days = sc.nextInt();
            
            int mask = 0;
            for(int j = 0;j<no_of_days;j++){
                int day = sc.nextInt();
                
                mask = mask|(1<<day);
            }
            worker[i] = mask;
        }

        System.out.println("worker detail : \n");
        
        for(int i = 0;i<n;i++){
            System.out.println("work" + i + " works on " + worker +" :");
            print(worker[i]);
        }
    }
}