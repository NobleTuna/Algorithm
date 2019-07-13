package lineS_3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MyCode2 {
	
   static ArrayList<Integer> removeIdx;

   static class Range implements Comparable<Range> {
      int start, end;

      public Range(int start, int end) {
         super();
         this.start = start;
         this.end = end;
      }

      @Override
      public String toString() {
         return "Range [start=" + start + ", end=" + end + "]";
      }

      @Override
      public int compareTo(Range r) {
         return start - r.start;
      }

   }

   public static void main(String[] args) throws java.lang.Exception {
      Scanner sc = new Scanner(System.in);

      ArrayList<Range> ranges = new ArrayList<>();
      removeIdx = new ArrayList<>();

      while (sc.hasNext()) {
         int start = sc.nextInt();
         int end = sc.nextInt();

         Range addRange = new Range(start, end);
         if (!merge(ranges, addRange)) {
            // 리턴값이 false면 머지가 안되고 범위가 추가된것.
            ranges.add(addRange);
         }

         Collections.sort(ranges);
      }

      for (Range range : ranges) {
         System.out.println(range.start + " " + range.end);
      }

   }

   private static boolean merge(ArrayList<Range> ranges, Range n) {
      // ranges 에 n가 추가되는 경우
      // 시작값 기준으로 들어갈곳을 찾고
      for (int i = 0; i < ranges.size(); i++) {
         Range r = ranges.get(i);
         if (r.start <= n.start && r.end >= n.start) {
            // n의 시작값이 r의 범위 안에 들어간다.
            // n의 끝값이 어디까지 들어갈지 정하자
            for (int j = i + 1; j < ranges.size(); j++) {
               // 방금 시작값 들어간 범위 다음 범위부터 검사
               Range nextRange = ranges.get(j);

               if (nextRange.start <= n.end) {
                  removeIdx.add(j); // j는 흡수된다.
                  n.end = Math.max(n.end, nextRange.end);
               } else {
                  // 시작값 기준으로 정렬된 리스트이기 때문에 그만해도 된다.
                  break;
               }
            }

            // 삭제할 범위들은 다 추가됐고 이제 방금 들어간 범위의 끝값을 바꿔주면된다.
            r.end = Math.max(r.end, n.end);
            removeAll(ranges);
            return true;
         }
      }
      return false;
   }

   private static void removeAll(ArrayList<Range> ranges) {
      Collections.sort(removeIdx);
      for (int i = removeIdx.size() - 1; i >= 0; i--) {
         ranges.remove(removeIdx.get(i));
      }
      removeIdx.clear();
   }
}