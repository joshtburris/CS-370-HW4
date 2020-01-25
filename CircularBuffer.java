
public class CircularBuffer {
	
	private int size = 0;
	private int MAX_SIZE = 1000;
	private Node head = null;
	private Node tail = null;
	
	private class Node {
		double element;
		Node next;
		public Node(double element) {
			this.element = element;
		}
		
	}
	
	public int size() { return size; }
	
	// Add a node to the head
	public void addFront(double element) throws Exception {
		Node n = new Node(element);
		if (isEmpty()) {
			head = n;
			tail = n;
			n.next = head;
		} else if (isFull()) {
			throw new Exception();
		} else {
			Node tmp = head;
			n.next = tmp;
			head = n;
			tail.next = head;
		}
		size++;
	}
	
	// Add a node to the tail
	public void add(double element) throws Exception {
    	if (isEmpty()) {
    		addFront(element);
    	} else if (isFull()) {
    		throw new Exception();
    	} else {
    		Node n = new Node(element);
    		tail.next = n;
    		tail = n;
    		tail.next = head;
    		size++;
    	}
    }
    
    public double poll() throws Exception {
    	if (isEmpty())
    		throw new Exception();
    	if (size == 1) {
    		Node tmp = head;
    		head = null;
    		tail = null;
    		size = 0;
    		return tmp.element;
    	} else {
	    	Node n = head;
	    	head = n.next;
	    	tail.next = head;
	    	size--;
	    	return n.element;
    	}
    }
    
    public boolean isEmpty() {
    	return size() == 0 ? true : false;
    }
    
    public boolean isFull() {
    	return size() == MAX_SIZE ? true : false;
    }
    
    public String toString() {
    	String s = "[";
    	Node n = head;
    	s += n.element;
    	n = n.next;
    	while (n != tail) {
    		s += ", " + n.element;
    		n = n.next;
    	}
    	s += "]";
    	return s;
    }
    
}

