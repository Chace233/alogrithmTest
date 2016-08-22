package other;

public class JumpFloor {
    public int JumpFloor(int target) {
    	if(target < 1) return 0;
    	if(target == 1) return 1;
    	if(target == 2) return 2;
    	return JumpFloor(target-1)+JumpFloor(target-2);
    }
    
    public static void main(String[] args){
    	JumpFloor j = new JumpFloor();
    	System.out.print(j.JumpFloor(3));
    }
}
