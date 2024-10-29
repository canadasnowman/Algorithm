import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int N = scanner.nextInt();
    	
    	int[] count = new int[N];
    	String[] S =  new String[N];
    	char[] tmp;
    	
    	for(int i = 0;i < N ;i++) {
    		count[i] = scanner.nextInt();
    		S[i] = scanner.next();
    	}
    	for(int i = 0;i < N ;i++) {
    		tmp = S[i].toCharArray();
    		for(int j = 0;j < S[i].length();j++) {
    			for(int l =0;l<count[i];l++) {
    			System.out.print(tmp[j]);
    			}
    		}
    		System.out.print('\n');
    		
    	}
    	
    }
}