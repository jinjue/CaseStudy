package pojo;

import java.util.ArrayList;
import java.util.List;

public class MyGraph {
   public List<List<Integer>> list;
   public List<Integer> head;
   public int num;
   public int Vnum;
   public MyGraph(int max){
       super();
       this.list = new ArrayList<List<Integer>>();
       this.head = new ArrayList<Integer>();
       while(max>0){
           list.add(new ArrayList<Integer>());
           max--;
       }
   }

}
