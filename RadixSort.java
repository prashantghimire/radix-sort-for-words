import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * @Author Prashant Ghimire
 * This program will sort the names on the considering their first three letters only using Radix sort algorithm.
 * It also keep tracks on the number of comparisons made during the sorting process
 */
public class RadixSort {
	public static void main(String[]args) throws FileNotFoundException{
		Linkedlist[] allNameLinkedList = new Linkedlist[26]; // create an array of LinkedList for 26 letters in alphabets
		int count = 0;
		// initialize all the elements in the array to new LinkedList
		for (int i = 0; i < allNameLinkedList.length; i++) {
			allNameLinkedList[i] = new Linkedlist();
		}
		Scanner scan = new Scanner(new File("radixnames.txt"));
		
		// Put the names in the file according to their third character into the corresponding LinkedLists
		// For example, "Zachary" would go to to allNameLinkedList[2]
		while(scan.hasNextLine())
		{
			String currentname = scan.nextLine();
			for(int i = 0; i < 26; i++){
				if(currentname.charAt(2) == (char)(i+97))
				{
					allNameLinkedList[i].addNodeToTheEndOfTheList(currentname);
				}
			}
			count++;
		}
		
		// copy sorted nodes to new LinkedList called container
		Linkedlist container = new Linkedlist();
		for (int i = 0; i < 26; i++) {
			Node n = allNameLinkedList[i].front;
			
			while(n != null){
				container.addNodeToTheEndOfTheList(n.name);
				n = n.next;
			}
		}
		// empty all the elements of array
		for (int i = 0; i < allNameLinkedList.length; i++) {
			allNameLinkedList[i] = new Linkedlist();
		}
		
		Node m = container.front;
		while(m!=null)
		{
			String currentname = m.name;
			for(int i = 0; i < 26; i++){
				if(currentname.charAt(1) == (char)(i+97))
				{
					allNameLinkedList[i].addNodeToTheEndOfTheList(currentname);
				}
			}
			m = m.next;
			count++;
		}
		container = new Linkedlist();
		for (int i = 0; i < 26; i++) {
			m = allNameLinkedList[i].front;

			while(m!=null){
				container.addNodeToTheEndOfTheList(m.name);
				m = m.next;
			}
		}
		for (int i = 0; i < allNameLinkedList.length; i++) {
			allNameLinkedList[i] = new Linkedlist();
		}
		m = container.front;
		
		while(m!=null)
		{
			String currentname = m.name;
			
			for(int i = 0; i < 26; i++){
				if(currentname.charAt(0) == (char)(i+97))
				{
					allNameLinkedList[i].addNodeToTheEndOfTheList(currentname);
				}
			}
			m = m.next;
			count++;
		}
		container = new Linkedlist();
		for (int i = 0; i < 26; i++) {
			m = allNameLinkedList[i].front;

			while(m!=null){
				System.out.println(m.name);
				container.addNodeToTheEndOfTheList(m.name);
				m = m.next;
			}
		}
		scan.close();
		System.out.println("The total number of comparisions was :"+count);
	}
}