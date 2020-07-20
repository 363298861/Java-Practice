package Leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class No127WordLadder {
    int length = (1 << 31) - 1;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> list = new ArrayList<>();
        ladderLength(beginWord, endWord, wordList, list);
        if(length == (1 << 31) - 1) return 0;
        return length + 1;
    }

    public boolean isSimilar(String a, String b){
        int different = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i))
                different++;
        }
        return different == 1;
    }

    public void ladderLength(String beginWord, String endWord, List<String> wordList, List<String> list){

        if(!list.isEmpty() && list.get(list.size() - 1).equals(endWord) && list.size() < length){
            length = list.size();
            return;
        }
        String tmp;
        for(int i = 0; i < wordList.size(); i++){
            tmp = wordList.get(i);
            if(isSimilar(tmp, beginWord) && !list.contains(tmp)){
                list.add(tmp);
                ladderLength(tmp, endWord, wordList, list);
                list.remove(tmp);
            }
        }
    }

    public int ladderLengthModified(String beginWord, String endWord, List<String> wordList){
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(beginWord);
        int ladder = 1;
        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i = 0; i < l; i++){
                String s = queue.poll();
                if(s.equals(endWord)) return ladder;
                set.add(s);
                for(int j = 0; j < wordList.size(); j++){
                    if(!set.contains(wordList.get(j)) && isSimilar(s, wordList.get(j))){
                        queue.add(wordList.get(j));
                    }
                }
            }
            ladder++;
        }
        return 0;
    }

    public int ladderLengthModified2(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>(wordList), vis = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int ladder = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String s = queue.poll();
                if(s.equals(endWord)) return ladder;
                for(int j = 0; j < s.length(); j++){
                    char[] sArray = s.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(sArray[j] == ch) continue;
                        sArray[j] = ch;
                        String tmp = new String(sArray);
                        if(set.contains(tmp) && vis.add(tmp)) queue.add(tmp);
                    }
                }
            }
            ladder++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        String[] wordList2 = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> l = Arrays.asList(wordList);
        No127WordLadder wl = new No127WordLadder();
        System.out.println(wl.ladderLengthModified2("hit", "cog", l));
    }
}
