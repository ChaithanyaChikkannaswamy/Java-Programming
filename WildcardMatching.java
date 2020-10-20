/**
 * @author chaithanyac
 * method to implement '?' and '*' wildcard pattern matching
 */
 
 class Solution {
    public boolean isMatch(String s, String p) {
        String inputString = s;
        String pattern = p;
        
        if(inputString == null || pattern == null){
              return false;
         }

        boolean result[][] = new boolean[pattern.length()+1][inputString.length()+1];
        result[0][0] = true;

        // Mark true or false for empty row
        for(int i = 1; i <= inputString.length(); i++ ){
              result[0][i] = false; 
        }
        // MArk true or false for empty Column
        for(int i = 1; i <= pattern.length(); i++ ){
             if(pattern.charAt(i-1) == '*')
              {
                   result[i][0] = result[i-1][0];
              }else{
                result[i][0] = false; 
              }
        }
        
        for(int i = 1; i <= pattern.length(); i++){
            for(int j = 1; j <= inputString.length(); j++){
                  if(pattern.charAt(i-1) == '*'){
                      result[i][j] = result[i][j-1] || result[i-1][j];
                  }else if(pattern.charAt(i-1) == '?' || 
                      pattern.charAt(i-1) == inputString.charAt(j-1)){
                          result[i][j] = result[i-1][j-1];
                  }
                  else{
                    result[i][j] = false;
                  }
              }
          }
        return result[pattern.length()][inputString.length()];
        
    }
}
