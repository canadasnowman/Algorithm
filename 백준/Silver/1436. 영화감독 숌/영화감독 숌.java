import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i = 666;
        int count = 0;
        int result = 0;
        String tmp;
        char[] tmpCh;

        while(count <= n){
            tmp = " " + i;
            tmpCh = tmp.toCharArray();
            for (int j = 1; j < tmp.length() - 2; j++) {
                if(tmpCh[j]=='6'&&tmpCh[j+1]=='6'&&tmpCh[j+2]=='6'){
                    count++;
                    result = i;
                    break;
                }
            }
            if(count==n)break;
            i++;
        }

        System.out.println(result);
    }
}