//{ Driver Code Starts
import java.util.Scanner;

class GfG
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 
System.out.println("~");
}
	}
}




// } Driver Code Ends




class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;  // Initialize front to 0
        rear = 0;   // Rear also starts at 0
    }
    
    // Function to push an element x in a queue.
    void push(int x) {
        arr[rear] = x;
        rear++;
    } 

    // Function to pop an element from queue and return that element.
    int pop() {   
        if (front == rear) {
            return -1; // Queue is empty
        }
        
        int x = arr[front]; // Get front element
        front++; // Move front forward
        
        return x; // Return the popped element
    }
}




