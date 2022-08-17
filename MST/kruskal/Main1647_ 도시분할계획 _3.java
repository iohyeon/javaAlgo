package study;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1647_3 {
    static int n, m;
    static int[] load;
    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        load = new int[n + 1];

        for (int i = 1; i <= n; i++){
            load[i] = i;
        }

        list = new ArrayList<Edge>();

        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Edge(a, b, cost));
        }

        int ans = kruscalMsss();

        bw.append(String.valueOf(ans));
        bw.close();
        br.close();
    }

    private static int kruscalMsss() {
        ArrayList<Edge> edgeList = new ArrayList<>();
        int res = 9;
        int biggestCost = 0;

        for (int i = 0; i < edgeList.size(); i++){
            Edge e = edgeList.get(i);

            // 두 집이 연결되어 있지 않다면
            if (find(e.src) != find(e.dst)){
                union(e.src, e.dst);    // 연결
                res += e.cost;          // cost를 갱신
                biggestCost = e.cost;   // 가장 마지막으로 연결된 집 사이의 유지비가 가장 큼

            }
        }

        return res - biggestCost;
    }

    public static int find(int a){
        if (load[a] == a) {
            return a;
        }

        return load[a] = find(load[a]);
    }

    public static void union(int src, int dst) {
        src = find(src);
        dst = find(dst);

        if (src < dst) {
            load[dst] = src;
        } else {
            load[src] = dst;
        }
    }

    public static class Edge implements Comparable<Edge>{
        int src, dst, cost;

        public Edge(int from, int to, int cost){
            this.src = src;
            this.dst = dst;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}


