import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;  // 종료 조건
            }

            char[] tmp_char = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;  // 올바른 괄호인지 확인하는 플래그

            for (int i = 0; i < tmp_char.length; i++) {
                if (tmp_char[i] == '(' || tmp_char[i] == '[') {
                    stack.push(tmp_char[i]);
                } else if (tmp_char[i] == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;  // 잘못된 괄호 순서 발견
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (tmp_char[i] == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;  // 잘못된 괄호 순서 발견
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            // 만약 모든 괄호가 맞다면 stack이 비어 있어야 함
            if (isValid && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
