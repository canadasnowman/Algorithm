import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] A, visitied;
    static int columns, rows, count, max, maxCount;
    static Queue<int []> queue ;
    static int[] nx = {-1, 0, 1, 0};
    static int[] ny = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); //배열 길이 설정
        rows = Integer.parseInt(st.nextToken());
        columns = Integer.parseInt(st.nextToken());

        A = new int[columns][rows]; //배열 길이 할당
        visitied = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < columns; j++) {
                A[j][i] = Integer.parseInt(st.nextToken()); //배열의 1값들 넣어주기
                visitied[j][i] = 0;
            }
        }

        count = 0;
        max = 0;
        maxCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (A[j][i] == 1 && visitied[j][i] == 0) {
                    BFS(j, i);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static void BFS(int x, int y){
        count++;//bfs에 들어왔으니까 count++해주기
        maxCount = 1;
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visitied[x][y] = 1;
        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = current[0] + nx[i];
                int cy = current[1] + ny[i];
                if (cx >= 0 && cx < columns && cy >= 0 && cy < rows) {
                    if (A[cx][cy] == 1 && visitied[cx][cy] == 0) {
                        visitied[cx][cy] = 1;
                        queue.add(new int[]{cx, cy});
                        maxCount++;
                    }
                }
            }
        }

        if (max < maxCount) {
            max = maxCount;
        }
    }

}