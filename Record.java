package Sorter;

/**Record Object
  */
public class Record {
  private String key;
  private int row, col;
  
  public Record(String alphabet, int row, int col) {
    key = alphabet;
    this.row = row;
    this.col = col;
  }
  
  //Returns String key
  public String getKey() 
  {
    return key;
  }
  
  //returns integer row
  public int getRow() {
    return row;
  }
  
  //returns integer column
  public int getCol() {
    return col;
  }
  
}