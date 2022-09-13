package study.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  <다익스트라 알고리즘 구현  (우선순위 큐) >
public class BOJ_18352_특정거리의도시찾기_3 {
    private static final int INF = Integer.MAX_VALUE;
    static List<List<EdgeCity>> listEdge = new ArrayList<>();
    static int[] distance;
    static int N, M, K, X, V;

    static class EdgeCity implements Comparable<EdgeCity> {
        int vertex;
        int value;

        public EdgeCity(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(EdgeCity e) {
            return value - e.value;
//            if (this.value < e.value) return 1;
//            else return -1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N+1];

        Arrays.fill(distance, INF);

        listEdge = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            listEdge.add(new ArrayList<>());
        }

        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            listEdge.get(x).add(new EdgeCity(y, 1));
        }

        dijkstra(X);

        for(int i=1; i<distance.length; i++) {
            if(distance[i] == K) {
                sb.append(i).append('\n');
            }
        }

        if(sb.length() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sb);
        }

    }

    private static void dijkstra(int vertex) {
        PriorityQueue<EdgeCity> que = new PriorityQueue<>();
        boolean visit[] = new boolean[N+1];
        distance[vertex] = 0;

        que.offer(new EdgeCity(vertex, 0));

        while( !que.isEmpty() ) {
            EdgeCity city = que.poll();
            int num = city.vertex;

            if(visit[num]) continue;

            visit[num] = true;

            for(EdgeCity c : listEdge.get(num)) {

                if( !visit[c.vertex] && distance[c.vertex] > (c.value + distance[num]) ) {
                    distance[c.vertex] = c.value + distance[num];
                    que.offer(new EdgeCity(c.vertex, distance[c.vertex]));
                }
            }
        }

    }

}

