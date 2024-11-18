import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] ran = new int[K];
        for (int i = 0; i < K; i++) {
            ran[i] = Integer.parseInt(br.readLine());
        }

        int max = ran[0];
        for (int i = 1; i < K; i++) {
            if (max < ran[i]) {
                max = ran[i];
            }
        }
        long result = 0;
        long sum = 0;
        long low = 1;
        long high = max;
        while (low<=high) {
            long mid = (low + high) / 2;
            for (int i = 0; i < K; i++) {
                sum += ran[i]/mid;
            }

            if (sum < N) {
                high = mid - 1;

            } else if (sum >= N) {
                result = mid;
                low = mid + 1;
            }
            sum = 0;
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }
}