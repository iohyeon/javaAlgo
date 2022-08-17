package study;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 도시 분할 계획
// cost 오름차순
class Edge implements Comparable<Edge>{
    int x, y, cost;
    // 간선 객체를 생성
    public Edge(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    // 우선순위 큐를 사용하기 위한 오버라이딩
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main1647_1 {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edge> edgeList = new PriorityQueue<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 각 노드의 루트 노드를 본인으로 초기화
        parent = new int[n + 1];
        int[] rank = new int[n + 1];
        edgeList = new PriorityQueue<>();

        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList.offer(new Edge(from, to, cost));
        }

        int ans = kruskal();

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();

    }

    static int kruskal(){
        PriorityQueue<Edge> edgeList = new PriorityQueue<>();
        int mcost = 0;
        int count = 0;

        while (count < n - 2){
            Edge edge = edgeList.poll();

            // 두 집이 연결되어 있지 않다면
            if (find(edge.x) != find(edge.y)){
                union(edge.x, edge.y);    // 연결
                mcost += edge.cost; // cost를 갱신
                count++;            // 가장 마지막으로 연결된 집 사이의 유지비가 가장 큼
            }
        }

        return mcost;
    }

    // union-find
    // 노드가 속한 집합의 루트 노드 찾는
    static int find(int x){
        if (x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // 노드 집합을 합치는 합집합
    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x == y){
            return;
        }

//        if(rank[x] > rank[y]){
//            swap(x, y);
//            parent[x] = y;
//        }
//        if(rank[x] > rank[y]){
//            parent[x]++;
//        }
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static void swap(int x, int y) {
    }

}
