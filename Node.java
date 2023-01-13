class Node <T>{

	private int position;
	private T value;
	private Node valueInfront;
	private Node valueBehind;

	public Node(T value){
		this.value = value;
		this.position = 0;
		this.valueInfront = null;
		this.valueBehind = null;
	}
	
	public Node(int position, T value, Node valueInfont, Node valueBehind){
		this.position = position;
		this.value = value;
		this.valueInfront = valueInfront;
		this.valueBehind = valueBehind;
	}

	public String toString(){
		return String.format("Node(%s)", this.value);
	}

	public T getValue(){
		return this.value;
	}

	public void setValue(T value){
		this.value = value;
	}

	public int getPosition(){
		return this.position;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public Node getValueInfront(){
		return this.valueInfront;
	}

	public void setValueInfront(Node node){
		this.valueInfront = node;
	}

	public Node getValueBehind(){
		return this.valueBehind;
	}

	public void setValueBehind(Node node){
		this.valueBehind = node;
	}

	public boolean equals(Object obj){
		try{
			return obj.equals(this.getValue());
		}catch (Exception e){
			try{
				return obj == this.getValue();
			}catch(Exception ex){
				return false;
			}
		}
	}
}
