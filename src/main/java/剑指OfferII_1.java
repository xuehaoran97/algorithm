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

        System.out.println((Integer.toBinaryString(Integer.MIN_VALUE >> 1 )));

        System.out.println((Integer.toBinaryString(Integer.MIN_VALUE  )));

        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10 >>>10));


        System.out.println(-10>>>2);
//        System.out.println((-1<<31));
//        System.out.println(Integer.toBinaryString(-2147483648));

        System.out.println(1>Integer.MIN_VALUE);
        System.out.println(1-Integer.MIN_VALUE>=0);
        System.out.println(Math.abs(Integer.MIN_VALUE));


    }
}
