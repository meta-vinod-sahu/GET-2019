
public class LinearBinarySearch {
	/*
	 * @param array is the integer array in which search has to be carried out
	 * @param index is the start index of array
	 * @param key is the element to be searched 
	 * @return returns index of the key if it is present in the array else returns -1
	 */
	public int linearSearch(int [] array, int index, int key) throws Exception {
		if(0 == array.length){
			throw new Exception("Empty Array");
		}
		else if(array.length < index || 0 > index ){
			throw new Exception("Array Index Out Of Bound");
		}
		if(index==array.length)
			return -1;

		if(array[index]==key)
			return index;

		return linearSearch(array,index+1, key);

	}

	/*
	 * @param array is the integer array in which search has to be carried out
	 * @param lowerBound is the start index of array
	 * @param upperBound is the last index of array
	 * @param key is the element to be searched 
	 * @return returns index of the key if it is present in the array else returns -1
	 */
	public int binarySearch(int [] array, int lowerBound, int upperBound, int key) throws Exception {	
		if(0 == array.length){
			throw new Exception("Empty Array");
		}
		else if(array.length < lowerBound || 0 > lowerBound ||array.length < upperBound|| 0 > upperBound ){
			throw new Exception("Array Index Out Of Bound");
		}
		if(lowerBound<upperBound){	
			int middle=(int) (lowerBound+upperBound)/2;
			if(key<array[middle])
				return binarySearch(array,lowerBound,middle-1, key);
			else if(key>array[middle])
				return binarySearch(array,middle+1,upperBound, key);
			else
				return middle;
		}
		return -1;
	}
	
	public static void main(String[] args){
		LinearBinarySearch ln = new LinearBinarySearch();
		int[] arr = new int[]{2,3,6,7,8,9};
		int index;
		try {
			index = ln.binarySearch(arr, 0, arr.length, 10);
			System.out.println("binary Search:"+index);
			index = ln.binarySearch(arr, 0, arr.length, 3);
			System.out.println(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
