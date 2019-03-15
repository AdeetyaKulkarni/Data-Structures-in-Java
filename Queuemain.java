class Main {
  public static void Queuemain(String[] args) {
    
    Queue list = new Queue();
    list.push(list, 0);//0
    list.push(list, 1);//01
    list.push(list, 2);//012
    list.push(list, 3);//0123
    list.push(list, 4);//01234
    list.push(list, 5);//012345
    list.pop(list);//12345
    list.pop(list);//2345
    list.show(list);

  }
}


class Queue{

  Node head;

  class Node{
    int data;
    Node next;


    Node(int data){this.data= data;next = null;}
    

  }

  public Queue push(Queue list, int data){

    Node new_node = new Node(data);
    if(list.head == null){list.head = new_node;}
    else{
      Node trav = list.head;
      while(trav.next != null){
        trav = trav.next;
      }
      trav.next = new_node;
    }

    return list;
  }


    public Queue pop(Queue list){

  try{
    if(list.head == null){System.out.println("List EMPTY");}
    else{
      list.head = head.next;
    }
  }
  catch(NullPointerException e){
    list.head = null;
  }

    return list;
  }

 

  public void show(Queue list){

    Node trav = list.head;
 
    while(trav!=null){
      System.out.print(trav.data);
      trav = trav.next;
    }
   
    
    
  }

}
