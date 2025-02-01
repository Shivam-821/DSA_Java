// Implementation of Queue using LinkedList

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueIm {
    Node front = null, rear = null;

    void enqueue(int x) {
        Node new_node = new Node(x);
        if (rear == null) {
            front = rear = new_node;
        } else {
            rear.next = new_node;
            rear = new_node;
        }
        System.out.println("Enqueued: " + x);
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            throw new RuntimeException("Queue Underflow");
        }
        int val = front.data;
        front = front.next;

        if (front == null) {
            rear = null; 
        }

        return val;
    }

    int top() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            throw new RuntimeException("Queue Underflow");
        }
        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }
}

class Implementation {
    public static void main(String[] args) {
        QueueIm q = new QueueIm();
        q.enqueue(6);
        q.enqueue(8);
        q.enqueue(54);

        System.out.println("Top Element of Queue: " + q.top());
        System.out.println("Dequeued Element: " + q.dequeue());
        System.out.println("Top Element of Queue: " + q.top());
    }
}
