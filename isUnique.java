import java.util.*;

public class isUnique {
    boolean stringisUnique(String str){
        /*compare each character in the string*/
        for(int i = 0; i < str.length(); i++)
            for(int j = i + 1; j < str.length(); j++)
                if(str.charAt(i) == str.charAt(j))
                    return false;
        return true;
    }

    public static void main(String[] args){
        isUnique obj = new isUnique();
        if (obj.stringisUnique("Java Programming")) {
            System.out.println("The string has unique characters");
        }
        else{
            System.out.println("The string has duplicate characters");
        }
    }
}

