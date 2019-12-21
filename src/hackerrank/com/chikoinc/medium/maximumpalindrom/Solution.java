package hackerrank.com.chikoinc.medium.maximumpalindrom;

import java.util.*;

public class Solution {
    
    static String str;
    static int len;
    int mod = 1000000007;

    static void initialize(String s) {
        // This function is called once before all queries.
        str = s;
        len = s.length();
    }

    static int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        
        String s = str.substring(l-1,r);
        
        int l1 = s.length();
        
        //System.out.println(" sss " + s);
        
        HashSet<Character> hs1 = new HashSet<>();
        int count = 0;
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<l1;i++){
            char c = s.charAt(i);
            hs1.add(c);
            if(hs.contains(c)){
                hs.remove(c);
                count++;
            }else{
                hs.add(c);
            }
        }
        int sz = hs1.size();
        int max = 0;
        if(!hs.isEmpty()) max =  count*2+1;
        else max = count*2;
        if(max == 0){
            return 0;
        }
        
        ///*
        if(sz == 4){
            return l1;
        }else if(sz == 2){
            if(l1 == 4){
                return 2;
            }else if(l1 == 3){
                return 1;
            }else if (l1 == 2){
                return 2;
            }
        }else if(sz == 3){
            if(l1 == 4){
                return 2;
            }else if(l1 == 3){
                return 3;
            }
        }else if(sz == 1){
            return 1;
        }
        //*/
        return l1;
    }
    


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        initialize(s);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            int result = answerQuery(l, r);
            System.out.println(result);
        }
        in.close();
    }
}