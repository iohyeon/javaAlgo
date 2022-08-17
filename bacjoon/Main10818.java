package bacjoon;

import java.util.Scanner;

public class Main10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("테스트 케이스 숫자를 입력해주세요.");
        int T = sc.nextInt();

        int arr[] = new int[T];
        int max = 0;
        int min = 999;
        int i, j;
        System.out.println("숫자 5개를 입력해주세요.");
        for (i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            if (arr[i] > max){
                max = arr[i];
            } else if (arr[i] <= min){
                min = arr[i];
            }
        }
        System.out.println(min + " " + max);
    }
}
