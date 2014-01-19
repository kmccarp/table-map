package com.waffles.tablemap;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.lang.reflect.Array;

public class TableMap<Row, Col, Content>
{

    private Map<Row, Integer> rows;
    private Map<Col, Integer> cols;
    private Content[][] table;
    @SuppressWarnings("unused")
    private Class<? extends Content> contentClass;

    /**
     * Defines a table map. This is a two-key map. <br/>
     * Example:
     * 
     * <pre>
     *        1    2    3    4    5    6    7
     *      __________________________________
     *   9 |  9 | 18 | 27 | 36 | 45 | 54 | 63 |
     *     |----+----+----+----+----+----+----|
     *  10 | 10 | 20 | 30 | 40 | 50 | 60 | 70 |
     *     |----+----+----+----+----+----+----|
     *  11 | 11 | 22 | 33 | 44 | 55 | 66 | 77 |
     *     |----+----+----+----+----+----+----|
     *  12 | 12 | 24 | 36 | 48 | 60 | 72 | 84 |
     *     |----+----+----+----+----+----+----|
     *  13 | 13 | 26 | 39 | 52 | 65 | 78 | 91 |
     *     |----------------------------------|
     * </pre>
     * 
     * If these are put in by (e.g.) <code>set(9, 1, 9)</code>, they can later
     * be retrieved by <code>get(9, 1)</code> (which returns 9)
     */
    @SuppressWarnings("unchecked")
    public TableMap(Collection<Row> rowCollection, Collection<Col> columnCollection,
            Class<? extends Content> contentClass)
    {
        this.contentClass = contentClass;

        rows = new HashMap<Row, Integer>();
        int c = 0;
        for (Row row : rowCollection)
        {
            rows.put(row, c++);
        }

        cols = new HashMap<Col, Integer>();
        c = 0;
        for (Col col : columnCollection)
        {
            cols.put(col, c++);
        }
        table = (Content[][]) Array.newInstance(contentClass, rowCollection.size(),
                columnCollection.size());
    }

    /**
     * Sets the value of the cell at <code>row, col</code> to the value given by
     * <code>val</code>
     * 
     * @param row
     *            This is the row key of the cell
     * @param col
     *            This is the column key of the cell
     * @param val
     *            This is the value to be put in the given cell
     */
    public void set(Row row, Col col, Content val)
    {
        table[rows.get(row)][cols.get(col)] = val;
    }

    /**
     * Retrieves the value at <code>row, col</code>
     * 
     * @param row
     *            This is the row key of the cell
     * @param col
     *            This is the column key of the cell
     */
    public Content get(Row row, Col col)
    {
        if (row == null || col == null)
        {
            return null;
        }
        return table[rows.get(row)][cols.get(col)];
    }
}
