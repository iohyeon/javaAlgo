package study.NnM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합기본
public class Main15650_1 {
    static int N, M;
    static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        permute(1, 0);
        System.out.println(sb);

    }
    // DFS
    public static void permute(int at, int depth) {
        // 깊이가 M이랑 같을경우 출력
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        // i 는 at 부터 탐색하도록 한다.
        for (int i = at; i <= N; i++) {
            // 현재 깊이를 index로 하여 해당 위치에 i 값을 담는다
            arr[depth] = i;
            // 재귀호출 :  현재 i 값보다 다음 재귀에서 더 커야하므로
            // i + 1 의 값을 넘겨주고, 깊이 또한 1 증가시켜 재귀호출해준다
            permute(i + 1, depth + 1);

        }
    }
}
