//Doubly linkedlist working

class DoublyLinkedList {
  public static void main(String[] args) {
    
    DLinkedList list = new DLinkedList();
    list.push(list, 0);
    list.push(list, 1);
    list.push(list, 2);
    list.push(list, 3);
    list.push(list, 4);
    list.push(list, 5);
    list.show(list);

  }
}


class DLinkedList{

  Node head;

  class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){this.data= data;next = null;prev=null;}
    

  }

  public DLinkedList push(DLinkedList list, int data){

    Node new_node = new Node(data);
    if(list.head == null){list.head = new_node; new_node.prev = null;}
    else{
      Node trav = list.head;
      while(trav.next != null){
        trav = trav.next;
      }
      trav.next = new_node;
      new_node.prev = trav;
    }

    return list;
  }


  public void show(DLinkedList list){

    Node trav = list.head;
 
    while(trav.next!=null){
      System.out.print(trav.data);
      trav = trav.next;
    }
    int count = 0;
    while(trav!=null){
      System.out.print(trav.data);
      trav = trav.prev;
    }
    
    
  }

}
