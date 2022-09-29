import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {

    public Object pop();

    public Object peek();

    public void push(Object element);

    public boolean isEmpty();

    public int size();

}

public class MyStack implements IStack {

    /**
     * Node class contain object data and reference of the next node 
     */
    public class Node {
        Object data;
        Node next;
    }

    Node top = null;
    static int size = 0;

    
    /*** Pushes an item onto the top of this stack.
    * @param object to insert*
    */
    public void push(Object element) {

        Node temp = new Node();
        temp.data = element;
        if (top == null) {
            temp.next = null;
            top = temp;
        } else {
            temp.next = top;
            top = temp;
        }
        size++;

    }

    /*** Removes the element at the top of stack and returnsthat element.
    * @return top of stack element, or through exception if empty
    */
    public Object pop() {

        if (top == null)
            throw new EmptyStackException();

        Object curr = top.data;
        top = top.next;
        size--;
        return curr;

    }

    /*** Tests if this stack is empty
    * @return true if stack empty
    */
    public boolean isEmpty() {

        if (top == null) {
            return true;
        }
        return false;

    }

    /*** Get the element at the top of stack without removing it from stack.
    * @return top of stack element, or through exception if empty
    */
    public Object peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    /**
     * @return returns the size of the stack
     */
    public int size() {
        return size;
    }

    /**
     * function used to print the stack elements with specific formula
     */
    public void show() {

        Node current = top;
        System.out.print("[");
        for (int i = 0; current != null; ++i) {
            System.out.print(current.data);
            if (current.next != null)
                System.out.print(", ");
            current = current.next;
        }
        System.out.print("]");

    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        MyStack stack = new MyStack();

        String ip = read.nextLine().replaceAll("\\[|\\]", "");
        
        String[] s = ip.split(", ");

        if (!(s.length == 1 && s[0].isEmpty())) {
            for (int i = s.length - 1; i >= 0; i--) {
                stack.push(s[i]);
            }
        }

        try {

            String op = read.next();

            if (op.equals("push")) {

                Object obj = read.next();
                stack.push(obj);
                stack.show();

            }
            if (op.equals("pop")) {

                stack.pop();
                stack.show();

            }
            if (op.equals("peek")) {

                System.out.println(stack.peek());

            }
            if (op.equals("isEmpty")) {

                if(stack.isEmpty()) System.out.println("True");
                else System.out.println("False");

            }
            if (op.equals("size")) {

                System.out.println(stack.size()); 

            }

        } catch (EmptyStackException e) {
            System.out.println("Error");
        }

    }
}