import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Stack;

public class StackPalindrome {

	public static boolean isPalindrome(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		if (sb.toString().equals(s)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String propFile = args[0];
		FileReader reader=new FileReader(propFile);  	      
	    Properties p=new Properties();  
	    p.load(reader); 
	    FileWriter fw = new FileWriter( new File( p.get("log_file_name").toString()));
	    String line = p.getProperty("words");
	    String[] words = line.split(",");
	    String output="";
	    for(int i=0;i<words.length;i++){
	    	if(isPalindrome(words[i])){
	    		output=output+words[i]+" is a Palindrome\n";
	    	}else{
	    		output=output+words[i]+" is not a Palindrome\n";
	    	}
	    }
	    fw.write(output);
	    fw.close();
	}

}
