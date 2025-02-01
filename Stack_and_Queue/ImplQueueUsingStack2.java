// Optimal way to Implement Queue using Stack.

import java.util.Stack;

class QueueIm {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int x) {
        s1.push(x);
    }

    int dequeue() {
        if (s1.empty() && s2.empty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        if (s2.empty()) { 
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    int top() {
        if (s1.empty() && s2.empty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        if (s2.empty()) { // Move elements only when s2 is empty
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    int size() {
        return s1.size() + s2.size();
    }
}

class Implementation {
    public static void main(String[] args) {
        QueueIm q = new QueueIm();
        q.enqueue(20);
        q.enqueue(14);
        q.enqueue(25);
        System.out.println("Size of Queue is: " + q.size());
        System.out.println("Top Element of Queue is: " + q.top());
        System.out.println("Dequeued Element of Queue is: " + q.dequeue());
        System.out.println("Size of Queue is: " + q.size());
    }
}
