package algorithm2.queuestack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Predicate;

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
 * [1, 3, 2] 입출력 예 설명 입출력 예 #1 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후
 * 배포가 가능합니다. 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만
 * 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다. 세 번째 기능은 55%가 완료되어 있고
 * 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 * 
 * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
 * 
 * 입출력 예 #2 모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일,
 * 1일입니다. 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
 * 
 * 따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
 */
public class FunctionDevelop {

  public static void main(String[] args) {
    Stream.of("d2", "a2", "b1", "b3", "c")
    .map(s -> {
        System.out.println("map: " + s);
        return s.toUpperCase();
    })
    .anyMatch(s -> {
        System.out.println("anyMatch: " + s);
        return s.startsWith("A");
    });
    //antMatch는 주어진 입력에 대해 Predicate가 만족되면 true를반환한다. 
    //두번째 원소가 A2를 전달했으므로 위의 anyMatch는 참이다. 
    //스트림 연결은 수직적으로 수행하기 때문에 map은 이경우 두번만 실행된다. 
    //따ㅓ라서 스트림의 모든 원소를 사상하는 것 대신, map은 최대한 적게 실행된다. 

    //A2 
    List<Person> persons = Arrays.asList(
          new Person("Max", 18),
          new Person("Peter", 23),
          new Person("Pamela", 23),
          new Person("David", 12)
          );

    System.out.println(persons);
    List<Person> filteredList = persons.stream().
                                  filter(p -> p.name.startsWith("P"))
                                  .collect(Collectors.toList());

    System.out.println(filteredList);
    Function<Person, String> standard = person -> {
      if( person.getAge() >= 10 && person.getAge() < 20) return "10대";
      else return "20대"; 
    };

    TreeMap<String, List<Person>> treeMap = persons.stream().collect(Collectors.groupingBy(standard, TreeMap::new, Collectors.toList()));
    treeMap.forEach((key, value) -> System.out.format("key : %s, value: %s  \n", key, value));
    // Map<Integer, List<Person>> personsByAge = persons.stream()
    //                                         .collect(Collectors.groupingBy(p -> p.age));
    //                                         // .collect(groupingBy);
                                                               
                                      
    // personsByAge.forEach((age,p) -> System.out.format("age %s: %s\n", age, p));

  } //main

}

class Person {
  String name;
  int age;

  Person(String name, int age) {
      this.name = name;
      this.age = age;
  }

  String getName() {
    return this.name;
  }

  int getAge() {
    return this.age; 
  }

  @Override
  public String toString() {
      return name;
  }
}

class Fruit{
  private String name;
  private String color;

  Fruit(String name, String color){
      this.name = name;
      this.color = color;
  }

  String getName(){
      return this.name;
  }

  String getColor(){
      return this.color;
  }


}

