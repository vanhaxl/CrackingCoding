package leetcode.one00_one50;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class A_140_WordBreakII {
    public static void main(String[] args){
        String s = "catsanddog";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("dog");
        wordDict.add("cat");
        wordDict.add("sand");

        System.out.println(wordBreak(s, wordDict));
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    public static List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String word: wordDict){
            if(s.startsWith(word)){
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for(String sub: sublist){
                    res.add(word + (sub.isEmpty()? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

/*

 */
