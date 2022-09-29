import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue { 
  /*** Inserts an item at the queue front.*/
  public void enqueue(Object item);
  /*** Removes the object at the queue rear and returnsit.*/
  public Object dequeue();
  /*** Tests if this queue is empty.*/
  public boolean isEmpty();
  /*** Returns the number of elements in the queue*/
  public int size();
}

public class LinkedListQueue implements IQueue {

    public class Node{
        Object data;
        Node next;
    }

    Node front = null;
    Node rear = null;
    int size = 0;


    public void enqueue(Object item){
        Node current = new Node();
        current.data = item;
        current.next = null;
        if(size==0){
            front = current;
            rear = current;
        }
        else{
            rear.next = current;
            rear = current;
        }
        size++;
    }

    public Object dequeue(){

        if(size==0) throw new ArithmeticException();
        Object temp = front.data;
        front = front.next;
        size--;
        return temp;

    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void show(){
        int k = size();
        Object[] array = new Object[k];
        int i=0;
        while(i<k){
            array[i] = dequeue();
            i++;
        }
        System.out.print("[");
        for(int j=array.length-1;j>-1;j--){
            System.out.print(array[j]);
            if(j!=0) System.out.print(", ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner read = new Scanner(System.in);

        LinkedListQueue q = new LinkedListQueue();
       try{
            String line = read.nextLine().replaceAll("\\[|\\]", "");
            String[] s = line.split(", ");

            int[] arr = new int[s.length];
            if (s.length == 1 && s[0].isEmpty())
                arr = new int[]{};
            else {
                for(int i = s.length-1; i > -1; --i){
                    arr[i] = Integer.parseInt(s[i]);
                    q.enqueue((Object)arr[i]);
                }
            }
            
            String nline = read.next();

            if(nline.equals("enqueue")){
                String n = read.next();
                q.enqueue((Object)n);
                q.show();
            }
            if(nline.equals("dequeue")){
                Object temp = q.dequeue();
                q.show();
            }
            if(nline.equals("isEmpty")){
                if(q.isEmpty()) System.out.println("True");
                else System.out.println("False");
            }
            if(nline.equals("size")){
                System.out.println(q.size());
            }
       }
       catch(Exception e){
           System.out.println("Error");
       }
    }
}