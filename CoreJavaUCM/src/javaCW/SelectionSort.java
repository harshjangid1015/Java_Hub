package javaCW;

public class SelectionSort {
	public static void main(String[] args) {
		int nums[] = {5,2,-3,10,1,6};
		int minIndex;

		for (int a=0; a<nums.length-1; a++) {
			minIndex = a;

			for(int b= a+1; b<nums.length;b++) {
				//if new challanger is smaller than min value
				// then minIndex becomes that position
				if(nums[b] < nums[minIndex])
					minIndex=b;

			}
			// exchange nums[a] with nums[minIndex]
			int t = nums[a];
			nums[a] = nums[minIndex];
			nums[minIndex]=t;
		}
		for (int i=0; i<nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}

