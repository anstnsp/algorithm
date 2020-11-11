package algorithm2.queuestack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 문제 설명 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 * 
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에
 * 있는 기능이 배포될 때 함께 배포됩니다.
 * 
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가
 * 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한 사항 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다. 작업 진도는 100 미만의 자연수입니다. 작업
 * 속도는 100 이하의 자연수입니다. 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이
 * 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다. 입출력 예 progresses speeds return
 * [93, 30, 55] [1, 30, 5] [2, 1] [95, 90, 99, 99, 80, 99] [1, 1, 1, 1, 1, 1]
 * [1, 3, 2] 입출력 예 설명 5 10 1 1 20 1 / 입출력 예 #1 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이
 * 가능하므로 7일간 작업 후 배포가 가능합니다. 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후
 * 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다. 세 번째
 * 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 * 
 * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
 * 
 * 입출력 예 #2 모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일,
 * 1일입니다. 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
 * 
 * 따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
 */
public class FunctionDevelop {

  // q = 7, 3 , 9 
  /**
   * prevFunc = 7 
   * numOfFuncs = 1 
   * curFunc = 3 
   * 
   * numOfFunc = 2 
   * 
   * curFunc = 9 
   * list [2]
   * 
   * @param args
   */
  public static void main(String[] args) {
    //테스트케이스1 
    // int[] progresses = {93, 30, 55}; //배포되야하는 순서대로 작업의 진도가 적힌 배열 
    // int[] speeds = {1, 30, 5};   //작업의 개발 속도가 적힌 배열    // 2, 1 

    //테스트케이스2
    int[] progresses = {95, 90, 99, 99 , 80, 99};
    int[] speeds = {1, 1, 1, 1, 1, 1};            // 1 3 2 
    int[] answer= solution(progresses, speeds); 


  } //main

  /**
   * 1)먼저 각 작업이 완료 될때 까지의 일수를 구한다. 
   * 2)배포를 할 때 앞의 기능이 완료가 되야 뒷기능도 배포가 가능 하므로 맨 앞기능이 완료될 때 까지의 작업일수보다 더 높은 작업일수가 나올때까지의 갯수를 구한다. 
   * 3)2를 완료했으면 다시 더 높은 작업일수가 첫번째 기능이 되고 2번을 반복한다. 
   * 
   * ex) 1)각 작업이 완료될때 까지 일수 [7, 3, 9]
   *     2)첫 기능이 완료될때 보다 더 걸리는 기능의 일수는 9이므로 7일째에 7,3일이 걸리는 0,1 인덱스의 일 2개를 배포한다. 
   *     3) 나머지 9를 배포.  최종 -> (2,1)
   * 
   */

   //남이 푼거 
   public static int[] solution(int[] progresses, int[] speeds) {
     Queue<Integer> queue = new ConcurrentLinkedDeque<>(); 
     for (int i=0; i<progresses.length; i++) {
       queue.add(
         (100-progresses[i]) % speeds[i] == 0 ?
         (100-progresses[i]) / speeds[i] : 
         (100-progresses[i]) / speeds[i] + 1
       );
     }//for 

     ArrayList<Integer> list = new ArrayList<>(); 
     int prevFunc = queue.poll(); 
     int numOfFuncs = 1; //배포되는 일자에 몇개의 기능이 배포되는지를 의미. 
     while(!queue.isEmpty()) {
       int curFunc = queue.poll(); 
       if(prevFunc >= curFunc) {
         numOfFuncs++;
       } else {
         list.add(numOfFuncs);
         numOfFuncs=1; 
         prevFunc = curFunc; 
       }
     } //while 
     list.add(numOfFuncs);
     
     int[] answer = new int[list.size()];
     for (int i =0; i<list.size(); i++) {
       answer[i] = list.get(i);
       System.out.println(answer[i]);
     }
     return answer; 
   } //solution 

   //내가 푼거 
  // public static int[] solution(int[] progresses, int[] speeds) {
  //   //풀이시작 20201111 오후1시4분 
  //   // 한번에 정답!! 20201111 오후 2시 30분.... 1시간 20분 걸림 ㅅㅂ  
  //   List<Integer> list = new ArrayList<>(); 
  //   Queue<Integer> q = new LinkedList<>(); 

  //   for (int i=0; i<progresses.length; i++) {  //1)먼저 각 작업이 완료 될때 까지의 일수를 구한다. 
  //     int cnt = 0; 
  //     while (progresses[i] < 100) {
  //       progresses[i] += speeds[i]; 
  //       cnt ++; 
  //     }
  //     System.out.println("cnt:"+ cnt);
  //     q.offer(cnt);
     
  //   }// 1) 끝 

  //   int start = q.poll();     
  //   int end = q.poll(); 
  //   int count = 1; 
  //   for (int i=0; i<progresses.length-1; i++) {    
  //     if (start >= end)  {
  //       count++; 
  //       if (q.size() == 0) {
  //         list.add(count); 
  //         break; 
  //       } else {
  //         end = q.poll();
  //       }
  //     } else {
  //       list.add(count);
  //       if (q.size() == 0) {
  //         System.out.println("q.size():"+q.size() + "  ,i "+i + "  count:"+ count);
  //         list.add(1); 
        
  //       } else {
          
  //         count = 1; 
  //         start = end; 
  //         end = q.poll();
  //       }

  //     }
  //   }
  //   System.out.println(list.toString());
  //   int[] answer = new int[list.size()]; 

  //   for (int i=0; i<answer.length; i++) {
  //     answer[i] = list.get(i);
  //     System.out.println(answer[i]);
  //   }

  //   return answer;
  // } //solution end 

}





