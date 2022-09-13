package study.Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1914_하노이탑_5 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        BigInteger bi = new BigInteger("2");

        bi=bi.pow(N);
        bi=bi.subtract(BigInteger.ONE);

        System.out.println(bi);

        if(N<=20){
            hanoi(1,3,2, N);
            System.out.print(sb.toString());
        }

    }

    static void hanoi(int st, int dst, int tmp, int n) {
        if(n <= 0) {
            return;
        }
        hanoi(st,tmp, dst,n-1);

        sb.append(st+" "+ dst +"\n");

        hanoi(tmp, dst,st,n-1);
    }
}
