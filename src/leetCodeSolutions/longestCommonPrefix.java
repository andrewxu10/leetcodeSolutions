package leetCodeSolutions;

public class longestCommonPrefix { //find the longest common prefix in an array
	public static void main(String[] args) {
		String[] strs = {"bitcha", "bitchass", "bitches"};
		String[] strs1 = {"aa", "a"};
		System.out.println(function(strs1));
	}
	public static String function(String[] strs) {
		if(strs.length == 0) return "";
		for(int j = 0; j < strs[0].length(); j++) {
			String temp = strs[0].substring(0, j+1);
			//System.out.println("temp: " + temp);
	        for(int i = 0; i < strs.length; i++) {
	        	if(j+1 > strs[i].length()) {
	        		return strs[0].substring(0,  j);
	        	}
	        	String compare = strs[i].substring(0, j+1);
	        	//System.out.println("compare: " + compare);
	        	if(!compare.equals(temp)) {
	        		return strs[0].substring(0,  j);
	        	}
	        	if(j == strs[0].length() - 1 && i == strs.length - 1) {
	        		return strs[0];
	        	}
	        }
		}
		return "";
    }
}
