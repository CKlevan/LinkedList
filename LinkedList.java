class Node<E> 
{
    E item;
    Node<E> next;

    Node() 
    {
        this.item = null;
        this.next = null;
    }

    Node(E item, Node<E> next) 
    {
        this.item = item;
        this.next = next;
    }

}

public class LinkedList<T> 
{
    private Node<T> head;
    private int size;

    public LinkedList() 
    {
        head = new Node<T>();
        size = 0;
    }

    /**
     * This methods adds an item to the end of the list
     *
     * @param item The object that will be added at the end of the list
     *
     */
    public void add(T item) 
    {
        Node<T> curr = head;
        while (curr.next != null) 
        {
            curr = curr.next;
        }
        curr.next = new Node<T>(item, null);
        size++;
    }

    /**
     * 
     * @param item the object that will be add at the <code>pos</code>
     * @param pos  Defines the position that the item will be added to the list
     */

    public void add(T item, int pos) 
    {
        if (pos < 0 || pos > size) 
        {
            throw new IndexOutOfBoundsException("Are you kidding me? " + pos);
            // if (size == 0) pos = 0;
            // else pos %= size; // pos = pos % size; // % is the modular operator
        }
        int i = 0;
        for (Node<T> curr = head; curr != null; curr = curr.next) 
        {
            if (i == pos) 
            {
                Node<T> n = new Node<T>(item, curr.next);
                curr.next = n;
                break;
            }
            i++;
        }
        size++;
    }

    /**
     * This method helps the user to print the list on the screen
     * 
     * @return The string to print on the scr
     */
    @Override
    public String toString() 
    {
        String out = "";
        for (Node<T> curr = head.next; curr != null; curr = curr.next) 
        {
            out += curr.item + " ";
        }
        return out;
    }

    /**
     * Removes the first matched object and returns the postion of the removed
     * object from the LinkedList.
     * 
     * @param item represents the item the user wants to remove
     * @return position of the removed item.
     */

    int remove(T item) 
    {

        Node<T> prev = head, curr = prev.next;
        int pos = 0;
        while (curr != null) 
        {
            if(item.equals(prev.next.item))
            {
                prev.next = curr.next;
                size--;
                return pos;
            }
            curr = curr.next;
            prev = prev.next;
            pos++;
        }
        return -1;

    }

    /**
     * Removes the object position and returns the removed object from the
     * LinkedList
     * 
     * @param position represents the position of the object to be removed
     * @return the item that was removed.
     */

    T remove(int pos) 
    {
        int i = 0;
        Node<T> prev, curr;
        for (prev = head, curr = head.next; curr != null; prev = prev.next, curr = curr.next) 
        {
            if (i == pos) 
            {
                prev.next = curr.next;
                size--;
                return prev.next.item;
            }
            i++;
        }
        return null;
    }
}
