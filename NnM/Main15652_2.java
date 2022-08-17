package study.NnM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복조합 , 비내림차순 중복허용 방문체크 x 같은 곳 탐색 가능
public class Main15652_2 {
    static int N,M;
    static int arr[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs(0);
        System.out.println(sb);

        br.close();
    }

    // DFS로 모든 경우의 수를 찾는데 중복을 허용한다.
    static void dfs(int cnt) {
        if (cnt == M) {
            for(int i = 0; i < M-1; i++) {
                if(arr[i] > arr[i+1]){
                    return;
                }
            }

            for(int i : arr){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        // 중복조합이므로 자기 자신idx부터 자연수를 고를 수 있다.
        for(int i = 1; i <= N; i++) {
            // 중복이 허용되므로 해당 자연수가 사용되었는지 확인할 필요가 없다.
            arr[cnt] = i;
            dfs(cnt + 1);
        }

    }
}
