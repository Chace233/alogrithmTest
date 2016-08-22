package other;

public class Fibonacci {
    public int Fibonacci(int n) {
    	if(n < 0) return 0;
    	if(n == 0) return 0;
    	if(n == 1)  return 1;
    	return (Fibonacci(n-1)+Fibonacci(n-2));
    }
    
    public int Fibonacci2(int n){
    	if(n < 1) return 0;
    	else if(n == 1) return 1;
    	else{
    		int a = 0;
    		int b = 1;
    		int c = 1;
    		for(int i = 2; i <= n; i++){
    			c = a+b;
    			a = b;
    			b = c;
    		}
    		return c;
    	}
    }
    
    public static int Fibonacci3(int n){
    	int[] arr = new int[n+1];
    	arr[0] = 0;
    	arr[1] = 1;
    	for(int i = 2; i <= n; i++){
    		arr[i] = arr[i-1]+arr[i-2];
    	}
    	return arr[n];
    }
    public static void main(String[] args){
    	Fibonacci f = new Fibonacci();
    	System.out.print(f.Fibonacci3(7));
    }
}
