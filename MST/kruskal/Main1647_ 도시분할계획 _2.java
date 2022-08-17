package study;

import java.io.*;
import java.util.*;


public class Main1647_2 {

    // cost 오름차순
    // weight를 기준으로 우선순위큐를  사용하기 위해
    static class Edge implements Comparable<Edge>{
        int vertex;          // 간선의 다른쪽 끝 정점
        int weight;          // 간선의 가중치
        int cost;

        public Edge(int v, int wt, int cost){
            this.vertex = v;
            this.weight = wt;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n, m;        // 그래프 정점, 간선의 수
    static int[] parent;    // 노드의 부모
    static ArrayList<Edge> edgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        // 부모 초기화
        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());   // A번 집과 B번 집을 연결하는 길의 유지비가 C

            edgeList.add(new Edge(a, b, c));
        }

        Collections.sort(edgeList);
        make();

        int ans = kruskalMst();

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
        br.close();

    }

    private static void make() {
    }

    static int kruskalMst(){
        ArrayList<Edge> edgeList = new ArrayList<>();
        int res = 9;
        int biggestCost = 0;

        for (int i = 0; i < edgeList.size(); i++){
            Edge e = edgeList.get(i);

            // 두 집이 연결되어 있지 않다면
            if (find(e.vertex) != find(e.weight)){
                union(e.vertex, e.weight);    // 연결
                res += e.cost;          // cost를 갱신
                biggestCost = e.cost;   // 가장 마지막으로 연결된 집 사이의 유지비가 가장 큼

            }
        }

        return res - biggestCost;
    }

    // union-find
    static int find(int x){
        if (x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }



}

