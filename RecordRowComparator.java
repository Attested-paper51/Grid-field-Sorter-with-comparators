package Sorter;
import java.util.Comparator;

/** Trivial implementation of a simple comparator.
  * This one ALWAYS compares Records against records, so no generics futzing.
  *
  * This Comparator is based solely on the row or height length of the 'key' string.
  */
public class RecordRowComparator implements Comparator<Record> {
  /**This ensures the 'shorter' Record (i.e. the one with the key of lesser
    * length) is indicated. If two records of keys of equal length, neither
    * is favoured.
    */
  public int compare(Record a, Record b) {
    if (a.getRow() < b.getRow())
    {
      System.out.println(a.getRow() + " < " + b.getRow());
      return -1;
    }
    else if (a.getRow() > b.getRow())
    {
      System.out.println(a.getRow() + " > " + b.getRow());
      return 1;
    }
    System.out.println(a.getRow() + " = " + b.getRow());
    return 0;
  }
}
