package algorithm2.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 문제 설명 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로
 * 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 
 * 1)속한 노래가 많이 재생된 장르를 먼저 수록합니다. 
 * 2)장르 내에서 많이 재생된 노래를 먼저 수록합니다. 
 * 3)장르 내에서 재생 횟수가
 * 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를
 * 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를
 * 완성하세요.
 * 
 * 제한사항 genres[i]는 고유번호가 i인 노래의 장르입니다. plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다. genres와
 * plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다. 장르 종류는 100개 미만입니다. 장르에 속한 곡이 하나라면, 하나의
 * 곡만 선택합니다. 모든 장르는 재생된 횟수가 다릅니다.
 * 
 * 입출력 예 genres plays return [classic, pop, classic, classic, pop] [500, 600,
 * 150, 800, 2500] [4, 1, 3, 0]
 * 
 * 입출력 예 설명 classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 * 
 * 고유 번호 3: 800회 재생 고유 번호 0: 500회 재생 고유 번호 2: 150회 재생 pop 장르는 3,100회 재생되었으며, pop
 * 노래는 다음과 같습니다.
 * 
 * 고유 번호 4: 2,500회 재생 고유 번호 1: 600회 재생 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의
 * [3, 0]번 노래를 그다음에 수록합니다.
 * 
 * 
 * ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 * 
 */
public class BestAlbum {
  //풀이 2020/11/09 14:41 
  public static void main(String[] args) {
    String[] genres = {"classic",  "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};  

    int[] answer = solution(genres, plays);

    for (int val : answer) {
      System.out.println(val);
    }

  }

  public static int[] solution(String[] genres, int[] plays) {
    // 1)속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    // 2)장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    // 3)장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    // int[] answer = {};
    
    // String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    // int[] plays = {500, 600, 150, 800, 2500};  
    //다시풀기 시작 11월 9일 오후 7시 15분 
    // 끝... 오후 7시 46분.. 
    Map<String, Integer> sumMap = new TreeMap<>(); 
    Map<String, List<Integer>> genreMap = new TreeMap<>();  
    List<Integer> sumList = new ArrayList<>(); 
    List<Integer> result = new ArrayList<>(); 

    for (int i=0; i<genres.length; i++) {
      sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i] ); //장르별 재생의 합을 구함. 
      
      
    } //for end (장르별 재생 합)

    for (Entry<String, Integer> entry : sumMap.entrySet()) {
      System.out.println("key:"+entry.getKey() +"  value:"+entry.getValue());
      sumList.add(entry.getValue()); //장르별 합계의 정렬을 위해 만듬. 
      List<Integer> list = new ArrayList<>(); 
      for (int i=0; i<genres.length; i++) {
        if (genres[i].equals(entry.getKey())) {
         
          list.add(plays[i]); 
        }
      } //for end (각 장르별 점수 모으기)
      genreMap.put(entry.getKey(), list); 

    } //for end (entry)  

    System.out.println(genreMap.get("classic"));
    System.out.println(genreMap.get("pop"));
  
    //먼저 속한 노래가 젤 많이 재생된 장르 뽑아냄. 
    sumList.sort((a,b) -> b.compareTo(a));
    System.out.println(sumList);

    for (Integer sum : sumList) { //장르에서 재생횟수 젤 많은 장르 
      List<Integer> list = new ArrayList<>(); 
      int cnt = 0; 
      for (Entry<String, Integer> entry : sumMap.entrySet()) { //여기서는 장르안에서 재 생이 젤 많은 곡. 
        if (entry.getValue().equals(sum)) { //장르중에 가장 높은애  2)장르 내에서 많이 재생된 노래를 먼저 수록합니다.
          list = genreMap.get(entry.getKey());  //classic : 500 150 800 , pop : 600 ,2500, 2500
          list.sort((a,b) -> b.compareTo(a)); //내림차순 정렬 
          System.out.println("정렬된 리스트:"+list);
          
        
        } //if 문 
        
      }//장르 내에서 많이 재생된 곡으로 내림차순 정렬. 

      for (int i=0; i<list.size(); i++) { //list :2500 2500 600 
        if (cnt ==2)break; 
        for (int j=0; j<plays.length; j++) {
          if (list.get(i).equals(plays[j])) {
            if (result.contains(j)) continue;    // 3)장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. 만약 2500 2500 600 
            result.add(j);
            cnt++; 
          }
        }
      }  
    
    } //최종 for 끝 
    int[] answer = new int[result.size()]; 
    for (int z=0; z<result.size(); z++) {
      answer[z] = result.get(z); 
    }
    System.out.println(result);
    return answer;
  }//solution end 
}
