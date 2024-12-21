import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static Boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        A = new ArrayList[N + 1];
        visited = new Boolean[N + 1];

        for(int i = 1;i < N + 1; i++){
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            A[g].add(h);
            A[h].add(g);
        }

        int start = 1;
        count = 0;

        DFS(start);
        System.out.println(--count);
    }
    static void DFS(int v){
        visited[v] = true;
        count ++;

        for(int neighboor : A[v]){
            if(!visited[neighboor]){
                DFS(neighboor);
            }
        }
    }
}