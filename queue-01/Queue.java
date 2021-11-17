public class Queue {
  private Integer _total;
  private Node _head, _tail;

  public Queue() {
    this._total = 0;
    this._head = this._tail = null;
  }

  private class Node {
    private Integer _value;
    private Node _next;

    public Node(Integer value, Node next) {
      this._value = value;
      this._next = next;
    }

    public Integer getValue() {
      return this._value;
    }

    public Node getNext() {
      return this._next;
    }

    public void setNext(Node node) {
      this._next = node;
    }
  }

  public void print() {
    System.out.print("[ ");
    
    Node current = this._head;
    
    while (current != null) {
      System.out.print(current.getValue() + " ");

      current = current.getNext();
    }

    System.out.println("]");
  }

  public Boolean isEmpty() {
    return this._total == 0;
  }
  
  public void enqueue(Integer value) {
    Node node = new Node(value, null);

    if (this._total == 0) {
      this._head = node;
    } else {
      this._tail.setNext(node);
    }

    this._tail = node;
    this._total++;
  }

  public Integer dequeue() {
    if (this._total > 0) {
      Integer value = this._head.getValue();
      this._head = this._head.getNext();

      if (this._total == 1) {
        this._tail = null;
      }

      this._total--;

      return value;
    } else {
      System.out.println("Queue is empty!");
    }

    return -1;
  }
}
