package algorithm2.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS1 {

  /**
   * https://www.codeground.org/common/popCodegroundNote
   * BFS(Breadth-Frist Search, 너비 우선 탐색)
   * 너비 우선 탐색은 그래프의 모든 정점들을 특정한 순서에 따라 방문하는 알고리즘 중 하나입니다. 
   * 현재 정점과 인접한 간선들을 검사하다가 방문하지 않은 정점들을 발견하면 그 간선을 통해 방문하지 않은 정점들을 자료구조 큐에 넣습니다. 
   * 그리고 큐의 front 정점을 방문하고 pop합니다.
   * 또 해당 정점에서 인접한 간선을 검사해 방문하지 않은 정점들을 큐에 넣고 방문하기는 과정을 반복하다가 더 이상 방문할 수 있는 정점이 없으면 종료합니다. 
   * 이러한 과정을 반복하여 큐에 더 이상 정점이 존재하지 않을 때까지 실행하여 그래프의 모든 정점을 방문하는 알고리즘이 BFS 알고리즘입니다.
   * 
   * 해당 알고리즘을 구현하기 위해서는 해당 정점이 방문되었는지 확인하는 boolean타입의 1차원 배열과 정점들의 집합 그리고 정점과 정점 사이의 연결을 확인할 수 있는 간선 집합들이 필요합니다.
   * 해당 알고리즘의 시간복잡도는 모든 정점을 방문하며 모든 간선을 검사하기 때문에 시간복잡도는 O(V+E)입니다. ( V: 정점의 개수, E: 간선의 개수)
   * 
   * (DFS는 현재 정점과 인접한 간선들을 검사하다가 방문하지 않은 정점들을 발견하면 그 간선을 통해 방문하지 않은 정점으로 이동). 
   * 
   */

   /**
    * 문제
    * ##입력## 
    * 첫 줄에 정점의 개수 N과 간선의 개수 M이 주어집니다.
    * 다음 M줄에 간선의 관계 시작정점 u와 도착정점 v가 주어집니다.
    * 여러 개의 정점으로 이동이 가능할 때 정점의 번호가 더 작은 쪽을 먼저 방문한다고 가정을 하겠습니다. 
    * 이 때, 정점 1에서 너비 우선 탐색을 하게 된다고 합시다.
    *
    * ##출력## 
    * 입력에 따른 너비 우선 탐색 결과(DFS)를 출력합니다. 
    */

    static boolean edge[][];  //정점 및 간선 집합. 
    static boolean visited[];  //방문 확인
    static int n;  // 정점개수
    static int m;  // 간선개수
 
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in); 
      System.out.println("정점의 개수 와 간선의 개수를 입력하세요. ex)7 11");
      n = scanner.nextInt(); 
      m = scanner.nextInt(); 
      edge = new boolean[n+1][n+1]; 
      visited = new boolean[n+1];  

      System.out.println("입력할 간선 :"+ m +"개");
      for (int i=0; i<m; i++) {    //간선의 개수 만큼 간선의 정점을 입력받음. (시작u,도착v)
        System.out.println("간선의 시작점과 도착점을 정해주세요. ex)1 2");
        int u = scanner.nextInt(); 
        int v = scanner.nextInt(); 
        edge[u][v] = true; 
      }
      scanner.close();
      bfs(1);
    }

    public static void bfs(int current) {
      Queue<Integer> q = new LinkedList<>(); 
      visited[current] = true; 
      q.add(current); 
      
      while (!q.isEmpty()) {
        int here = q.remove(); 
        System.out.print(String.valueOf(here) + " ");
        for (int there = 1; there <= n; there++) {
          if (visited[there] || !edge[here][there]) continue; 
          visited[there] = true; 
          q.add(there); 
        }
      }

    }
}