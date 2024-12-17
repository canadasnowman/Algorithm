import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s =  br.readLine();
            char[] tmp = s.toCharArray();
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (count < 0){break;}
                if (tmp[j] == '(') {
                    count++;
                }
                else{
                    count--;
                }
            }
            if (count == 0){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}