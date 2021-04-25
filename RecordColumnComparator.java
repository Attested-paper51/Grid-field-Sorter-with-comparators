package Sorter;
import java.util.Comparator;

/** Trivial implementation of a simple comparator.
  * This one ALWAYS compares Records against records, so no generics futzing.
  *
  * This Comparator is based solely on the column or width length of the 'key' string.
  */
public class RecordColumnComparator implements Comparator<Record> {
  /**This ensures the 'shorter' Record (i.e. the one with the key of lesser
    * length) is indicated. If two records of keys of equal length, neither
    * is favoured.
    */
  public int compare(Record a, Record b) {
    if (a.getCol() < b.getCol())
    {
      System.out.println(a.getCol() + " < " + b.getCol());
      return -1;
    }
    else if (a.getCol() > b.getCol())
    {
      System.out.println(a.getCol() + " > " + b.getCol());
      return 1;
    }
    System.out.println(a.getCol() + " = " + b.getCol());
    return 0;
  }
}
