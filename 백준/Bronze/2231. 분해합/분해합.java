import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int n = scanner.nextInt();
    	
    	int sum =0;
		int tmp = 0;
		int cnt = 0;
		for(int i =0;i<n;i++) {
			sum = i;
			tmp = i;
			while(tmp > 0) {
				sum+=(tmp%10);
				if(tmp<10) {break;}
				tmp = tmp/10;
			}
			if(sum == n) {cnt =i; break;}
		}
		System.out.println(cnt);
    		
    }
}