/*
Programmer: Daniel Rojas
Class: Comp 182, Summer 2013
*/

   import java.util.*;

   public interface BasicStack {
      public void push(int v);
      public int pop();
      public int peek();
      public boolean isEmpty();
   }

   class ArrayStack implements BasicStack {
      private int[] data;
      private int tos; 
   	
      public ArrayStack() {
         data = new int[20];
         tos = 0;
      }
   	
      public String toString() {
         if(tos == 0)
            return "empty";
         else {
            String s = "";
            for(int i = 0; i < tos; i++) {
               s = s + data[i] + " ";
            }
            return s;
         }
      			
      }
   
      public void push(int v) {
         data[tos] = v; 
         tos++;
      	
      }
   	
      public int pop() { 
			tos--;
         return data[tos];
         
      }
   	
      public int peek() { 
         return data[tos-1];
      }
   	
      public boolean isEmpty() { 
         if(data.length == 0)
            return true; 
         else
            return false;
      }
   }

   class LinkStack implements BasicStack {
      class Node {
         int value;
         Node next;
      }
   	
      private Node head; 
   	
      public LinkStack() {
      	
      }
      public String toString() { 
         return ""; }
   
      public void push(int v) { }
      public int pop() { 
         return 0; }
      public int peek() { 
         return 0; }
      public boolean isEmpty() { 
         return true; }
   }

   class StackTester {
   
   /* ------------------------------------------------------------
   //	testcase1()
   // ------------------------------------------------------------
   	example output for n=10, range=1000
   
   	push 557:  557 TOS
   	push 196:  557 196 TOS
   	push 328:  557 196 328 TOS
   	push 985:  557 196 328 985 TOS
   	push 222:  557 196 328 985 222 TOS
   	push 209:  557 196 328 985 222 209 TOS
   	push 6:  557 196 328 985 222 209 6 TOS
   	push 767:  557 196 328 985 222 209 6 767 TOS
   	push 374:  557 196 328 985 222 209 6 767 374 TOS
   	push 113:  557 196 328 985 222 209 6 767 374 113 TOS
   
   	pop 113:  557 196 328 985 222 209 6 767 374 TOS
   	pop 374:  557 196 328 985 222 209 6 767 TOS
   	pop 767:  557 196 328 985 222 209 6 TOS
   	pop 6:  557 196 328 985 222 209 TOS
   	pop 209:  557 196 328 985 222 TOS
   	pop 222:  557 196 328 985 TOS
   	pop 985:  557 196 328 TOS
   	pop 328:  557 196 TOS
   	pop 196:  557 TOS
   	pop 557:  empty
   */
   
      public static void testcase1() {
         int n = 10;
         int range = 1000;
         Random r = new Random();
      
         BasicStack stk = new ArrayStack();
      // BasicStack stk = new LinkStack();
      
         for (int i=1; i<=n; i++) {
            int x = r.nextInt(range);
            stk.push(x);
            System.out.println("push " + x + ":  " + stk);
         }
      
         for (int i=1; i<=n; i++) {
            int x = stk.pop();
            System.out.println("pop " + x + ":  " + stk);
         }
      }
   
      public static void testcase2() {
      
         int n = 100;
         int range = 1000;
         Random r = new Random();
      
         Stack<Integer> stk = new Stack<Integer>();
         for (int i=1; i<=n; i++) {
            int x = r.nextInt(range);
            stk.push(x);
            System.out.println("push " + x + ":  " + stk);
         }
      
         for (int i=1; i<=n; i++) {
            int x = stk.pop();
            System.out.println("pop " + x + ":  " + stk);
         }
      }
   
      public static void main(String[] args) {
         testcase1();
      //testcase2();
      }
   }