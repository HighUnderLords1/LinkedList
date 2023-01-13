class LinkedList {

	private int size;
	private Node<Integer> firstNode;
	private Node<Integer> lastNode;

	public LinkedList(){
		this.firstNode = null;
		this.lastNode = null;
		this.size = 0;
	}

	public void makeConnection(Node<Integer> frontNode, Node<Integer> behindNode){
		behindNode.setPosition(frontNode.getPosition()+1);

		frontNode.setValueBehind(behindNode);
		behindNode.setValueInfront(frontNode);

		//System.out.println();
		//System.out.printf("********%n");
		//System.out.printf("makeConnection: FrontNode: %s, %s infront of %s%n", frontNode, frontNode.getPosition(), frontNode.getValueBehind());
		//System.out.printf("makeConnection: BehindNode: %s, %s behind of %s%n", behindNode, behindNode.getPosition(), behindNode.getValueInfront());
		//System.out.printf("********%n");
		//System.out.println();
	}

	public void appendNode(Node<Integer> node){
		node.setPosition(size);
		this.size += 1;               

		if (this.size == 1){
			this.firstNode = node;
			this.lastNode = node;
			this.firstNode.setValueBehind(null);
			this.firstNode.setValueInfront(null);
		}else{
			makeConnection(this.lastNode, node);
			this.lastNode = node;
		}
	}

	public int getSize(){
		return this.size;
	}

	public void set(int position, Node<Integer> node){
		node.setPosition(position);
		Node<Integer> nodeInfront = get(position-1);
		Node<Integer> nodeBehind = get(position+1);

		//System.out.println();
		//System.out.printf("!!!!!!%n");
		//System.out.printf("set: NodeInfront: %s, %s%n", nodeInfront, nodeInfront.getPosition());
		//System.out.printf("set: NodeBehind: %s, %s%n", nodeBehind, nodeBehind.getPosition());
		//System.out.printf("!!!!!!%n");
		//System.out.println();

		if (position == 0){
			this.firstNode = node;
		}else if (position == size-1){
			this.lastNode = node;
		}else if (position < 0 || position >= size){
			return;
		}

		if (nodeInfront != null){
			makeConnection(nodeInfront, node);
		}

		if (nodeBehind != null){
			makeConnection(node, nodeBehind);
		}

		//node = get(position);
		//nodeInfront = node.getValueInfront();
		//nodeBehind = node.getValueBehind();

		//if (nodeInfront != null){
			//System.out.printf("Node Infront %s at index %s%n", nodeInfront, nodeInfront.getPosition());
		//}
		//System.out.printf("New Node %s at index %s%n", node, node.getPosition());
		//if (nodeBehind != null){
			//System.out.printf("Node Behind %s at index %s%n", nodeBehind, nodeBehind.getPosition());
		//}
	}

	public Node<Integer> get(int position){
		Node<Integer> node = this.firstNode; // Node(5) Position 0, Node(10) Position 1
		
		for (int i = 0; i < this.size; i++){

			//System.out.println();
			//System.out.printf("$$$$$$$$$$$*%n");
			//System.out.printf("get: Node: %s, %s%n", node, i);
			//System.out.printf("$$$$$$$$$$$*%n");
			//System.out.println();
			
			if (node.getPosition() == position){
				return node;
			}
			node = node.getValueBehind(); // Node(5).getValueBehind() -> Node(10)
		}

		return null;
	}

	public boolean isEmpty(){
		return (this.size == 0);
	}

	public String toString(){
		String string = String.format("LinkedList of Node<int> with length of %s%n", this.size);
		for (int i = 0; i < this.size; i++){
			Node<Integer> node= get(i);
			
			//System.out.println();
			//System.out.printf("!*!*!*!*!*!*%n");
			//System.out.printf("toString: Node: %s%n", node);
			//System.out.printf("!*!*!*!*!*!*%n");
			//System.out.println();
			
			if (i < this.size - 1){
				string = String.format("%s%s%n", string, node);
			}else{
				string = String.format("%s%s", string, node);
			}
		}

		return string;
	}

	public int indexOf(int number){
		for (int i = 0; i < this.size; i++){
			if (get(i).getValue().equals(number)){
				return i;
			}
		}
		return -1;
	}
}
