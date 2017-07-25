package leetCodeSolutions;

//#9 Determine whether an integer is a palindrome. Do this without extra space.
public class PalindromeNumber {
	
	public static void main(String[] args) {
		int i = 442244;
		System.out.println(isPalindrome(i));
	}
 	
	public static boolean isPalindrome(int x) {
		char[] num = ("" + x).toCharArray();
		return recursion(num, 0, num.length - 1);
    }
	
	public static boolean recursion(char[] num, int start, int end) {
		if(num.length%2 == 0 && start+1 == end) {
			return num[start] == num[end];
		}
		if(num.length%2 == 1 && start == end) {
			return true;
		}
		if(num[start] == num[end]) {
			start++; end--;
			return recursion(num, start, end);
		} else {
			return false;
		}
	}
}