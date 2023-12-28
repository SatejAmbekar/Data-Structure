package Que1;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			LinkedList ll = new LinkedList();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("1. Inset at end 2.Display 3.Insert at Start\n"
							+ "4.Delete at End 5.Delete at start 6.Insert at Position\n"
							+ "7.Delete at Position 8.Find From Book Name 9. Display Count of Nodes\n " 
							+ "10.Sort Lins in reverse order of price");
					switch (sc.nextInt()) {
					case 1:
						ll.addAtEnd(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
						break;
					case 2:
						ll.display();
						break;
					case 3:
						ll.insertAtFront(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
						break;
					case 4:
						ll.deleteAtEnd();
						break;
					case 5:
						ll.deleteAtStart();
						break;
					case 6:
						ll.insertAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
						break;
					case 7:
						ll.deleteAtPosition(sc.nextInt());
						break;
					case 8:
						ll.searchByBookName(sc.next());
						break;
					case 9:
						System.out.println("Count of Books + "+ll.getCount());
						break;
					case 10:
						ll.sort();
						break;
					case 0:
						exit = true;
						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
	}

}
