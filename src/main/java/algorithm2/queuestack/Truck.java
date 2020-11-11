package algorithm2.queuestack;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 문제 설명
    트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
    트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
    ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

    예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

    경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
      0	            []	          []	          [7,4,5,6]
    1~2	            []	          [7]	            [4,5,6]
      3	            [7]	          [4]	              [5,6]
    4	              [7]	          [4,5]	              [6]
    5	              [7,4]	        [5]	                [6]
    6~7	[7,4,5]	[6]	[]
    8	[7,4,5,6]	[]	[]
    따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

    solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

    제한 조건
    bridge_length는 1 이상 10,000 이하입니다.
    weight는 1 이상 10,000 이하입니다.
    truck_weights의 길이는 1 이상 10,000 이하입니다.
    모든 트럭의 무게는 1 이상 weight 이하입니다.
    입출력 예
    bridge_length	weight	truck_weights	                return
    2	              10	    [7,4,5,6]	                    8
    100	            100	      [10]	                      101
    100	            100	[10,10,10,10,10,10,10,10,10,10]	  110
 * 
 */
//2초 
public class Truck {

  public static void main(String[] args) {
    //테스트케이스1 
    int bridge_length = 2;
    int weight = 10 ; 
    int[] truck_weights = {7,4,5,6}; 

    //테스트케이스2 
    // int bridge_length = 100; 
    // int weight = 100 ; 
    // int[] truck_weights = {10}; 
    solution(bridge_length, weight, truck_weights);
  }

  public static int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    //풀이시작 20201111 오후4시28분 
    /**
     * 1)트럭을 큐에 넣음.
     * 2)다음 넣을 트럭과 현재 큐의 트럭들의 합이 최대하중을 넘지 않는다면 큐에 트럭을 추가. 
     * 2-1)만약 2가 아니라면 현재 큐에 있는 트럭이 최소 하나는 지나갈때 까지 기다려야함. 
     *  
     * 2)처음넣은 트럭과 다음 트럭무게의 합이 10보다 크면 처음 넣은 트럭이 지나갈때까지 기다린다.
     * 3)첫트럭이 다 지나갔으면 다음 트럭이 큐에 들어가고 자기다음꺼랑 또 10이넘는지 보고 10안넘으면 다음거도 큐에 들어감. 
     */
    Queue<Integer> queue = new ConcurrentLinkedQueue<>(); 
    int delay = 1;
    /**
     * bridge = [0 , 0]
     *  
     */
    for (int i=0; i<truck_weights.length; i++) {
      queue.offer(truck_weights[i]);
      if (i == truck_weights.length-1) {
        while(!queue.isEmpty()) {
          queue.poll(); 
          delay += bridge_length;
        }
        break; 
      }
    
      if (queue.peek() + truck_weights[i+1] < weight) {
        delay += 1; 
        queue.offer(truck_weights[i+1]);
      } else {
        delay += bridge_length; 
        queue.poll();
      }
    }
    System.out.println(delay);

    // delay : 1 -> 3 -> 4 
    
    // for (int i=0; i<truck_weights.length; i++) {  //7456
      
    //   queue.offer(truck_weights[i]);   
    //   if (truck_weights[i] + truck_weights[i+1] > 10) {
    //     delay += 2; 
    //   } else {
    //     delay += 1; 
    //     queue.offer(truck_weights[i+1]);
    //   }  // 5 4
    //   delay +=1 ;
    //   queue.poll();
      
    // } //for 
    System.out.println("delay:"+delay);

    return answer;
  }
}