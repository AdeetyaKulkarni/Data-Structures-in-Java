//C++ Program to demonstrate the working of a linked list (search_membert,insert,delete)
//Pros : Dynamic Storage(Push_Front & Push_Back available) 
//Cons : Indexing

#include<iostream>
using namespace std;

//Working:
// x(pointer to head node)->(head node)[[x][link]]->[[x][link]]->(tail node)[[x][link->null]]

struct node {
	
	int data;
	node *next; //link to the next element in the list

};

node *head; //pointer to node 


void insert(int x) {

	//insertion at beginning.

	//Step 1: Create a node

	node *temp = new node();//C++ way of allocating memory for a node using new function.

	//Step 2 : Add the data
	temp->data = x;

	//Step 3 : Point current node to NULL , point previous node to current node.
	temp->next = head; // If list is empty : head is already pointing to NULL temp is linked with NULL 
					  // If list is not empty : head pointing to the first member of list (temp is pointing at the newly created node) -
					  // So, temp(new node)->next(link) = head(head points to the first node)
	head = temp;// Head now poins to temp(newly created node)

	//DONE.	

}

void insert_at_value(int x,int n)
{
	node *tra = head; //traverser till needed value

	node *temp = new node();//C++ way of allocating memory for a node using new function.
	temp->data = x;
	temp->next = NULL;

	if (n = 1) {
		insert(x);
	}

	for (int j = 0; j < n-2; j++) //n-2 since tra = head i.e pointing at 1st node, hence if we traverse to n-2th link that is n-1 node
	{

		tra = tra->next;
	

	}
	//After reaching 
	             
	temp->next = tra->next; // newnode points to position node which is tra+1 

	//eg insert at 3
	//                   
	// |head|-> tra pointing to ->[1|] -> tra indirectly pointing to->[2|] -> temp.next points to this address (tra.next)[4|] -> [5|] ->NULL
	//                                                                   [3|]

	tra->next = temp; 

	cout << "[+]Link added successfully\n";

}

void printer() {

	node *itr = head;//iterator over the linked list
	cout << "\n\n";
	while (itr != NULL) {

		cout << itr->data <<"->";
		itr = itr->next;
	}
	

}




int main() {

	 head = NULL;//currently empty
	int i, n, x; //i = loop, n= no.of inputs, x= input value 

	cout << "Create a linked list ::\n";
	cout << "How long do you want the linked list?\n";
	
	cin >> n;

	for (i = 0; i < n; i++) {

		cout << "Enter input numbers to insert\n";
		cin >> x;
		insert(x);

	}

	 int choice = 0;
	 int pos=0;

	 while (choice != -1) {
		 
		 cout << "\n\nWhat do you want to do with the list\nOptions:\n1)Insert value at certain index\n2)Print the list\n";
		 cout << "[+] Input -1 to exit()\n";
		 cin >> choice;

		 switch (choice) {

		 case -1: {
			 cout << "Thankyou for using the program\n";
			 break;
		 }
			
		 case 1: {

			 cout << "Insert value at certain index ::\n";
			 cout << "Please input the value to be inserted\n";
			 cin >> x;
			 cout << "Please input the index to be inserted\n"<< "Should be <=" << n <<"\n";
			 cin >> pos;
			 insert_at_value(x, pos);
			 break;
			
			 
		 }

		 case 2: {
			  
			 cout << "\n[+] Printing the Linked List\n\n";
			 printer();
			 cout << "NULL";
			 break;
		 }

		 
		 default: {cout << "\nPlease choose correct value\n"; }

		 }

		 
	 }
	
	

	system("pause");

}
