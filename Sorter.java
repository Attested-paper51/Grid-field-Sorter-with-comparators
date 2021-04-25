package Sorter;
import java.io.*;
import java.lang.*;
import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions
import java.util.Comparator;

/*<Name: Muhammed Bilal>
 * <Date: 2021/04/09>

  * This assignment demonstrates the usage of multiple comparators for sorting algorithms.
  * @see RecordColumnComparator
  * @see RecordRowComparator
  * @see RecordLexicographicComparator
  * @see Record.java
  */
public class Sorter
{
  //variables
  private ASCIIOutputFile out; //to display into a .txt file
  private ASCIIDataFile in;  //to read from a .txt file
  int size, row, col;
  char letter;
  
  //Constructor
  /*
   * reads the size (16) - to determine the size of the Record 1D array
   * 1) reads the height and width of each gridfield
   * 2) reads single char of each gridfield
   * 3) inserts 1) and 2) inside each index of the Record Object - data[i]
   * 4) Starts the Selection Sorting algorithm based on:
   *  - Alphabet ASCII value - uses RecordLexicographicComparator()
   *  - then Heigth (Row) length - uses RecordRowComparator()
   *  - then Width (Column) length - uses RecordColumnComparator()
   * 5) prints out the resulting Record array - all fully sorted
   *   - end result: a gridfield with the widths sorted out
   * */
  public Sorter()
  {
    in = new ASCIIDataFile();  //selects .txt file to read from
    out = new ASCIIOutputFile("gridfields7Result.txt");  //selects .txt file to print on
    String line = in.readLine();
    size = Integer.parseInt(line);  //read the size of the Record array
    System.out.println(size);
    Record[] data = genData(size);
    SelectionSort(data, new RecordLexicographicComparator(), size);
    SelectionSort(data, new RecordRowComparator(), size);
    SelectionSort(data, new RecordColumnComparator(), size);
    for (int i=0; i<data.length; i++)
    {
      out.writeInt(data[i].getCol());
      out.writeInt(data[i].getRow());
      out.writeString(data[i].getKey());
      out.newLine();
    }
  }
  
  //methods
  /*
   * Puts the alphabet, heigth, width of every gridfield in each index of data [i]
   * Prints the gridfields to check if the heigth and width are implemented correctly
   * */
  private Record[] genData(int size) {
    Record[] data = new Record[size];
    for (int i=0; i<data.length; i++)
    {
      in.readLine();
      getRC();
      letter = in.readC();
      System.out.print((int)letter);
      String alphabet = Character.toString(letter);
      System.out.println(alphabet);
      data[i] = new Record(alphabet, row, col);
      for(int j=0; j<row; j++)
      {
        String s = in.readLine();
        System.out.println(s);
        System.out.println("moves to next line");
      }
    }   
    return data;
  }
  
  /*
   * Gets the height (row) and width (col) of each gridfield
   * */
  private void getRC()
  {
    String s;
    String l1, l2;
    
    s = in.readLine();
    
    //row
    if(s.charAt(1) == (char)9)  //if the row number is only 1 digit:
    {
      l2 = s.charAt(0) + "";  // then access the 1st number in the String "line" - represents the row of each gridfield
      //column
      l1 = s.charAt(2) + "";  //accesses the 1st and 2nd number in the String "line" - represents the column of each gridfield
      row = Integer.parseInt(l1);  //converts l1 (column) into an integer var.
      System.out.println("Row: " + row);
    } 
    //row
    else
    {
      l2 = s.charAt(0) + "" + s.charAt(1);  //if the row number is 2 digits: then access the 1st AND 2nd numbers in the String "line"
      //column
      l1 = s.charAt(3) + "";  //accesses the 1st and 2nd number in the String "line" - represents the column of each gridfield
      row = Integer.parseInt(l1);  //converts l1 (column) into an integer var
      System.out.println("Row: " + row);
    }  
    col = Integer.parseInt(l2);  //converts l2 (row) into an integer var.
    System.out.println("Column: " + col);
  }
  
  /*
   * Sorts all of the gridfields inside of Record array - data[i]
   * Uses Selection Sort
   * @param the Record array - data
   * @param any of the 3 comparaters that needs to be used to compare 2 Record Objects
   * @param size of the Record array - data - 16
   * */
  private void SelectionSort(Record[] data, Comparator<Record> cmp, int size) {
    Record swp;
    int smallPos;
    int i, j;
    
    for(i = 0; i<size - 1; i++)
    {
      smallPos = i;
      for(j = i+1; j<size; j++)
      {
        if(cmp.compare(data[j], data[smallPos]) < 0) 
        {
          smallPos = j;
        }
      }
      swp = data[smallPos];
      for(j = smallPos; j>i; j--)
      {
        data[j] = data[j - 1];
      }
      data[i] = swp;
    }
  }
  
  public static void main(String[] args)
  {
    new Sorter();
  }
} //COSC 1P03 