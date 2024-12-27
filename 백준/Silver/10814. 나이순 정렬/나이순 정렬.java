import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static String[] A = new String[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            sumstr(a,a+" "+b);
        }
        for (int i = 0; i < 100000; i++) {
            if(A[i] != null){
                System.out.println(A[i]);
            }
        }
    }
    static void sumstr(int a, String b){
        if(A[a] != null){
            A[a] = A[a] + "\n" + b;
        }
        else{
            A[a] = b;
        }
    }
}