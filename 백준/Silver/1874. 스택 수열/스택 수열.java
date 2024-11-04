import java.io.*;
import java.util.Stack;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arrInput = new int[n];
        for(int i = 0 ;i < n;i++){
            arrInput[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stackInt = new Stack<>();
        StringBuilder st = new StringBuilder();
        int stackNum = 1;
        for(int i = 0 ;i<n;i++){
            while(stackNum<=n) {
                if (stackInt.empty()==true) {
                    stackInt.push(stackNum++);
                    st.append("+\n");
                }
                if (stackInt.peek() == arrInput[i]) {
                    stackInt.pop();
                    st.append("-\n");
                    break;
                } else {
                    stackInt.push(stackNum++);
                    st.append("+\n");
                }
            }
            if(stackInt.empty()!=true&&stackInt.peek()==arrInput[i]){
                stackInt.pop();
                st.append("-\n");
            }
        }
        if(stackInt.empty()==true){
            bw.write(st.toString());
        }
        else bw.write("NO");

        bw.flush();
        bw.close();
        br.close();
    }
}