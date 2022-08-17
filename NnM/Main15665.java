package study.NnM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

// 12
public class Main15665 {
    static int N, M;
    static int[] arr, sel;
    static LinkedHashSet<String> set;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        sel = new int[M];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        permute(0, "");

        for (String s : set){
            sb.append(s + "\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static void permute(int cnt,  String str) {
        if (cnt == M) {
            set.add(str);
            return;
        }
        for (int i = 1; i < N; i++) {
            permute(cnt + 1,str + arr[i] + " ");

        }
    }

}
