import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.lang.reflect.Array;

public class TableMap<Row, Col, Content> {
  
  private Map<Row, Integer> rows;
  private Map<Col, Integer> cols;
  private Content[][] table;
  private Class<? extends Content> contentClass;
  
  public TableMap(Collection<Row> rowCollection, Collection<Col> columnCollection, Class<? extends Content> contentClass)
  {
    this.contentClass = contentClass;

    rows = new HashMap<Row, Integer>();
    int c = 0;
    for(Row row : rowCollection) {
      rows.put(row, c++);
    }
    
    cols = new HashMap<Col, Integer>();
    c = 0;
    for (Col col : columnCollection) {
      cols.put(col, c++);
    }
    table = (Content[][]) Array.newInstance(contentClass, rowCollection.size(), columnCollection.size());
  }
  
  public void set(Row row, Col col, Content val) {
    table[rows.get(row)][cols.get(col)] = val;
  }
  
  public Content get(Row row, Col col) {
    return table[rows.get(row)][cols.get(col)];
  }
}
