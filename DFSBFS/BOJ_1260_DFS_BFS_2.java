package study.DFSBFS;
import java.io.*;
import java.util.*;

//  dfs - 스택 자료구조/ 재귀함수 활용
//  bfs - 큐 자료구조/ 요소를 queue에 추가하면서 반복문 돌기
// 깊이 우선 탐색(DFS)와 너비 우선 탐색(BFS) 알고리즘
public class BOJ_1260_DFS_BFS_2 {
    static int n, m, v;		    // n정점, m간선
    static ArrayList<Integer>[] map;  // 각 정점간 탐색 경로를 저장할 배열 . 각 정점간 탐색 경로 저장 : 노드 연결상태를 나타내는 2차원 인접행렬
    static boolean visited[];	// 정점 탐색여부 체크
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 정점의 개수(정점)
        m = Integer.parseInt(st.nextToken());   // 간선의 개수(간선)
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1]; // 방문 배열 초기화

        map = new ArrayList[n+1];    // 각 정점간 탐색 경로를 저장할 배열

        // 번호가 작은 것을 먼저 방문하기 위해 정렬
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<Integer>();
        }

        // 인접행렬
        for (int i = 0; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for(ArrayList<Integer> arr : map){
            Collections.sort(arr);
        }
        sb = new StringBuilder();
        dfs(v);
        System.out.println(sb);
        sb = new StringBuilder();
        bfs();
        System.out.println(sb);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dfs(int node) {
        System.out.println("node" + node);
        visited[node] = true;
        sb.append(node).append(" ");

        for(int i : map[node]){
            if(visited[i]) {
                continue;
            }
            dfs(i);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(v);

        while (!q.isEmpty()){
            int v = q.poll();

            visited[v] = false;
            sb.append(v).append(" ");

            for(int i = 0; i < map[v].size(); i++){
                if(visited[map[v].get(i)]) {
                    q.add(map[v].get(i));
                }
                visited[map[v].get(i)] = false;
            }
        }
    }
}
