import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int facto(int n){
        if(n == 0){
            return 1;
        }
        return n * facto(n - 1);
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String s = br.readLine();
       StringTokenizer st = new StringTokenizer(s);

       int N = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());

       int result = facto(N) / (facto(N - K) * facto(K));

       System.out.println(result);
    }
}