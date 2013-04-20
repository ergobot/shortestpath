
/**
 *  class Cell: data structure that has two components of type int: 
 *  key and item.
 * 
 *  key - to be used when sorting
 *  item - domain element (depending on the particular problem)
 *  
 *  Constructor: Cell()
 *  Methods:
 *      setKey(int key)
 *      setItem(int item)
 *      int getKey()
 *      int getItem()
 */
public class Cell
{
    
    private int item;
    private int key;
    
// constructor 1   
    public Cell()
    {
        item = 0;
        key = 0;
    }

// constructor 2
    public Cell(int key, int item)
    {
        this.key = key;
        this.item = item;
    }

// Getters    
    public int getKey()
    {
        return key;
    }

    public int getItem()
    {
        return item;
    }

// Setters
    public void setKey(int key)
    {
        this.key = key;
    }

    public void setItem (int item)
    {
        this.item = item;
    }
}

    

