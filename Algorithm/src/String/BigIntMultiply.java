package String;

public class BigIntMultiply {
	private final static int SIZE=4;
	
	public static String bigIntMultiply(String X, String Y, int len){
		String res = "";
		
		if(len <= SIZE){
			return (""+(Integer.parseInt(X))*(Integer.parseInt(Y)));
		}
		
		X = formatNumber(X,len);
		Y = formatNumber(Y,len);
		
		int len1 = len/2;
		int len2 = len-len1;
		int lenm = Math.max(len1,len2);
		
		String A = X.substring(0, len1);
		String B = X.substring(len1);
		String C = Y.substring(0, len1);
		String D = Y.substring(len1);
		
		String AC = bigIntMultiply(A, C, len1);
		String AD = bigIntMultiply(A, D, lenm);
		String BC = bigIntMultiply(B, C, lenm);
		String BD = bigIntMultiply(B, D, len2);
		
		String ADBC = addAction(AD, BC);
		String[] sBD = dealString(BD, len2);
		
		if(!"0".equals(sBD[1])){
			ADBC = addAction(ADBC, sBD[1]);
		}
		
		String[] sADBC = dealString(ADBC, lenm);
		if(!"0".equals(sADBC[1])){
			AC = addAction(AD, sADBC[1]);
		}
		res = AC + sADBC[0]+ sBD[0];
		return res;
	}
	
	public static String[] dealString(String s, int len){
		String[] res = {s, "0"};
		if(s.length() > len){
			res[0] = s.substring(0,len);
			res[1] = s.substring(len);
		}
		return res;
	}
	
	public static String addAction (String AD, String BC){
		String ADBC = "";
		ADBC = ""+(Integer.parseInt(AD)+Integer.parseInt(BC));
		return ADBC;
	}
	
	public static String formatNumber(String str, int len){
		if(str.length() == len){
			return str;
		}
		for(int i = 0; i <(len-str.length()); i++){
			str = "0"+str;
		}
		return str;
	}
	
	public static void main(String[] args){
		System.out.println(BigIntMultiply.bigIntMultiply("12345678", "12345678", 8));
	}
}
