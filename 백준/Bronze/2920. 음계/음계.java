import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[8];
        for (int i = 0; i < 8; i++) {
            input[i] = sc.nextInt();
        }

        int[] ascend = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] decend = {8, 7, 6, 5, 4, 3, 2, 1};

        int sum = 0;

        for (int i = 0; i < 8; i++) {
            if(ascend[i]==input[i]){
                sum += 0;
            }
            else if(decend[i]==input[i]){
                sum += 10;
            }
            else sum +=100;
        }
        if (sum == 0) {
            System.out.println("ascending");
        }
        else if(sum == 80){
            System.out.println("descending");
        }
        else{
            System.out.println("mixed");
        }
    }
}