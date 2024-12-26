import java.util.*;
import java.io.*;

public class Main{
    static int[][] apt, visited;
    static int[] nx = {-1, 0, 1, 0};
    static int[] ny = {0, -1, 0, 1};
    static int sta_N;
    static int countApt;
    static int[] countPeople;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        int N = Integer.parseInt(br.readLine());
        sta_N = N; //

        apt = new int[N][N];
        visited = new int[N][N];
        countPeople = new int[625];
        countApt = 0;

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            char[] strtmp = str.toCharArray();
            for (int j = 0; j < N; j++) {
                apt[i][j] = strtmp[j] - '0';
                visited[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apt[i][j] == 1 && visited[i][j] == 0) {
                    countPeople[countApt] = 0;
                    BFS(i, j);
                }
            }
        }
        Arrays.sort(countPeople);
        System.out.println(countApt);
        for (int i = 0; i < 625; i++) {
            if(countPeople[i] !=0) {
                System.out.println(countPeople[i]);
            }
        }
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        countPeople[countApt]++;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            visited[cx][cy] = 1;

            for (int i = 0; i < 4; i++) {
                int xx = cx + nx[i];
                int yy = cy + ny[i];
                if (xx >= 0 && xx < sta_N && yy >= 0 && yy < sta_N) {
                    if (apt[xx][yy] == 1 && visited[xx][yy] == 0) {
                        queue.add(new int[]{xx, yy});
                        visited[xx][yy] = 1;
                        countPeople[countApt]++;
                    }
                }
            }
        }
        countApt++;
    }
}