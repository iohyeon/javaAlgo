package study.Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1914_하노이탑_4 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = 0;

        move(N, 1, 3);
        System.out.println(M);
        System.out.println(sb);
    }
    // no 개의 원반을 x번 기둥에서 y번 기둥
    private static void move(int N, int start, int temp) {
        if(N > 1) {
            M++;
            move(N - 1, start, 6 - start - temp);
        }
//        if(N == 0) return;
//        M++;
//        move(N - 1, start, dest, temp);
        if(N > 1) {
            move(N - 1, 6 - start - temp, temp);
        }
        sb.append(start + " " + temp + "\n");

    }
}
