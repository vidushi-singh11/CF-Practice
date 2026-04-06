import java.io.*;
import java.util.*;

public class hwi1 {
    static int n;
    static long[] seg, lazy;
    static long mod = 1000000007;

    static void build(long[] a, int node, int l, int r){
        if(l==r){
            seg[node]=a[l]%mod;
            return;
        }
        int m=(l+r)>>1;
        build(a,node<<1,l,m);
        build(a,node<<1|1,m+1,r);
        seg[node]=(seg[node<<1]+seg[node<<1|1])%mod;
    }

    static void push(int node,int l,int r){
        if(lazy[node]!=1){
            seg[node]=(seg[node]*lazy[node])%mod;
            if(l!=r){
                lazy[node<<1]=(lazy[node<<1]*lazy[node])%mod;
                lazy[node<<1|1]=(lazy[node<<1|1]*lazy[node])%mod;
            }
            lazy[node]=1;
        }
    }

    static void update(int node,int l,int r,int ql,int qr,long val){
        push(node,l,r);
        if(r<ql||l>qr) return;
        if(ql<=l&&r<=qr){
            lazy[node]=val;
            push(node,l,r);
            return;
        }
        int m=(l+r)>>1;
        update(node<<1,l,m,ql,qr,val);
        update(node<<1|1,m+1,r,ql,qr,val);
        seg[node]=(seg[node<<1]+seg[node<<1|1])%mod;
    }

    static long query(int node,int l,int r,int ql,int qr){
        push(node,l,r);
        if(r<ql||l>qr) return 0;
        if(ql<=l&&r<=qr) return seg[node];
        int m=(l+r)>>1;
        return (query(node<<1,l,m,ql,qr)+query(node<<1|1,m+1,r,ql,qr))%mod;
    }

    static class FastScanner{
        private final InputStream in=System.in;
        private final byte[] buffer=new byte[1<<16];
        private int ptr=0,len=0;
        private int read() throws IOException{
            if(ptr>=len){
                len=in.read(buffer);
                ptr=0;
                if(len<=0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException{
            int c,s=1,x=0;
            while((c=read())<=32);
            if(c=='-'){s=-1;c=read();}
            while(c>32){
                x=x*10+c-'0';
                c=read();
            }
            return x*s;
        }
    }

    public static void main(String[] args) throws Exception{
        FastScanner fs=new FastScanner();
        int n=fs.nextInt();
        long[] a=new long[n];
        for(int i=0;i<n;i++) a[i]=fs.nextInt();

        seg=new long[4*n];
        lazy=new long[4*n];
        Arrays.fill(lazy,1);

        build(a,1,0,n-1);

        int q=fs.nextInt();
        long ans=0;

        while(q-->0){
            int t=fs.nextInt();
            int l=fs.nextInt();
            int r=fs.nextInt();

            if(t==1){
                long base=a[l];
                update(1,0,n-1,l,r,base);
            }else{
                ans=(ans+query(1,0,n-1,l,r))%mod;
            }
        }

        System.out.print(ans);
    }
}