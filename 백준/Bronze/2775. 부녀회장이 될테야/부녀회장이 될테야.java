import java.util.Scanner;

public class Main {
    public static int search(int[][] arr, int k, int n) {
        // 이미 값이 계산되어 있으면 바로 반환
        if (arr[k][n] != 0) {
            return arr[k][n];
        }
        
        if (k == 0) { // 0층일 때 n호에 n명이 거주
            return n;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += search(arr, k - 1, i);
        }
        arr[k][n] = sum;  // 결과 저장 (메모이제이션)
        return arr[k][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 테스트 케이스의 개수 입력

        int[][] arr = new int[15][15]; // 최대 14층 14호까지 처리할 수 있는 배열

        // 0층 초기화 (1호부터 n호까지는 각 n명이 거주)
        for (int i = 1; i < 15; i++) {
            arr[0][i] = i;
        }

        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();  // k층
            int n = sc.nextInt();  // n호

            int result = search(arr, k, n);
            System.out.println(result);
        }
        sc.close();
    }
}
