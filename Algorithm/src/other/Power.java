package other;

public class Power {
	public double Power(double base, int exponet){
		int res = 1;
		if(exponet == 0){
			return 1.0;
		}else if( exponet > 0){
			
			for(int i = 0; i < exponet; i++){
				res *= base;
			}
			return res;
		}else{
			if(base == 0) return 0;
			exponet = - exponet;
			for(int i = 0; i < exponet; i++){
				res *= base;
			}
			return (1.0/res);
		}
	}
}