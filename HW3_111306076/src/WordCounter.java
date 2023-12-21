import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

public class WordCounter {
	private String urlStr;
    private String content;
    
    public WordCounter(String urlStr){
    	this.urlStr = urlStr;
    }
    
    private String fetchContent() throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
		String retVal = "";
	
		String line = null;
		
		while ((line = br.readLine()) != null){
		    retVal = retVal + line + "\n";
		}
	
		return retVal;
    }
    
    public int BoyerMoore(String T, String P){
        int i = P.length() -1;
        int j = P.length() -1;
        
        // Bonus: Implement Boyer-Moore Algorithm   
        while(i < T.length()) {
        	
	        if(P.substring(j,j+1).equals(T.substring(i,i+1))) {
	        	if(j == 0) {
	        		return i;
	        	}
	        	else {
	        		j--;
	        		i--;
	        	}
	        }
	        else {
	        	int l = last(T.charAt(i), P);
	        	i = i + P.length() - min(j, 1+l);
	        	j = P.length() - 1;
	        }
	    	
        }
        return -1;
    }

    public int last(char c, String P){
    	// Bonus: Implement last occurence function
    	int lastOccr = -1;
    	for(int i = 0 ; i < P.length() ; i++) {
    		if(P.substring(i,i+1).equals(Character.toString(c))) {
    			lastOccr = i;
    		}
    	}
    	
    	return lastOccr;
    	
    }

    public int min(int a, int b){
        if (a < b)
            return a;
        else if (b < a)
            return b;
        else 
            return a;
    }
    
    public int countKeyword(String keyword) throws IOException{
		if (content == null){
		    content = fetchContent();
		}
		
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
	
		int retVal = 0; 
		// 1. calculates appearances of keyword (Bonus: Implement Boyer-Moore Algorithm)
		int i = BoyerMoore(content, keyword);
//		int i = content.indexOf(keyword);
		while(i != -1) {
			retVal++;
			content = content.substring(i + keyword.length(), content.length());
			i = BoyerMoore(content, keyword);
//			i = content.indexOf(keyword);
		}
	
		return retVal;
    }
}
