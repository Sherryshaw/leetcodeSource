class Solution {
    private int[] candidates;
    private List<List<Integer>> res=new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates=candidates;
        int tmp=target;
        List<Integer> list=new ArrayList();
        getNumber(tmp,list);
        return res;
    }
    private void getNumber(int tmp,List<Integer> list){
        for(int i=0;i<candidates.length;i++){
            int num=Integer.valueOf(tmp);
            List<Integer> tmplist=new ArrayList();
            for(Integer integer:list){
                tmplist.add(integer);
            }
            num-=candidates[i];
            if(num>0){
                tmplist.add(candidates[i]);
                getNumber(num,tmplist);
            }else if(num==0){
                tmplist.add(candidates[i]);
                Collections.sort(tmplist);
                if(!hasSame(res,tmplist))
                res.add(tmplist);
            }
        }
    }
    private boolean hasSame(List<List<Integer>> res,List<Integer> list){
        for(List<Integer> l:res){
            if(isSame(l,list)){
                return true;
            }
        }
        return false;
    }
    private boolean isSame(List<Integer> list1,List<Integer> list2){
        if(list1.size()!=list2.size()){
            return false;
        }
        for(int i=0;i<list1.size();i++){
            Integer i1=list1.get(i);
            Integer i2=list2.get(i);
            if(i1.intValue()!=i2.intValue()){
                return false;
            }
        }
        return true;
    }
}