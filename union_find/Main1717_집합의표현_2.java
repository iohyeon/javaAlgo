package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main1717_2 {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 1 ~ N 까지의 int 배열
        parent = new int[n + 1];    // parent 요소
        // parent 초기화
        for (int i = 1; i <= n; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 집합 확인 : 합집합일 경우 union
            if (c == 0){
                // a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산 a와 b는 n 이하의 자연수 또는 0이며 같을 수도 있다
                union(a, b);
            } else if (c == 1){    // 같은 집합이면 find
                // 1로 시작하는 입력에 대해서 한 줄에 하나씩 YES/NO
                sb.append((isSomeParent(a, b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    // b의 부모를 a의 부모를 치환하는 연산 (a > b 일 경우, 반대)
    // 매개변수로 받은 원소 a와 b를 같은 그래프로 합치는 함수
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[find(b)] = find(a);
        } else if (a > b){
            parent[find(a)] = find(b);
        }
    }

    // a의 부모를 찾는 연산
    public static int find(int a){
        if ( parent[a] == a){
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    // a와 b의 부모가 같은지 확인
    private static boolean isSomeParent(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        }

        return false;
    }
}
