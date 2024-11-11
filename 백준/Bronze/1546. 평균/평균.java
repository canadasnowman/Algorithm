import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] arr = new double[n];
        double max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / max * 100;
            sum += arr[i];
        }

        double average = sum / n;
        System.out.println(average);
    }
}