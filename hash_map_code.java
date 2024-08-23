import java.util.*;

public class hash_map_code {
      static class HashMap<k, v> {
            private class Node {
                  k key;
                  v value;

                  public Node(k key, v value) {
                        this.key = key;
                        this.value = value;
                  }
            }

            private int n;// total nodes
            private int N;// totall bucket size
            // define bucket in the form of array of linked list
            private LinkedList<Node> buckets[];

            @SuppressWarnings("unchecked")
            public HashMap() {
                  this.N = 4;
                  this.buckets = new LinkedList[4];
                  for (int i = 0; i < 4; i++) {
                        this.buckets[i] = new LinkedList<>();
                  }
            }

            private int hashFunctions(k key) {// returns bucket index
                  int bi = key.hashCode();// this key can returns positive and negative

                  return Math.abs(bi) % N;// to put range(from 1 to N-1 )
            }

            private int searchInLL(k key, int bi) {
                  LinkedList<Node> ll = buckets[bi];
                  int di = 0;
                  for (int i = 0; i < ll.size(); i++) {
                        if (ll.get(i).key == key) {
                              return i;// this is di
                        }
                  }
                  return -1;
            }

            @SuppressWarnings("unchecked")
            private void rehashing() {
                  LinkedList<Node> oldbucket[] = buckets;
                  buckets = new LinkedList[N * 2];

                  for (int i = 0; i < N * 2; i++) {
                        buckets = new LinkedList[n * 2];// to initialize linkedlist of the bucket
                  }

                  for (int i = 0; i < oldbucket.length; i++) {
                        LinkedList<Node> ll = oldbucket[i];
                        for (int j = 0; j < ll.size(); j++) {
                              Node node = ll.get(j);
                              put(node.key, node.value);
                        }
                  }
            }

            public void put(k key, v value) {
                  int bi = hashFunctions(key);
                  int di = searchInLL(key, bi);
                  if (di == -1) {// key does not exist
                        buckets[bi].add(new Node(key, value));
                        n++;
                  } else// key exists{
                  {
                        Node node = buckets[bi].get(di);
                        node.value = value;
                  }
                  double lambda = (double) n / N;
                  if (lambda > 2.0) {
                        // rehashing
                        rehashing();
                  }
            }

            public boolean containsKey(k key) {
                  int bi = hashFunctions(key);
                  int di = searchInLL(key, bi);
                  if (di == -1) {// key does not exist
                        return false;
                  } else// key exists{
                  {
                        return true;
                  }
            }

            public v remove(k key) {
                  int bi = hashFunctions(key);
                  int di = searchInLL(key, bi);
                  if (di == -1) {// key does not exist
                        return null;
                  } else// key exists{
                  {
                        Node node = buckets[bi].remove(di);
                        return node.value;
                  }
            }

            public ArrayList<k> keyset() {
                  ArrayList<k> keys = new ArrayList<>();
                  for (int i = 0; i < buckets.length; i++) {
                        LinkedList<Node> ll = buckets[i];
                        for (int j = 0; j < ll.size(); j++) {
                              Node node = ll.get(j);
                              keys.add(node.key);
                        }
                  }
                  return keys;
            }

            public boolean isEmpty() {
                  return n == 0;
            }

            public v get(k key) {
                  int bi = hashFunctions(key);
                  int di = searchInLL(key, bi);
                  if (di == -1) {// key does not exist
                        return null;
                  } else// key exists{
                  {
                        Node node = buckets[bi].get(di);
                        return node.value;
                  }

            }

      }

      public static void main(String[] args) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("India", 190);
            map.put("china", 120);
            map.put("us", 100);
            map.put("uk", 150);

            ArrayList<String> keys = map.keyset();
            for (int i = 0; i < keys.size(); i++) {
                  System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
            }
            map.remove("India");
            System.out.println(map.get("India"));
      }
}
