package Softeer_강의실배정;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());

      /*
      System.out.println(N);
      */

      //강의들의 모음

      List<int[]> lectures = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        String[] input = br.readLine().split(" ");
          
        int start = Integer.parseInt(input[0]);
        int finish = Integer.parseInt(input[1]);

        lectures.add(new int[]{start, finish});        
        // System.out.println("시작시간 : "+start+", 종료시간 : "+finish);
      }

      // for (int[] i : lectures){
      //   System.out.println(Arrays.toString(i));
      // }

      //끝나는 시간 순으로 정렬
      Collections.sort(lectures, new Comparator<int[]>(){

        @Override
        public int compare(int[] o1, int[] o2){

          if (o1[1] != o2[1]){
            return o1[1]-o2[1];
          } else {
            return o2[0]-o1[0];
          }
          
        }
          
      });
      
      //배정된 강의 수를 카운트할 변수
      //첫 강의는 무조건 배정 가능하므로 1부터 시작
      int cnt = 1;
      //첫 강의를 배정했으므로
      //첫 강의의 종료시간이 현재 등록된 마지막 강의의 종료시간
      int lastTime = lectures.get(0)[1];

      for (int i = 1; i < N; i++){

        //종료시간 별로 정렬했기 때문에
        //이번에 집어넣을 강의 이후의 강의는 반드시 현재 종료시간 보다 이후에 종료하기 때문에
        //이후 넣는 강의의 강의시간이 
        //현재 강의시간이 더 짧다 하더라도 강의의 개수는
        //현재 강의시간을 넣는 것이 더 많은 강의를 집어넣을 수 있는 방법이다.
        //왜냐하면 최대한 종료시간을 작게 잡는 그리디한 생각이
        //가장 많은 강의를 배정할 수 있는 방법이기 때문이다.
        
        //강의의 시작시간이 마지막에 넣은 강의의 종료 시간과 같거나 이후라면
        //배정가능
        if (lectures.get(i)[0] >= lastTime){
          //강의실 배정
          cnt++;
          //마지막에 넣은 강의의 종료시간 갱신
          lastTime = lectures.get(i)[1];
        }
        
      }
      
      System.out.println(cnt); 
      
    }
}
