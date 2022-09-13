package study.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
//한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
//쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
//이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
public class BOJ_1914_하노이탑_2 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        BigInteger result = new BigInteger("1");

        if (N == 1 ) {
            System.out.println(1);
        } else {
            for (int i = 0; i < N; i++) {
                result = result.multiply(new BigInteger("2"));
            }

            result = result.subtract(new BigInteger("1"));

            System.out.println(result);
        }

        if (N <= 20) {
            move(N, '1', '2', '3');
        }

    }

    private static void move(int N, char c, char c1, char c2) {
        if(N==1) {
            System.out.println(c+" "+c2);
        }else {
            move(N-1,c,c2,c1);
            System.out.println(c+" "+c2);
            move(N-1,c1,c,c2);
        }
    }
}
