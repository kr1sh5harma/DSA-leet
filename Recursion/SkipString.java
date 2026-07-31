// str = "abcappledef" ans = "abcdef"
public class Solution{
    public String skipString(String str){
        if(str.isEmpty()) return "";
        if(str.startsWith("apple")) return skipString(str.substring(5));
        return str.charAt(0) + skipString(str.substring(1));
    }
}