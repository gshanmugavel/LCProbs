class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        Integer len = nums2.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[len-1]);
        if(map.containsKey(nums2[len-1])){
            nums1[map.get(nums2[len-1])] = -1;
        }
        System.out.println(map + "-" + len);
        for(int i=len-2; i>=0; i--){
            System.out.println(stack+"-"+i);
            while(!stack.isEmpty() && stack.peek()<= nums2[i]){
                stack.pop();
            }
            if(map.containsKey(nums2[i])){
                if(!stack.isEmpty() && stack.peek() > nums2[i]){
                    nums1[map.get(nums2[i])] = stack.peek();
                }else{
                    nums1[map.get(nums2[i])] = -1;
                }
            }
            stack.push(nums2[i]);
        }
        return nums1;
    }
}