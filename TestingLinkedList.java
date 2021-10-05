public class TestingLinkedList 
{
    public static void main(String[] args) 
    {
        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = -1; i < 10; i++) {
            try 
            {
                ll.add(i, i);
            }
            catch(IndexOutOfBoundsException e) 
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(ll);
    }
}