import java.util.*;

public class Program {
    boolean isUnique(String str){
        for(int i = 0; i < str.length(); i++)
            for(int j = i + 1; j < str.length(); j++)
                if(str.charAt(i) == str.charAt(j))
                    return false;
        return true;
    }

    public static void main(String[] args){
        Program obj = new Program();
        if (obj.isUnique("Java Programming")) {
            System.out.println("The string has unique characters");
        }
        else{
            System.out.println("The string has duplicate characters");
            }
        }
}

