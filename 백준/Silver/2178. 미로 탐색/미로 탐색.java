import java.io.*;
import java.util.*;

public class Main {
    static int[][] A, visited, distance;
    static int rows, colunms;
    static int[] zx = {-1, 0, 0, 1};
    static int[] zy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        colunms = Integer.parseInt(st.nextToken());

        A = new int[rows][colunms];
        visited = new int[rows][colunms];
        distance = new int[rows][colunms];

        for (int i = 0; i < rows; i++) {
            String tmp = br.readLine();
            char[] tmpS = tmp.toCharArray();
            for (int j = 0; j < tmpS.length; j++) {
                A[i][j] = tmpS[j] - '0';
                visited[i][j] = 0;
                distance[i][j] = 0;
            }
        }

        BFS(0, 0);

        System.out.println(distance[rows - 1][colunms - 1] + 1);
    }
    static void BFS(int N, int M){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, M});
        visited[N][M] = 1;
        while(!queue.isEmpty()){
            int current[] = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + zx[i];
                int ny = cy + zy[i];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < colunms) {
                    if (visited[nx][ny] == 0 && A[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        distance[nx][ny] = distance[cx][cy] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
