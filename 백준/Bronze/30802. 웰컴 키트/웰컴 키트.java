import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int N = scanner.nextInt();
    	int[] arr = new int[6];
    	int T ;
    	int P ;
    	
    	for(int i = 0;i< 6;i++) {
    		arr[i]=scanner.nextInt();
    	}
    	T = scanner.nextInt();
    	P = scanner.nextInt();
    	
    	int cnt = 0;
    	
    	for(int i = 0;i< 6;i++) {
    		if(arr[i]>0&&arr[i]<=T) {
    			cnt++;
    		}
    		else if(arr[i]>T) {
    			cnt += (arr[i]/T);
    			if(arr[i]%T!=0)cnt++;
    		}
    		
    	}
    	System.out.println(cnt);
    	System.out.println((N/P)+" "+(N%P));	
    }
}