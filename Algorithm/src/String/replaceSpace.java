package String;

public class replaceSpace {
	 public String replaceSpace(StringBuffer str) {
    	int spaceNum = 0;
    	for(int i = 0; i < str.length(); i++){
    		if(str.charAt(i) == ' '){
    			spaceNum ++;
    		}
    	}
    	
    	int indexold = str.length()-1;
    	int len = str.length()+2*spaceNum;
    	int indexnew = len-1;
    	str.setLength(len);
    	for(;indexold >=0 && indexold<indexnew; indexold -- ){
    		if(str.charAt(indexold) == ' '){
    			str.setCharAt(indexnew--, '0');
    			str.setCharAt(indexnew--, '2');
    			str.setCharAt(indexnew--, '%');
    		}else{
    			str.setCharAt(indexnew--, str.charAt(indexold));
    		}
    	}
    	return str.toString();
    }
	 
	 public static void main(String[] args){
		 StringBuffer str = new StringBuffer(" ");
		 replaceSpace r = new replaceSpace();
		 System.out.print(r.replaceSpace(str));
	 }
}
