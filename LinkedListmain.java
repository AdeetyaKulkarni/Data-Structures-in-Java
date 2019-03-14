//LINKED LISTS 

class LinkedListmain {
   
  public static void main(String[] args) {
 
   LinkedList list = new LinkedList();
   list = list.pushfront(list , 0);
   list = list.pushback(list, 1);
   list = list.pushback(list, 3);
   list = list.pushback(list, 4);
   list = list.pushindex(list,2, 2);
   list.show(list);
   System.out.println("POPFRONT");
   list = list.popfront(list);
   list.show(list); 
   System.out.println("POPBACK");
   list = list.popback(list);
   list.show(list);
   System.out.println("POPINDEX");
   list = list.popindex(list, 1);
   list.show(list);
   System.out.println("POPKEY");
   list = list.popkey(list, 1);
   list.show(list);
  }

}


class LinkedList{

  Node head;//Head node
  
  //Used to init a node
  class Node{
    
    int data;//data
    Node next;//holds reference

    //constructor
    Node(int data){
      this.data = data;
      next = null;
    }
  }


  //----------PUSHBACK METHOD -----------------------//
  public LinkedList pushback(LinkedList list,int data){

    //New node crated
    Node new_node = new Node(data);
    //error new_node.next= null;

    //check if list is empty
    if(list.head == null){
      list.head = new_node; //head node holds reference of new node
     
    }
    else{
      Node trav = list.head;
      while(trav.next!=null){
        trav = trav.next;
      }
      trav.next = new_node;//trav.next obj holds reference to new node
    }

  
    return list;
  
  }
  

  //----------------PUSHFRONT METHOD----------------------
  public LinkedList pushfront(LinkedList list, int data){

    Node new_node = new Node(data);
    new_node.next = list.head;
    head = new_node;

    return list;
  }


  //----------------PUSH-INDEX METHOD-------------------------------
  public LinkedList pushindex(LinkedList list, int data, int index){

  if(index==0){
    list = pushfront(list, data);
  }

  else{  
    Node new_node = new Node(data);
    Node trav = list.head;
    try{

    for(int i=0; i<index-1; i++){
      trav = trav.next;
    }
    new_node.next = trav.next;
    trav.next = new_node;

    }
    catch(Exception e){
    System.out.println("The index provided is OutOFBounds..");
    }

  }

    return list;
  }

  //-------------------------POPFRONT METHOD---------------------------//
  public LinkedList popfront(LinkedList list){

    if(list.head == null){System.out.println("POP NOT POSSIBLE");}
    else{
    Node trav = list.head;
    head = trav.next;
    trav = null;
    }
    
    return list;
  }

 //------------------------POPBACK METHOD------------------------//
  public LinkedList popback(LinkedList list){

    if(list.head == null){System.out.println("POP NOT POSSIBLE");}
    else{
      Node trav = list.head;
      Node prev = list.head;
      while(trav.next!=null){
        trav=trav.next;
      }
      while(prev.next!=trav){
        prev = prev.next;
      }
      prev.next = null;
    }

    return list;
  }



//-----------------------POPINDEX METHOD-------------------------------//
   public LinkedList popindex(LinkedList list, int index){

  try{
    if(list.head == null){System.out.println("POP NOT POSSIBLE");}
    if(index == 0){list = list.popfront(list);}
    else{
      Node trav = list.head;
      Node prev = list.head;
      for(int i=0;i<index;i++){
        trav=trav.next;
      }
      while(prev.next!=trav){
        prev = prev.next;
      }
      prev.next = trav.next;
    }
  }catch(Exception e){System.out.println("INDEX OUT OF RANGE");}

    return list;
  }


  public LinkedList popkey(LinkedList list, int key){

  int nfflag=0;//not found flag
  try{
    if(list.head == null){System.out.println("POP NOT POSSIBLE");}
    if(head.data == key){list = list.popfront(list); nfflag=1;}
    else{
      Node trav = list.head;
      Node prev = list.head;
      while(trav.data != key){
        trav=trav.next;
        if(trav.next==null && trav.data!=key){nfflag=1;break;}
      }
      while(prev.next!=trav && nfflag==0){
        prev = prev.next;
      }
      if(nfflag==0){
      prev.next = trav.next;
      }
      else{System.out.println("KEY NOT FOUND");}
    }
  }catch(Exception e){System.out.println("KEY NOT FOUND");}

    return list;
  }
  


  //-----------------SHOW METHOD ---------------------//
  public void show(LinkedList list){

    Node trav = list.head;
    // this is just trav because trav.next is always kept null trav is object 
    // and thus trav references other nodes and displays the values
    while(trav != null){
      System.out.println(trav.data);
      trav = trav.next;
    }

  }


}
