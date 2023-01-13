import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

		LinkedList myList = new LinkedList();
		int number = 0;
		do{
			System.out.print("Enter a number (negative to stop): ");
			number = scanner.nextInt();
			if (number >= 0){
				myList.appendNode(new Node(number));
			}
		}while (number >= 0);
		scanner.close();


		System.out.println();
		System.out.println(myList);
		sort(myList);
		System.out.println();
		System.out.println(myList);

		System.out.printf("The index of 5 is %s", myList.indexOf(5));


  }

	public static void sort(LinkedList list){
		// bubble sort
		int n = list.getSize();
		for (int i = 1; i < n; i++){
			for (int j = 0; j < n - 1; j++){
				if (list.get(j).getValue() > list.get(j + 1).getValue()){
					switchNodes(list, j, j+1);
				}
			}
		}
	}

	public static void switchNodes(LinkedList list, int pos1, int pos2){
		Node pos1Node = list.get(pos1);
		Node pos2Node = list.get(pos2);

		list.set(pos1, new Node(pos2Node.getValue()));
		list.set(pos2, new Node(pos1Node.getValue()));
	}
}
