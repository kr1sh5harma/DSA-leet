public class Solution{
    public void subSeq(String str, String ans){
        if(str.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = str.charAt(0);
        subSeq(ans+ch, str.substring(1));
        subSeq(ans, str.substring(1));
    }

    public ArrayList<String> subSeq(String str, String ans){
        if(str.isEmpty()){
            ArrayList<String> = new ArrayList<>();
            list.add(ans);
            return list; 
        }

        ArrayList<String> left = subSeq(ans+ch, str.substring(1));
        ArrayList<String> right = subSeq(ans, str.substring(1));

        left.addAll(right);
        return left;
    }
}