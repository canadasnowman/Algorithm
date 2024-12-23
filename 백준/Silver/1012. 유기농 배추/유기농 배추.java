import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] A;
    static int[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int X,Y;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());

        for (int l = 0; l < repeat; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int columns = Integer.parseInt(st.nextToken());//x축과 y축의 길이 받기
            int rows = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            X = columns;
            Y = rows;

            A = new int[columns][rows];
            visited = new int[columns][rows];

            count = 0;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int tmpx = Integer.parseInt(st.nextToken());
                int tmpy = Integer.parseInt(st.nextToken());
                A[tmpx][tmpy] = 1;
            }

            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    if (A[i][j] == 1 && visited[i][j] != 1) {
                        BFS(i, j);
                    }
                }
            }
            System.out.println(count);
        }

    }
    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = 1;

        count++;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < X && ny >= 0 && ny < Y) {
                    if (A[nx][ny] == 1 && visited[nx][ny] != 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
    }

}