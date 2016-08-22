package String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class chkRotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
    	if(lena != lenb) return false;
    	String aa = A+A;
    	Pattern p = Pattern.compile(B);
    	Matcher m = p.matcher(aa);
    	if(m.find()) return true;
    	return false;
    }
    
    public static void main(String[] args){
    	chkRotation c = new chkRotation();
    	System.out.println(c.chkRotation("12345", 5, "34512", 5));
    }
}
