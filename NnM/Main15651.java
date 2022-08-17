package study.NnM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// arr의 idx번째를, sel에 담자. 라는게 기본 틀이다.
// 한번 담아보고, 한번 안담아보고를 반복하면 됨.(idx값의 변화) arr에 idx번째를 sel의 k번째에 담고,
// 담은걸 유효화 하려면 k를 늘려주고 k를 그대로 가져가면된다.
public class Main15651 {
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

        permute(arr, sel, 0, M);
        System.out.println(sb);

    }

    private static void permute(int[] arr, int[] output, int depth, int cnt) {
        if (depth == cnt){
            print(output, cnt);
            return;
        }

        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;
            output[depth] = arr[i];
            permute(arr, output, depth+1, cnt);
        }
    }

    private static void print(int[] output, int cnt) {
        for (int i = 0; i < cnt; i++){
            sb.append(output[i] + " ");
        }
        sb.append("\n");
    }

}
