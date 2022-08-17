package study.NnM;

import java.io.*;
import java.util.StringTokenizer;

// 순열기본
public class Main15649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] output = new int[M];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++){
            arr[i] = i+1;
        }

        permute(arr, visited, output, 0, arr.length, M);

    }

    private static void permute(int[] arr, boolean[] visited, int[] output, int depth, int length, int cnt) {
        // 종료조건
        if (depth == cnt ){
            print(output, cnt);
            return;
        }

        // 방문한지 안한지 체크 재귀
        for (int i = 0; i < length; i++){
            if (!visited[i] ){
                visited[i] = true;
                output[depth] = arr[i];

                permute(arr, visited, output, depth, length, cnt);
                visited[i] = false;
            }
        }
    }

    private static void print(int[] arr, int cnt) {
        for (int i = 0; i < cnt; i++){
            System.out.println(arr[i] + " ");
        }

    }
}
