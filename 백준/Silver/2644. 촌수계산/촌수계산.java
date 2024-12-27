import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 전체 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작 노드
        int target = Integer.parseInt(st.nextToken()); // 목표 노드
        int m = Integer.parseInt(br.readLine()); // 관계의 개수

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = false;
            distance[i] = 0;
        }

        // 관계 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        // BFS 실행
        int result = bfs(start, target);

        // 결과 출력
        System.out.println(result);
    }

    static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == target){
                return distance[target];
            }
            for(int neiber : graph[current]){
                if(!visited[neiber]){
                    queue.add(neiber);
                    visited[neiber] = true;
                    distance[neiber] = distance[current] + 1;
                }
            }
        }
        return -1;
    }
}
