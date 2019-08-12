/**
 * Design an immutable class for representing two-dimensional sparse matrices. 
   Note that for space efficiency you should be storing only non zero elements of a matrix.
 */
public class MatrixOperation {
	private final int matrix[][];
	
	/**
	 * @param mat is the 2-D array
	 */
	public MatrixOperation(int mat[][]) throws Exception {
		if(mat == null)
			throw new Exception(" NUll Value Array Passed");
		if(mat.length == 0)
			throw new Exception(" Empty Array ");
		int i, j, count = 0;
		for( i = 0; i < mat.length ; i++ )
			for( j = 0; j < mat[0].length ; j++ ) 
				if(mat[i][j] != 0){
					count++;
				}
		
		matrix = new int[count][3];
		for( i = 0,count = 0; i < mat.length ; i++ )
			for( j = 0; j < mat[0].length; j++ )
			{	if(0 != mat[i][j]){
						
						matrix[count][0] = i;
						matrix[count][1] = j;
						matrix[count][2] = mat[i][j];
						count++;
					}
			}
	}
	
	/**
	 * @returns return the transpose of the matrix
	 */
	int[][] transpose()
	{
		int transposedMatrix[][] ,i ,j ,k ;
		transposedMatrix= new int[(matrix[matrix.length - 1][1] + 1)][(matrix[matrix.length - 1][0] + 1)];
		for(i = 0 ,k = 0; i < transposedMatrix[0].length ; i++)
			for(j = 0 ; j < transposedMatrix.length ; j++)
			{
					if(matrix[k][0] == i && matrix[k][1] == j){
						transposedMatrix[j][i] = matrix[k][2];
						k++;
					}
					else
						transposedMatrix[j][i] = 0;
				}
		return transposedMatrix;
	}
	
	/**
	 * @returns return true if the matrix is Symmetric i.e. transpose of matrix is same as original 
	 * else it returns false
	 */
	boolean Symmetric()
	{
		boolean isSymmetricMatrix = true; 
		int transposedMatrix[][] = transpose() ,i ,j ,k = -1 ;
		if(transposedMatrix.length != matrix[matrix.length-1][0] + 1)
			 isSymmetricMatrix = false;
		else
			for(i = 0 ; i < transposedMatrix.length ; i++)
				for(j = 0 ; j < (transposedMatrix[0].length) ; j++)
					{
						k++;
						if(i == matrix[k][0] && j == matrix[k][1] && transposedMatrix[i][j] != matrix[k][2])
							isSymmetricMatrix = false; 
					}
					
		return isSymmetricMatrix;
	}
	
	/**
	 * prints the matrix
	 */
	void print()
	{
		System.out.println(" ");
		System.out.println(" ");
		for(int i = 0 ; i < matrix.length ; i++)
		{
			if(i % (matrix[matrix.length - 1][1] + 1) == 0)
				System.out.println(" ");
			System.out.print(" "+ matrix[i][2]);
		}
	}
	
	/**
	 * @returns the array having elements the size of original matrix
	 */
	private int[] size()
	{
		return new int[]{(matrix[matrix.length - 1][0] + 1),(matrix[matrix.length - 1][1] + 1)};
	}
	
	/**
	 * @param index is the position in original matrix whose value has to be found
	 * @returns return the value at given position 
	 */
	private int getValue(int index[])
	{
		for(int i = 0;i < matrix.length; i++ )
			if((matrix[i][0]) == index[0] && (matrix[i][1]) == index[1])
				return	matrix[i][2];
		return 0;
	}
	
	/**
	 * @param m1 and @param m2 are the two matrix whose addition has to be done
	 * @returns return the addition of the two sparse matrix in 2-D array format
	 */
	int[][] addMatrix(MatrixOperation m1,MatrixOperation m2) throws Exception
	{
		if(m1 == null || m2 == null)
			throw new Exception(" NUll Value Object Passed");
		int size1[] = m1.size(), size2[] = m2.size();
		if(size1[0] != size2[0] || size1[1] != size2[1])
		{
			throw new Exception(" both matrix are of different size can't perform addition operation ");
		}
		int add[][] = new int[size1[0]][size1[1]];
		for(int i = 0 ; i < size1[0] ;i++ )
			for(int j = 0; j < size1[1]; j++)
			{
				add[i][j] = m1.getValue(new int[]{i, j}) + m2.getValue(new int[]{i, j});
			}
		return add;
	}
	
	/**
	 * @param m1 and @param m2 are the two matrix whose multiplication has to be done
	 * @returns return the multiplication of the two sparse matrix in 2-D array format
	 */
	int[][] multiplyMatrix(MatrixOperation m1, MatrixOperation m2) throws Exception
	{
		if(m1 == null || m2 == null)
			throw new Exception(" NUll Value Object Passed");
		int size1[] = m1.size(), size2[] = m2.size();
		if(size1[1] != size2[0])
		{
			throw new Exception(" Multiplication Can't be performed ");
		}
		int multiply[][] = new int[size1[0]][size2[1]];
		for(int i = 0  ; i < size1[0] ;i++ )
			for(int j = 0; j < size2[1]; j++)
			{
				multiply[i][j] = 0;
				for(int k = 0; k < size1[1]; k++)
				{
					multiply[i][j] += m1.getValue(new int[]{i, k}) * m2.getValue(new int[]{k, j});
				}
			}	
		return multiply;
	}
	
	
}