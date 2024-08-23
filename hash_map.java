import java.util.*;

public class hash_map {
      public static void main(String args[]) {
            HashMap<String, Integer> map = new HashMap<>();

            // insert key-value apir
            map.put("India", 130);
            map.put("us", 30);
            map.put("china", 150);
            // prints unodered map content
            System.out.println(map);

            // search
            if (map.containkey("India")) {
                  System.out.println("key found ");
            } else {
                  System.out.println("key does not present ");
            }

            // iteration
            // for(int val:arr)
            for (Map.Entry<String, Intiger> e : map.entrySet()) {
                  System.out.print(e.getKey());
                  System.out.println(e.getValue());
            }

            //store all key in a set
            Set<String> keys=map.keySet();
            for(String key:keys){
                  System.out.println(key +" "+map.get(key));
            }

            //remove
            map.remove("china");
            System.out.println(map);

      }

}
