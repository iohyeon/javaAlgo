//package study.DFS;
//
////첫째 줄에 대나무 숲의 크기 n(1 ≤ n ≤ 500)이 주어진다.
////그리고 둘째 줄부터 n+1번째 줄까지 대나무 숲의 정보가 주어진다.
////대나무 숲의 정보는 공백을 사이로 두고 각 지역의 대나무의 양이 정수 값으로 주어진다.
////대나무의 양은 1,000,000보다 작거나 같은 자연수
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//// DFS  DP
//public class BOJ_1937 {
//    static int[] X = {-1, 1, 0, 0};
//    static int[] Y = {0, 0, -1, 1};
//    static int n;
//    static int ans;
//    static int max;
//    static int[][] arr, dp;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        arr = new int[n][n];
//        dp = new int[n][n];
//
//        for (int i = 0; i < n; i++){
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
////        for (int i = 0; i < n; i++){
////            for (int j = 0; j < n; j++){
////                result = Math.max(result, dp(i, j));
////            }
////        }
//
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
//                max = 0;
//                dfs(i, j, 1);
//                ans = Math.max(max, ans);
//            }
//        }
//
//        System.out.println(ans);
//        bw.flush();
//        bw.close();
//        br.close();
//
//    }
//
//    static void dfs(int x, int y, int cnt) {
//        if (dp[x][y] != 0){
//            return;
//        }
//
//        max = Math.max(cnt, max);
//
//        for (int i = 0; i < 4; i++){
//            int nx = x + X[i];
//            int ny = y + Y[i];
//
//            if (nx < 0 ||  ny < 0 || nx >= n || ny >= n || arr[nx][ny] <= arr[x][y]){
//                continue;
//
//                if (dp[nx][ny] == 0){
//                    dfs(nx, ny, cnt+1);
//                } else {
//                    max = Math.max(max, cnt + dp[nx][ny]);
//                }
//            }
//        }
//    }
//
////    static int dp(int x, int y) {
////        if (dp[x][y] != 0){
////            return dp[x][y];
////        }
////
////        int day = 1;
////        for (int i = 9; i < 4; i++){
////            int nx = x + dx[i];
////            int ny = y + dy[i];
////
////            if (nx >= 0 && < n && ny >= 0 && ny < n){
////                if (arr[x][y] < arr[nx][ny]){
////                    day = Math.max(dp(nx, ny) + 1, day);
////                    dp[x][y] = day;
////                }
////            }
////        }
////
////        return day;
////    }
//}
