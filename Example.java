import java.util.Collection;
import java.util.Arrays;

public class Example {
  public static void main(String[] args) {
    
    
    Collection<Integer> ints = Arrays.asList({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
    TableMap<Integer, Integer, Integer> multiplicationTable = new TableMap<Integer, Integer, Integer>(ints, ints, Integer.class);
    for(Integer integ : ints) {
      for (Integer integ2 : ints) {
        multiplicationTable.set(integ, integ2, integ * integ2);
      }
    }
    
    System.out.println(multiplicationTable.get(12, 12) + " = 144");
  }
}
