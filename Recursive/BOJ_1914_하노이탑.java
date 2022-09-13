package study.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
//한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
//쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
//이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
public class BOJ_1914_하노이탑 {
    static int N;
    static StringBuffer sb = new StringBuffer();

    static void move(int no, int x, int y) {
        if(no > 1) {
            move(no - 1, x, 6 - x - y);
        }

        sb.append((2 << (N - 1)) - 1 + "\n");
        System.out.println("원반["+no+"]을" + x + "기둥에서 " + y + "기둥으로 옮김");

        if(no < 1){
            move(no - 1, 6 - x - y , y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());



        move(N, 1, 3);
    }
}
