class Solution {
    public int numTeams(int[] rating) {
        TreeSet<Integer>tset=new TreeSet<>();
        TreeSet<Integer>set2=new TreeSet<>();
        int total=0;
        for(int i:rating){
            tset.add(i);
        }
        for(int i=0;i<rating.length;i++){
            tset.remove(rating[i]);
            set2.add(rating[i]);
            if(i!=0){
                int lower=set2.subSet(Integer.MIN_VALUE,rating[i]).size();
                int higher=tset.subSet(rating[i]+1,Integer.MAX_VALUE).size();
                total+=(lower*higher);
                int l=tset.subSet(Integer.MIN_VALUE,rating[i]).size();
                int r=set2.subSet(rating[i]+1,Integer.MAX_VALUE).size();
                total+=(l*r);
            }
        }
        return total;
    }
}