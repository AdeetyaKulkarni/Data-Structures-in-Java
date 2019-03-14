class StackMain {
  public static void main(String[] args) {
    
    Stack list = new Stack();
    list.push(list, 0);//0
    list.push(list, 1);//01
    list.push(list, 2);//012
    list.push(list, 3);//0123
    list.push(list, 4);//01234
    list.push(list, 5);//012345
    list.pop(list);//01234
    list.pop(list);//0123
    list.show(list);

  }
}


class Stack{

  Node head;

  class Node{
    int data;
    Node next;


    Node(int data){this.data= data;next = null;}
    

  }

  public Stack push(Stack list, int data){

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


    public Stack pop(Stack list){

  try{
    if(list.head == null){System.out.println("Stack EMPTY");}
    else{
      Node trav = list.head;
      Node extra = trav.next;
      while(extra.next != null){
        trav = trav.next;
        extra = trav.next;
      }
      trav.next=null;
    }
  }
  catch(NullPointerException e){
    list.head = null;
  }

    return list;
  }

 

  public void show(Stack list){

    Node trav = list.head;
 
    while(trav!=null){
      System.out.print(trav.data);
      trav = trav.next;
    }
   
    
    
  }

}
