public class Queue {
  private static Integer _VECTOR_SIZE = 5;
  private Integer _total, _head, _tail, _vector[];

  public Queue() {
    this._total = 0;
    this._head = -1;
    this._tail = -1;
    this._vector = new Integer[Queue._VECTOR_SIZE];
  }

  public void print() {
    System.out.print("[ ");

    for (int i=0;i<this._vector.length;i+=1){
      System.out.print(this._vector[i] + " ");
    }

    System.out.println("]");


    System.out.print("[ ");

    int position = this._head;
    int count = 0;

    while (count < this._total) {
      System.out.print(this._vector[position] + " ");

      if (position == Queue._VECTOR_SIZE - 1) {
        position = 0;
      } else {
        position++;
      }

      count++;
    }

    System.out.println("]");
  }

  public Boolean isEmpty() {
    return this._total == 0;
  }
  
  public void enqueue(Integer value) {
    if (this._tail == Queue._VECTOR_SIZE - 1) {
      if (this._head == 0) {
        this._head = 1;
      }

      this._tail = 0;
    } else if (this._head > this._tail) {
      if (this._head == Queue._VECTOR_SIZE - 1) {
        this._head = 0;
      } else if (this._head - this._tail == 1) {
        this._head++;
      }

      this._tail++;
    } else {
      if (this._head == -1) {
        this._head++;
      }

      this._tail++;
      this._total++;
    }

    this._vector[this._tail] = value;
    System.out.print(this._head + " ");
    System.out.println(this._tail);
  }

  public Integer dequeue() {
    if (this._total > 0) {
      Integer value = this._vector[this._head];

      if (this._head == Queue._VECTOR_SIZE - 1) {
        this._head = 0;
      } else {
        this._head++;
      }

      this._total--;
      
      if (this._total == 0) {
        this._tail = this._head;
      }

      return value;
    } else {
      System.out.println("Queue is empty!");
    }

    return -1;
  }
}
