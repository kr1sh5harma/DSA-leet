// string = "baccad" ans = "bccd"
public class Solution{
    public void skip(String str, String ans){
        if(str.length()==0){
            System.out.print(ans);
            return ;
        }

        char ch = str.charAt(0); 
        if(ch == 'a'){
            skip(str, ans);
        }
        else{
            skip(str.substring(1), ans+ch); 
        }

    }

    public String skip(String str){
        if(str.length()==0){
            return "";
        }

        char ch = str.charAt(0);
        if(ch=='a') return skip(str.substring(1));
        return ch+skip(str.substring(1));
    }
}