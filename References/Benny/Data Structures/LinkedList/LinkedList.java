public class LinkedList<E> {
    protected Node head;
    protected Node tail;
    protected static int size = 0;

    public LinkedList()
    {

    }

    public LinkedList(E[] e)
    {
        add(e);
    }

    public void add(E[] e)
    {
        for (int i = 0; i < e.length; i++)
        {
            addLast(e[i]);
        }
    }

    public void add(int index, E e)
    {
        if (head == null || index == 0)
        {
            addFirst(e);
        }
        else if (index > size-1)
        {
            addLast(e);
        }
        else
        {
            Node newNode = new Node(e);

            Node current = head;

            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

    }

    public E remove(int index)
    {
        if (index < 0 || index >= size)
        {
            return null;
        }
        else
        {
            size--;
            Node current = head;
            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            Node newNode = current.next;
            current.next = current.next.next;
            return (E) newNode.data;
        }
    }

    public E set(int index, E e)
    {
        if (index >= size)
        {
            return null;
        }
        else
        {
            Node current = head;
            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            Node newNode = new Node(e);
            newNode.next = current.next.next;
            current.next = newNode;

            return (E) newNode;
        }
    }

    public void addLast(E e)
    {
        Node newNode = new Node(e);

        // Case 1: list is empty
        if (head == null)
        {
            head = newNode;
            return;
        }

        // Case 2: traverse to end
        Node current = head;
        while (current.next != null)
        {
            current = current.next;
        }

        size++;
        current.next = newNode;
        updateTail();
    }

    public void addFirst(E e)
    {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void updateTail()
    {
        Node current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        tail = current;
    }

    public Node getLast()
    {
        return tail;
    }

    public Node getFirst()
    {
        return head;
    }

    public void removeFirst()
    {
        if (head == null)
        {
            return;
        }
        head = head.next;
        size--;
    }

    public void clear()
    {
        while (size > -1)
        {
            removeLast();
        }
    }

    public void removeLast()
    {
        if (head == null)
        {
            return;
        }

        if (head.next == null)
        {
            head = null;
            return;
        }

        Node current = head;
        for (int i = 0; i < size-1; i++)
        {
            current = current.next;
        }
        size--;
        current.next = null;
        updateTail();
    }

    public boolean contains(E e)
    {
        for (int i = 0; i < size; i++)
        {
            if (get(i).equals(e))
            {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e)
    {
        for (int i = 0; i < size; i++)
        {
            if (get(i).equals(e))
            {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E e)
    {
        for (int i = size-1; i > -1; i--)
        {
            if (get(i).equals(e))
            {
                return i;
            }
        }
        return -1;
    }

    public E get(int index)
    {
        if (index >= size)
        {
            return null;
        }
        else
        {
            Node current = head;
            for (int i = 0; i < index; i++)
            {
                current = current.next;
            }
            return (E) current.data;
        }
    }

    public void printL()
    {
        if (head != null)
        {
            Node current = head;
            while (current != null)
            {
                System.out.print(current.data + ", ");
                current = current.next;
            }
        }
    }

    public String toString()
    {
        String s = "[";
        if (head != null)
        {
            Node current = head;
            s += current.data + ", ";
            while (current.next != null)
            {
                current = current.next;
                s += current.data + ", ";
            }
            s = s.substring(0, s.length()-2) + "]";
        }
        return s;
    }
}
