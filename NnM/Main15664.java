package study.NnM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 실패 못 찾겡므~~ 11
public class Main15664 {
    static int N, M;
    static int[] arr, sel;
    static boolean[] visited;
    static LinkedHashSet<String> set;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        sel = new int[M];
        visited = new boolean[N+1];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        permute(0, 0,"");

        for (String s : set){
            sb.append(s + "\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static void permute(int cnt, int depth, String str) {
        if (cnt == M) {
            for (int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            set.add(str);
            return;
        }
        for (int i = depth; i < N; i++) {
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            sel[cnt] = arr[i];
            permute(cnt + 1, depth + 1,str + arr[i] + " ");
            visited[i] = false;

        }
    }

}
