public class 剑指offer50 {
    public static char firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }

        }
        return ' ';

    }

    public static void main(String[] args) {
        String s = "abaaxxxxccccc";
        char c = firstUniqChar(s);
        System.out.println(c);
    }


}
