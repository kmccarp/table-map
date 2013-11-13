import java.util.Map;
import java.util.HashMap;

public class TableMap<Row, Col, Content> {
  
  private Map<Row, Integer> rows;
  private Map<Col, Integer> cols;
  private Content[][] table;
  
  public TableMap(Collection<Row> rowCollection, Collection<Col> columnCollection)
  {
    rows = new HashMap<>();
    int c = 0;
    for(Row row : rowCollection) {
      rows.put(row, c++);
    }
    
    cols = new HashMap<>();
    c = 0;
    for (Col col : columnCollection) {
      cols.put(col, c++);
    }
    
    table = new Content[rowCollection.size()][colCollection.size()];
  }
  
  public void set(Row row, Col col, Content val) {
    table[rows.get(row)][cols.get(col)] = val;
  }
  
  public void get(Row row, Col col) {
    return table[rows.get(row)][cols.get(col)];
  }
}
