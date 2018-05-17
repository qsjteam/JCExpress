package tester;

public class Str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "this  xxx   sss  this";
		String regex = ".*this.*";
		if(str.matches(regex)) {
			System.out.println(1);
		}else {
			System.out.println(2);
		}
	}

}
