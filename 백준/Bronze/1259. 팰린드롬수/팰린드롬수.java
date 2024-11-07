import java.util.Scanner;

public class Main {
    public static void pell(int n){
        String s = n+"";
        char[] tmp;
        tmp = s.toCharArray();

        //System.out.println(s);
        //System.out.println(tmp.length);

        int low = 0;
        int high = tmp.length - 1;

        while(true) {
            if(low == high){//홀수일때
                System.out.println("yes");
                break;
            }
            if (tmp[low] != tmp[high]) {
                System.out.println("no");
                break;
            }
            if ((low + 1) == high) {//짝수일때
                System.out.println("yes");
                break;
            }
            low++;
            high--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(true){
            n = sc.nextInt();
            if(n == 0) {
                break;
            }
            pell(n);
        }

    }
}
