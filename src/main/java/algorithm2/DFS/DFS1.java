package algorithm2.DFS;

import java.util.Scanner;

public class DFS1 {
 /**
   * https://www.codeground.org/common/popCodegroundNote
   * DFS(Depth-First-Search, 깊이 우선 탐색) 
   * 깊이 우선 탐색은 그래프의 모든 정점들을 특정한 순서에 따라 방문하는 알고리즘 중 하나입니다. 
   * 현재 정점과 인접한 간선들을 검사하다가 방문하지 않은 정점을 발견하면 그 간선을 통해 방문하지 않은 정점으로 이동하는 것입니다.
   * 이 과정을 반복하다가 더 이상 방문할 수 있는 정점이 없으면 마지막으로 통과한 간선을 통해 뒤로 돌아가서 해당 정점에서 방문할 수 있는 정점을 탐색합니다. 
   * 이러한 과정을 반복하여 그래프의 모든 정점을 방문하는 알고리즘이 DFS 알고리즘입니다. 여러분의 이해를 돕기 위해 움직이는 그림으로 그래프를 설명하도록 하겠습니다.
   * 해당 알고리즘(DFS)을 구현하기 위해서는 해당 정점이 방문되었는지 확인하는 boolean타입의 1차원 배열과 
   * 정점들의 집합 그리고 정점과 정점 사이의 연결을 확인할 수 있는 간선 집합들이 필요합니다.
   * 그리고 해당 알고리즘의 시간복잡도는 모든 정점을 방문하며 모든 간선을 검사하기 때문에 시간복잡도는 O(V+E)입니다. ( V: 정점의 개수, E: 간선의 개수)
   */

   /**
    * 문제
    * ##입력## 
    * 첫 줄에 정점의 개수 N과 간선의 개수 M이 주어집니다.
    * 다음 M줄에 간선의 관계 시작정점 u와 도착정점 v가 주어집니다.
    * 여러 개의 정점으로 이동이 가능할 때 정점의 번호가 더 작은 쪽을 먼저 방문한다고 가정을 하겠습니다. 
    * 이 때, 정점 1에서 깊이 우선 탐색을 하게 된다고 합시다.
    *
    * ##출력## 
    * 입력에 따른 깊이 우선 탐색 결과(DFS)를 출력합니다. 
    */

    static boolean edge[][];  //정점 및 간선 집합. 
    static boolean visited[]; //방문 했는지 확인 
    static int n; 
    static int m; 
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in); 
      n = scanner.nextInt(); //정점의 개수 
      m = scanner.nextInt(); //간선의 개수 

      edge = new boolean[n+1][n+1]; 
      visited = new boolean[n+1]; 

      for (int i=0; i < m; i++) { //간선의 갯수 만큼 간선의 정점을 입력받음. (시작u,도착v)
        int u = scanner.nextInt(); // 간선 시작점. 
        int v = scanner.nextInt(); // 간선 도착점. 
        edge[u][v] = true; 
      }

      dfs(1); //dfs 시작점 지정. 

      scanner.close();

    }

    public static void dfs(int current) {
      visited[current] = true; 
      System.out.print(String.valueOf(current) + " ");
      for (int i=1; i<=n; i++) {
        if (visited[i] || !edge[current][i]) continue;  // 방문(탐색)안했고 길이 뚫려있으면 if(false || !true) 로 새 dfs탐색. 
        dfs(i);
      }
      //위 dfs함수의 디버깅. 
      //visited[1] || !edge[1][1]
      //visited[2] false || !edge[1][2] false  -> dfs(2)  1 -> 2

      //visited[1] true || !edge[2][1] 
      //visited[2] true 
      //visited[3] false || !edge[2][3] false -> dfs(3) > 2-> 3

      //visited[1] true || !edge[3][1] 
      //visited[2] true 
      //visited[3] true 
      //visited[4] false || !edge[3][4] true 
      //visited[5] false || !edge[3][5] false -> dfs(5)  3 -> 5
      
      //visited ....
    }
}