import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static Boolean[] visited;
    static ArrayList<Integer> count  = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점의 갯수 받기
        int M = Integer.parseInt(st.nextToken()); //간선의 갯수 받기
        int V = Integer.parseInt(st.nextToken()); //시작할 정점 선택

        //배열의 길이 만들어주기. 근데 정점을 1번부터 쓸 거니까 배열의 갯수도 N + 1 로 해주기
        A = new ArrayList[N + 1];
        visited = new Boolean[N + 1];

        //배열들 초기화 해주기
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);//양방향의 간선이므로 양쪽으로 추가해주기
            A[y].add(x);
        }

        DFS(V);

        for (int c : count) {
            int cn = 0;
            cn++;
            if( cn < count.size()) {
                System.out.print(c + " ");
            }
            else {
                System.out.print(c);
            }
        }

        //방문배열 다시 초기화과 count를 초기화
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
            count = new ArrayList<>();
        }
        System.out.println();

        BFS(V);

    }

    static void DFS(int start){
        visited[start] = true;
        count.add(start);
        Collections.sort(A[start]);
        for(int neighber : A[start]){
            if(!visited[neighber]){
                visited[neighber] = true;
                DFS(neighber);
            }
        }
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        count.add(start);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;

            Collections.sort(A[tmp]);
            for (int neighber : A[tmp]) {
                if (!visited[neighber]) {
                    queue.add(neighber);
                    visited[neighber] = true;
                    count.add(neighber);
                }
            }
        }
        for (int c : count) {
            int cn = 0;
            cn++;
            if( cn < count.size()) {
                System.out.print(c + " ");
            }
            else {
                System.out.print(c);
            }
        }
    }
}