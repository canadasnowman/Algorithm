import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       int tmp = (N / 5);

       while(tmp > 0){
           if ((N - (5 * tmp)) % 3 == 0) {
               System.out.println(tmp + ((N - (tmp * 5)) / 3));
               break;
           }
           tmp--;
       }

       if(tmp == 0 && N % 3 == 0){
           System.out.println(N / 3);
       } else if (tmp == 0 && N % 3 != 0) {
           System.out.println(-1);
       }
    }
}