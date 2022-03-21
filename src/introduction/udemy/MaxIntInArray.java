package udemy;

public class MaxIntInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Input: An integer array: [5 8 10 18 15 12 2 1], [5 8 10 18], [18 15 12 2 1]
			//Find the max number

			public int getMaxNumber(int[] numberSequence) {
			    int maxNumber = Integer.MIN_VALUE;
			    
			    if (numberSequence == null || numberSequence.length ==0) {
			        return -1;
			    }
			    
			    for (int i=0; i< numberSequence.length-2; i++) {
			        maxNumber = numberSequence[i];
			        
			        if (maxNumber < numberSequence[i+1]) {
			            maxNumber = numberSequence[i+1];
			        } else {
			            break;
			        }
			    }
			    
			    return maxNumber;
			    
			}


			public int getMaxNumber2(int[] numberSequence) {

			    if (numberSequence == null || numberSequence.length ==0) {
			        return -1;
			    }
			    
			    int maxNumber = Integer.MIN_VALUE;
			    int low = 0;
			    int high = numberSequence.length-1;
			    
			    while (low <= high) {
			        int mid = low+(high-low)/2;
			        
			        maxNumber = numberSequence[mid];
			        
			        if (mid-1>=0 && numberSequence[mid-1] < maxNumber) {
			            low = mid;
			        } else if (mid+1<=numberSequence.length-1 && numberSequence[mid+1] > maxNumber){
			            high = mid;
			        }
			    
			    }
			    
			    return maxNumber;
			    
			}

			/* [5 8 10 18] -- low =0, high = 3, mid = 1 max = 8 , 
			    
			    [18 15 12 2 ] -- low =0, high = 3, mid = 1 max = 15, low =0, high = 1
			    
			    [5 8 10 18 15 12 2 1] -- low =0, high = 7, mid = 3, max = 10
			                             low =3, high = 7, mid = 5, max = 12
			                             low =3, high = 5, mid = 4, max = 15
			                             low =3, high = 4, mid = 3, max = 18 */

}
