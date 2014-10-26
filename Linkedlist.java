public class Linkedlist {
	public Node front;
	
	public void init() {
		this.front = null;
	}
	
	public Node FindTail() {
		Node current = front;
		if (current == null) {
			System.out.println("The linklist is empty");
			return null;
		} else if (current.next == null) {
			return current;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			return current;
		}
	}
	
	public void addNodeToTheEndOfTheList(String m){
		if(front == null){
			front = MakeNode(m);
		}else{
			Node tail;
			tail = findTail(front);
			tail.next = MakeNode(m);
		}
	}

	public Node MakeNode(String s) {
		Node newNode = new Node(s);
		return newNode;

	}

	public void InsertAfter(Node spot, String s) {
		Node myNode = MakeNode(s);
		myNode.next = spot.next;
		spot.next = myNode;
	}

	public void showList() {
		Node current = front;
		while (current != null) {
			System.out.println(current.name);
			current = current.next;
		}
	}

	public Node findTail(Node head) {
		Node current = front;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}
	
	public void addFront(String s){
		Node myNode = MakeNode(s);
		Node j = front;
		myNode.next=j;
		front = myNode;
	}

	public void insertBefore(Node n, String m) {
		Node myNode = MakeNode(m);
		Node j = front;
		while (j.next != n) {
			j = j.next;
		}
		myNode.next = n;
		j.next = myNode;
	}
	
	public void showSpec(String start)
	{
		Node n = this.front;	
		while(n != null)
		{
			if(n.name.startsWith(start))
			{
			System.out.println(n.name);
			}
			n = n.next;
		}
	}
	
	public static Linkedlist AddAList(Linkedlist onelist, Linkedlist anotherlist)
	{
		Linkedlist sumlist = new Linkedlist();
		Node lastnode = onelist.front;
		while(lastnode.next != null)
		{
			sumlist.addNodeToTheEndOfTheList(lastnode.name);
			lastnode = lastnode.next;
		}
		
		lastnode = anotherlist.front;
		while(lastnode != null)
		{
			sumlist.addNodeToTheEndOfTheList(lastnode.name);
			lastnode = lastnode.next;
		}
		return sumlist;
	}
	
	public void deleteNode(String data)
	{
		Node current = this.front;
		while (current != null) {
			if (current.next.name.equals(data)) {
				current.next = current.next.next;
				break;
			}
			current = current.next;
		}
	}
	public void section(String str)
	{
		Node current = this.front;
		int count =0 ;
		while(current != null)
		{
			if(current.name.startsWith(str)){
				count = count+1;
				System.out.println(current.name);
			}
			current = current.next;
		}
	}	
}