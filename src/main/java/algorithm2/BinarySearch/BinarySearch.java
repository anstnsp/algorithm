package algorithm2.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
 /**
   * https://www.codeground.org/common/popCodegroundNote
   * 이진탐색은 정렬된 배열에서 원하는 값을 시간복잡도 logN만에 찾아내는 탐색법이다. 
   * 처음 탐색 시 길이가 N인 배열에서 전체영역을 잡고 L=0, R=N-1 중앙값 M=(L+R)/2 로 잡고 
   * 찾고자 하는 K를 찾는다. 
   * 만약 M이 K보다 작다면 L=M+1 해주고 
   * M이 K보다 크다면 R=M-1 해준다. 
   * 위를 해를 찾기 까지 반복한다. while(L<=R) 까지. 
   */
  public static void main(String[] args) {
    Integer[] strArr = new Integer[]{-3, 0, 1, 4, 7, 9, 11, 16};
    System.out.println("strArr Length: "+ strArr.length);  

    System.out.println("strArr[0]:"+ strArr[0]);
    System.out.println("strArr[7]:"+ strArr[7]);


    Arrays.sort(strArr); //오름차순 정렬. 

    for (Integer i : strArr) {  //정렬이 잘 됐는지 확인. 
      System.out.println(i);
    }

    //찾고자하는 값 k= 11
    //중앙값 M  =  (L+R)/2  = (0+7) / 2 = 3.5
    //배열의 최초 L 값과 R 값을 정의

      int L = 0; //배열의 처음 
      int R = strArr.length -1; //배열의 끝 
      // int M = (L+R) / 2; //중앙값
      int k = 7; // 배열에서 찾고자 하는 값. 
      boolean answer = false; 
      int M =0;
      while (L <= R) {
        M = (L+R) / 2; 
        System.out.println("L : "+ L);
        System.out.println("R : "+ R);
        System.out.println("M : "+ M);
        if (strArr[M] == k) {
          answer = true; 
          break; 
        } else if ( strArr[M] < k ) { //만약 배열의 중앙값이 찾고하나는 해 보다 클 경우 L을 M+1 로 옮겨줌 
          L = M + 1; 
        } else if ( strArr[M] > k) { //배열의 중앙값이 해보다 작을 경우 R을 M -1 로 옮겨줌
          R = M - 1;
        } 
      }
  
      if(answer) {
        System.out.println("배열에서 찾고자하는 해의 인덱스 : "+ M + ",  찾는 해 :"+ k);
      } else {
        System.out.println("배열에 찾고자 하는 해가 없음. ");
      }
      
      /**
       * 위의 정적인 이진탐색을 동적 이진탐색으로 변경 
       * 배열의 크기 N , 찾고자 하는 값 K 를 입력받아 이진탐색을 진행. 
       */
      Scanner scanner = new Scanner(System.in); 
      System.out.println("만들 배열의 크기를 입력하세요(숫자)");
      int N = scanner.nextInt(); // 배열의 크기를 입력받음. 
      int[] arr = new int[N]; 
      System.out.println("배열의 값을 채워주세요.(입력한 길이만큼)");
      for (int i=0; i<N; i++) {
        arr[i] = scanner.nextInt(); //만든 배열에 값을 채움. 
      }
      Arrays.sort(arr); //배열을 오름차순 정렬. 
      System.out.print("정렬된 배열 >>  ");
      for (int val : arr) {
        System.out.print(val + ", "); //정렬확인 
      }
      int L2 = 0; 
      int R2 = arr.length - 1; 
      System.out.println();
      System.out.println("찾고자 하는 값을 입력하세요.");
      int K2 = scanner.nextInt(); //찾고자 하는 값 입력받음. 
      scanner.close();
      boolean answer2 = false; 
      int M2 = 0; 
      while (L2 <= R2) {
        M2 = (L2 + R2) / 2; 
        if (arr[M2] == K2) {
          answer2 = true; 
          break; 
        } else if (arr[M2] < K2) {
          L2 = M2 + 1; 
        } else if(arr[M2] > K2) {
          R2 = M2 - 1; 
        }
      }

      if (answer2) {
        System.out.println("해가 들어있는 인덱스 : "+ M2 + " 찾고자 하는 해 :"+ K2);
      } else {
        System.out.println("해당 배열에 찾고자 하는 해가 없음.");
      }
  }
  

  
}