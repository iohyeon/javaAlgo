package bacjoon;

import java.util.Scanner;


public class Remainder {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();

        in.close();

        System.out.println( (A+B)%C );
        System.out.println( (A%C + B%C)%C );
        System.out.println( (A*B)%C );
        System.out.println( (A%C * B%C)%C );

        // 백준 제출 용
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String str = br.readLine();
//        StringTokenizer st = new StringTokenizer(str," ");
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());
//
//        System.out.println( (a+b)%c );
//        System.out.println( (a%c + b%c)%c);
//        System.out.println( (a*b)%c );
//        System.out.println( (a%c*b%c)%c);

    }
}
