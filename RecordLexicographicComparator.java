package Sorter;
import java.util.Comparator;
/**
 * A more detailed version of RecordLexicographicComparator.java given in
 * sample.zip
 * Used to Compare 2 Record Objects based of their ASCII value
 * for ex: this comparater will find out if "key1: a" is greater than "key2: A" - it is, so the number +1 will be returned
 */
public class RecordLexicographicComparator implements Comparator<Record> {
  public int compare (Record first, Record second) {
    String key1 = first.getKey();
    String key2 = second.getKey();
    
    int result = key1.compareTo(key2);  //the important line!
    
//result is 0 if key1 == key2, for example: f == f
//result is negative if key1 < key2, for example: a < z
//result is positive if key1 > key2, for example: c > b
    if(result == 0){
      System.out.println(key1 + " = " + key2);
      return 0;//they are the same
    }else if (result < 0){
      System.out.println(key1 + " < " + key2);
      return -1;// key1 is smaller than key2
    }else{
      System.out.println(key1 + " > " + key2);
      return +1;// key1 is larger than key2
    }
  }
}