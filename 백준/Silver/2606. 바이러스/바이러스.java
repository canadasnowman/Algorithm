import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        //1번째로 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 배열의 크기 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        //인접 리스트와 방문배열 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        //간선 입력받기
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            A[g].add(h);
            A[h].add(g);
        }

        int start = 1;
        DFS(1);
        System.out.println(count - 1);
    }
    static void DFS(int v){
       Stack<Integer> stack = new Stack<>();
       stack.push(v);
       visited[v] = true;
       count++;

       while(!stack.empty()){
           int j = stack.pop();
           for(int negihber : A[j]){
               if(!visited[negihber]){
                   stack.push(negihber);
                   visited[negihber] = true;
                   count++;
               }
           }
       }
    }
}