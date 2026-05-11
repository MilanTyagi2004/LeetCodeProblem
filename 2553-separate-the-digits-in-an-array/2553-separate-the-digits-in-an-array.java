class Solution {
    public int[] separateDigits(int[] nums) {

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int n = nums[i];
            int temp = n;

            int rn = 0;

            while (n != 0) {
                int dig = n % 10;
                rn = rn * 10 + dig;
                n = n / 10;
            }

            while (temp != 0) {

                int dig = rn % 10;
                al.add(dig);

                rn /= 10;
                temp /= 10;
            }
        }

        int arr[] = new int[al.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = al.get(i);
        }

        return arr;
    }
}