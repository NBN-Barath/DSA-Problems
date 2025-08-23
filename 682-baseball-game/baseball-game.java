class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for(String i : operations) {
            if(i .equals ("D")){
                list.add(list.get(list.size() - 1) * 2);
            } else if(i .equals("C")){
                list.remove(list.size() - 1);
            } else if(i .equals("+")){
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else{
                list.add(Integer.parseInt(i));
            }
        }
        int res = 0;
        for(int n : list){
            res += n;
        }
        return res;
    }
}