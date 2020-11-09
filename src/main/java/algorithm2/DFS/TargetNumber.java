package algorithm2.DFS;

import java.util.Scanner;

/**
 * 문제 설명
  n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 
  숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

  -1+1+1+1+1 = 3
  +1-1+1+1+1 = 3
  +1+1-1+1+1 = 3
  +1+1+1-1+1 = 3
  +1+1+1+1-1 = 3
  사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 
  타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

  제한사항
  - 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
  - 각 숫자는 1 이상 50 이하인 자연수입니다.
  - 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
  
  입출력 예
  numbers	        target	return
  [1, 1, 1, 1, 1]	  3	      5

 */
/**
 * 1)일단 배열을 모두 순회해야함... 
 * 2)첫번째 방문한 곳은 무조건 더하고 결과 비교 
 * 3)두번째 방문한 곳부터는 더할지 뺄지 결정. 
 */


public class TargetNumber {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); 
    int n = scanner.nextInt(); //n개의 음이아닌 정수 (number를 구성)
    int[] number = new int[n];
    boolean[] visited = new boolean[n]; 
    System.out.println("배열을 구성할 숫자 "+ n +"개를 입력.");
    for (int i=0; i<n; i++) {
      
      number[i] = scanner.nextInt(); 
    }
    System.out.println("타켓 값 입력해주세요");
    int target = scanner.nextInt(); // number의 원소를 조합하여 만들 target값 . 

    scanner.close(); 

    int answer = solution(0, n, number, target); 
    System.out.println("이게 솔루션:"+ answer);
  } //main end 

  static int solution(int start,int end,  int[] number, int target) {
    int answer = 0; 
    
    int cnt = 0; 
    //00 01 02 03 04 05
    for (int z =0; z<end; z++) {
      int sum = 0;
      for (int i=start; i<end; i++) {
        sum += number[i]; 
        System.out.println("sum : "+ sum);
        // if (number[i] == target)
        if (sum == target && (end-(i+1)) % 2 == 0) {
          cnt += 1; 
          System.out.println("cnt :"+ cnt);
          continue; 
        } 
    
        
      }
    
    } 
    return cnt; 
    
    // if (number[start] == target) {
    //   for (int i=start+1; i<end; i++) {
    //     sum += number[i];
    //     cnt += 1;  
    //   }
    //   if (sum % target ==0 && cnt % 2 == 0) answer += 1; 
    // } else if (number[start] + number[start+1] == target) {
    //   for (int i=start+2; i<end; i++) {
    //     sum += number[i];
    //     cnt += 1; 
    //   }
    //   if (sum % target == 0 && cnt % 2 == 0) answer +=1 ;
    // }
    // System.out.println("answer : " + answer);
    // visited[start] = true; 

  }
  /**
   * 1 2 3 4 5 6 -> 3
   * //타겟의 공배수 이면서 나머지 원소들의 갯수가 짝수여야함. ? 
   */

}