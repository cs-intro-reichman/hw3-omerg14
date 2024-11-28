public class Anagram {
    public static void main(String args[]) {
        System.out.println(isAnagram("silent", "listen"));  // true
        System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
        System.out.println(isAnagram("Madam Curie", "Radium came")); // true
        System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

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
        
        for (int i = 0; i < newStr1.length(); i++) {
            char c = newStr1.charAt(i);
            if (newStr2.indexOf(c) == -1) {
                return false;
            }
            String updatedStr2 = "";
            boolean charFound = false;
            for (int j = 0; j < newStr2.length(); j++) {
                char currentChar = newStr2.charAt(j);
                if (currentChar == c && !charFound) {
                    charFound = true; 
                } else {
                    updatedStr2 += currentChar; 
                }
            }
            newStr2 = updatedStr2;
        }
        return true;
    }

    public static String preProcess(String str) {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String s2 = "abcdefghijklmnopqrstuvwxyz ";
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
		while (newStr.length() > 0) {
			int index = (int) (Math.random() * newStr.length());
			newRandomStr += newStr.charAt(index);
			String tempStr = "";
			for (int i = 0; i < newStr.length(); i++) {
				if (i != index) {
					tempStr += newStr.charAt(i);
				}
			}
			newStr = tempStr; 
		}
		return newRandomStr;
	}
}
