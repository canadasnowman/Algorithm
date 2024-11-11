import java.util.Scanner;

public class Main {
    public static int sumCal(int[] S,int i,int j){
        return S[j] - S[i - 1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //개수
        int M = scanner.nextInt(); //횟수

        int[] A = new int[N + 1];
        for (int l = 1; l <= N; l++) {
            A[l] = scanner.nextInt();
        }
        int[] S = new int[N + 1];

        for (int l = 1; l <= N; l++) {
            S[l] = S[l - 1] + A[l];
        }

        for (int l = 0; l < M; l++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            System.out.println(sumCal(S, i, j));
        }
    }
}