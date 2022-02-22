import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class 剑指OfferII_1 {

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0; i < s.length();i++){
            char cha = s.charAt(i);
            if((cha-'a'>=0 && cha-'z'<=0) || (cha-'0'>=0 && cha-'0'<=9)){
                sb.append(cha);
            }
        }

        String str = sb.toString();

        int i =0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome( "A man, a plan, a canal: Panama"));
        List<Integer> res = new ArrayList<>();
        res.size();

    }
}
