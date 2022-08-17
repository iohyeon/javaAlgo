package study.NnM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복포함
public class Main15651_2 {
    static int N, M;
    static int arr[];
    static int sel[];   // output
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sel = new int[M];

        for (int i = 0; i < N; i++){
            arr[i] = i+1;
        }
        // 처음에 0개의 자연수를 고른 상태로 시작
        permute(0);
        System.out.println(sb);

    }

    // DFS
    public static void permute(int cnt) {
        // M개의 자연수를 모두 골랐다면
        // 고른 자연수들을 buffer에 저장
        if (cnt == M) {
            int x = 0;
            for (int j = 0; j < N; j++){
                sb.append(sel[x++] + " ");
                if (x == M ){
                    break;
                }
            }
            sb.append("\n");
            return;
        }

        // 중복 순열로 해당 숫자가 사용되었는지 확인할 필요 없음
        // 그냥 바로 해당 자연수를 사용해버리기!
        for (int i = 0; i < N; i++){
            sel[cnt] = arr[i];
            permute(cnt + 1);
        }
    }

}
