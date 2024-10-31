import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static int getSquare(int number) {
		return number * number;
	}
	public static boolean Square(int[] sidenumber) {
		if(getSquare(sidenumber[2])==(getSquare(sidenumber[0])+getSquare(sidenumber[1]))){
			return true;
		}
		else return false;
	}
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int[] side = new int[3];
    	
    	while(true) {
    		for(int i = 0;i < 3;i++) {
    			side[i]= scanner.nextInt();
    		}
    		if(side[0]==0&&side[1]==0&&side[2]==0)break;
    		Arrays.sort(side);
    		if(Square(side) == true) {System.out.println("right");}
    		else {System.out.println("wrong");}
    	}
    }
}