import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int n = scanner.nextInt();
    	
    		int house = 6;
    		int sum =1;
    		int cnt =0;
    		
    		while(n>sum) {
    			sum += house;
    			cnt ++;
    			house +=6;
    		}
    		System.out.println(cnt+1);
    }
}