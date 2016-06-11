/* 
Programmer: Daniel Rojas
Class: Comp 182, Summer 2013
*/
 
	
   import java.util.*;

   interface BasicStack {
      public void push(int v);
      public int pop();
      public boolean isEmpty();
   }

   class LinkedStack implements BasicStack {
   
      private class Node {
         private int value;
         private Node next;
      	
         public Node(int v) { 
            value = v; 
         }
         public int getValue() { 
            return value; 
         }
      	
         public void setNext(Node n) { 
            next = n; 
         }
         public Node getNext() { 
            return next; 
         }
         public String toString() { 
            return String.format("%4d",value); 
         }
      }
   
      private Node TOS;
      private int sz;
   
      public LinkedStack() {
         TOS = null;  
      }
      public void push(int v) {
         Node m = new Node(v);
         m.setNext(TOS);  
         TOS = m;
         sz++;
      }
   	
      public int pop() { 
         int v = TOS.value; 
         TOS = TOS.next;
         sz--; 
         return v; 
      	 
      }
   		
      public boolean isEmpty() { 
         if(TOS == null)
            return true;
         else
            return false;
      }
   		
      public String toString() { 
         String s; 
      	
         if(TOS == null)
            return "empty";
         else 
            s = "";
         
         Node m = TOS;
         
         while(m != null){
            s = s + m.toString();
            s = s + " ";
            m = m.getNext();
         }
         return s;
      
      }
   	
      public void reverse() {
      	 
         Node m2 = TOS; //n
         Node m1 = null; //temp
         TOS = null;
      		
         while(m2 != null) {
            m1 = m2;
            m2 = m2.next;
            m1.next = TOS;
            TOS = m1;
         }
      
      }
   }

   class StackTest {
      public static void testcase01() {
      
         LinkedStack stk = new LinkedStack();
         Random random = new Random();
         int n = 20;
         int range = 1000;
      
         System.out.println("PUSH TEST --------------------------------------- ");
         for (int i=1; i<=n; i++) {
            int x = random.nextInt(range);
            stk.push(x);
            System.out.println("push " + String.format("%4d",x) + ":  " + stk);
         }
         System.out.println();
      
         System.out.println("POP TEST --------------------------------------- ");
         for (int i=1; i<=n; i++) {
            int x = stk.pop();
            System.out.println("pop  " + String.format("%4d",x) + ":  " + stk);
         }
         System.out.println();
      
         System.out.println("REVERSE TEST --------------------------------------- ");
         for (int i=1; i<=n; i++) {
            int x = random.nextInt(range);
            stk.push(x);
         }
         System.out.println("original:  " + stk);
         stk.reverse();
         System.out.println("reverse:   " + stk);
      }
   
      public static void main(String[] args) {
         testcase01();
      }
   }
