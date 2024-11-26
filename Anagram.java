public class Anagram {
	public static void main(String args[]) {
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		System.out.println(preProcess("What? No way!!!"));
		
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		String str = "1234567";
		Boolean pass = true;
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	public static boolean isAnagram(String str1, String str2) {
		String newStr1 = preProcess(str1); 
		String newStr2 = preProcess(str2); 
		if (newStr1.length() != newStr2.length()) {
			return false;
		}
		for (int i = 0; i < newStr1.length(); i++) {
			char c = newStr1.charAt(i);
			if (newStr2.indexOf(c) == -1) {
				return false;
			}
			String newStr2Updated = "";
			for (int j = 0; j < newStr2.length(); j++) {
				if (newStr2.charAt(j) != c) {
					newStr2Updated += newStr2.charAt(j); 
				} else {
					break; 
				}
			}
			newStr2 = newStr2Updated; 
		}
		return true;
	}
	
	
	   
	public static String preProcess(String str) {
		String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String s2 = "abcdefghijklmnopqrstuvwxyz";
		String s3 = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (s1.indexOf(c) != -1) {
				s3 += Character.toLowerCase(c);
			} else if (s2.indexOf(c) != -1) {
				s3 += c;
			}
		}
		
		return s3;
	} 
	   
	public static String randomAnagram(String str) {
		String newStr = preProcess(str);
		String newRandomStr = "";
		char temp;
		int index;
		for (int i = 0; i <= newStr.length(); i++) {
			index = (int) (Math.random() * newStr.length());
			while (index <= newStr.length() -i) {
				temp = newStr.charAt(index);
				newRandomStr += temp;
			}
			
		}
		return newRandomStr;
	}
}