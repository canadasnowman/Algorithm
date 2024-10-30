import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	int N = scanner.nextInt();
    	String[] input = new String[N];
    	int Sum = 0;
    	int count = 0;
    	
    	for(int i = 0;i < N;i++){
    		input[i]=scanner.next();
    	}
    	
    	char[] tmp;
    	
    	for(int i = 0;i < N;i++){
    		tmp = input[i].toCharArray();
    		for(int j =0;j<input[i].length();j++) {
    			if(tmp[j]=='O') {
    				count++; 
    				Sum+=count;
    			}
    			else {count=0;}
    		}
    		System.out.println(Sum);
    		Sum =0;
    		count = 0;
    	}
    }
}