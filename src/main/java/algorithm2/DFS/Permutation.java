package algorithm2.DFS;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

  public static void main(String[] args) {
    List<String> arr = new ArrayList<>(); 
    arr.add("a");
    arr.add("b");
    arr.add("c"); 

    List<String> result = new ArrayList<>(); 
    recursive(arr, result, arr.size(), 2); //기준리스트, 결과담아줄 리스트, 전체 갯수 , 뽑을 갯수 (nPr)

  }

  private static void recursive(List<String> arr, List<String> result, int n, int r) {
    
    if (r == 0) {
      System.out.println(result.toString());
      return; 
    }

    for (int i=0; i<n; i++) {
      result.add(arr.remove(i));
      recursive(arr, result, n-1, r-1);
      arr.add(i, result.remove(result.size() -1 ));
      //arr.add(0, result.remove(result.size() -1))
      //arr.add(1, result.remove(result.size() -1))
      //arr.add(2, result.remove(result.size() -1))
    }
    
    //i =0  
    /**
     * arr= ["a","b","c"];
     * result = []; 
     * 
     * arr= ["b","c"];
     * result = ["a"]
     * 
     * recursive(arr, result, 2, 1); 
     * 
     * arr=["b","c"]
     * result=["a"]
     * 
     * 
     * 
     * arr=["c"]
     * result=["a","b"]
     * 
     * arr=["b"]
     * result=["a","c"]
     * 
     * arr=["c"]
     * result=["a","b"]
     * 
     * recursive(arr, result, 1, 0)
     * syso[a,b] 
     * 
     * 
     * 
     * 
     */
  }

}