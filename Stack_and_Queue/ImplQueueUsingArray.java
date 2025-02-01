// Implementation of Queue using Array. => Queue: FIFO

class QueueIm{
	int size = 1000;
	int[]   arr = new int[size];
	int front = -1;          // element dequeued from front
	int back = -1;          // element enqueued from back

	// QueueIm(int size){
	// 	this.size = size;
	// 	new arr[size];
	// 	front = back = -1;
	// }

	void enqueue(int x){
		if(back == size-1){    // for circular queue use overflow condition as: ((back+1)%size) == front
			System.out.println("Queue Overflow!");
			return;
		}
		if(front == -1 && back == -1){
			front = 0;
			back = 0;
		}
		else back = (back + 1)%size;
		arr[back] = x;
		System.out.println("Element enqueued is: " + x);
	}

	int dequeue(){
		if(front == -1 || front > back){
			System.out.println("Queue Underflow!");
			System.exit(1);
		}
		int x = arr[front];
		if(front == back){
			front = -1;
			back = -1;
		}
		front = (front + 1) % size;

		return x;
	}

	int front() {
        if (front == -1 || front > back) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    int size() {
        return (front == -1) ? 0 : (back - front + 1);
    }
}

class Implementation{
	public static void main(String[] args){
		// QueueIm qu = new QueueIm(100);
		QueueIm q = new QueueIm();
		q.enqueue(10);
		q.enqueue(34);
		q.enqueue(4);
		System.out.println("Front Element of Queue is: " + q.front());
		System.out.println("Dequeued Element of Queue is: " + q.dequeue());
		System.out.println("Front Element of Queue is: " + q.front());
		System.out.println("Size of Queue is: " + q.size());
	}

}