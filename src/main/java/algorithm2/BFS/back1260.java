package algorithm2.BFS;

import java.util.Scanner;

public class back1260 {

  /**
   * 출처: https://www.acmicpc.net/problem/1260
   * ##문제##
   * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
   * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
   * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
   */

   /**
    * ##입력## 
    첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
    다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
    입력으로 주어지는 간선은 양방향이다.
      4 5 1
      1 2
      1 3
      1 4
      2 4
      3 4
    */

    /**
     * ##출력#
     * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
     * 1 2 4 3
       1 2 3 4
     */
  
     static boolean edge[][]; 
     static boolean visited[]; 
     static int n; 
     static int m; 
 
     public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in); 
      n = scanner.nextInt(); //정점개수
      m = scanner.nextInt(); //간선개수 
      
      int v = scanner.nextInt(); //탐색을 시작할 정점의 번호 

      edge = new boolean[n+1][n+1];
      visited= new boolean[n+1]; 

      for (int i=0; i < m; i++) { //이 for문에서 만드는 간선은 양방향 
        int x = scanner.nextInt(); 
        int y = scanner.nextInt();
        edge[x][y] = true; 
        edge[y][x] = true; //양방향 설정. 
      } //for() end 

      dfs(v); 


      scanner.close();
     }

     static void dfs(int current) {
      visited[current] = true; 
      
     }
}