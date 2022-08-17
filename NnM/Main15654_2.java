package study.NnM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15654_2 {
    static int N, M;
    static int arr[];
    static int sel[];
    static boolean visited[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];   // input배열에 N개의 자연수를 입력받고 오름차순 정렬한다.
        sel = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer( br.readLine() );
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt( st.nextToken() );
        }
        // 수열을 구하는 메소드 재귀호출을 통해 결과를 출력한다.
        Arrays.sort(arr);
        permute( 0);

        System.out.println(sb);

    }

    private static void permute(int depth) {
        // 수열을 구하는 메소드는 재귀호출한 횟수가 M과 같으면 output 배열을 출력한다.
        if (depth == M) {
            for(int i : sel) {
                System.out.print(i + " ");
            }
            return;
        }
        // M과 다르다면 input 배열을 순차적으로 output 배열에 넣고 재귀호출을 한다.
        // 방문 체크를 통해 수열이 중복되지 않도록 한다.
        for(int i = 0; i < N; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                sel[depth] = arr[i];
                permute(depth + 1);
                visited[i] = false;
            }
        }

    }
}
