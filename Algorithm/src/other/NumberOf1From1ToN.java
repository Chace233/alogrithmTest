package other;

public class NumberOf1From1ToN {
	
	public static int count(int n){
	    if(n<1)
	        return 0;
	    int count = 0;
	    int base = 1;
	    int round = n;
	    while(round>0){
	        int weight = round%10;
	        round/=10;
	        count += round*base;
	        if(weight==1)
	            count+=(n%base)+1;
	        else if(weight>1)
	            count+=base;
	        base*=10;
	    }
	    return count;
	}
	
    public static int NumberOf1(String str){  
        //获得输入数字的第一位数字，例如输入21345，firstDig=2  
        int firstDig=Integer.parseInt(str.charAt(0)+"");  
        int length = str.length();  
        if(length == 1 && firstDig ==0)return 0;  
        if(length==1 && firstDig>0) return 1;  
        //首位为1的个数  
        int firstNumDigit = 0;  
        if(firstDig>1)firstNumDigit=PowerBase10(length-1);  
        if(firstDig==1)firstNumDigit=Integer.parseInt(str.substring(1))+1;  
        //其他位为1的个数  
        int otherNumDigit = firstDig*(length-1)*PowerBase10(length-2);  
        // 递归的位为1的个数  
        int numrecursive = NumberOf1(str.substring(1));  
        return firstNumDigit+otherNumDigit+numrecursive;  
    }  
    public static int PowerBase10(int n){  
        int result = 1;  
        for(int i=0;i<n;i++){  
            result*=10;  
        }  
        return result;  
    }
	
	public static void main (String[] args) {
		int n = 534;
		String m = "21345";
		int count = NumberOf1From1ToN.NumberOf1(m);
		System.out.print(count);
	}
}
