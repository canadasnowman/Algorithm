import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[101];

        for (int i = 1; i <= n; i++) {
            arr[(i * 2) - 1] = sc.nextInt();
            arr[(i * 2)] = sc.nextInt();
        }
        int[] count = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[(i * 2) - 1] < arr[(j * 2) - 1] && arr[i * 2] < arr[j * 2]) {
                    count[i - 1]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(++count[i]);
        }

    }
}
