import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] A;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N,K;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());

        for (int l = 0; l < repeat; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int colunms = Integer.parseInt(st.nextToken());
            int rows = Integer.parseInt(st.nextToken());
            int vegt = Integer.parseInt(st.nextToken());
            A = new int[colunms][rows];
            visited = new int[colunms][rows];

            count = 0;
            N = colunms;
            K = rows;

            for (int i = 0; i < vegt; i++) {
                st = new StringTokenizer(br.readLine());
                A[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int i = 0; i < colunms; i++) {
                for (int j = 0; j < rows; j++) {
                    if(A[i][j] == 1) {
                        BFS(i, j);
                    }
                }
            }
            System.out.println(count);
        }

    }
    public static void BFS(int x, int y){
        if (visited[x][y] == 0) {
            count++;
        }

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(x);
        queueY.add(y);
        visited[x][y] = 1;

        while(!queueX.isEmpty()&&!queueY.isEmpty()){
            int xx = queueX.poll();
            int yy = queueY.poll();

            for (int i = 0; i < 4; i++) {
                int bx = xx - dx[i];
                int by = yy - dy[i];
                if (bx >= 0 && by >= 0 && bx < N && by < K) {
                    if (A[bx][by] == 1 && visited[bx][by] == 0) {
                        queueX.add(xx - dx[i]);
                        queueY.add(yy - dy[i]);
                        visited[xx - dx[i]][yy - dy[i]] = 1;
                    }
                }
            }
        }
    }

}