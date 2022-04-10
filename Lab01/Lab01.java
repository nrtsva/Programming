/* Lab01.java */

public class Lab01 
{
  public static void main( String[] args ) 
  {
	int[] A = {3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23};
   	float[] X = new float[18];
	float[][] Res = new float[11][18];
	
	for (int i = 0; i < X.length; i++)
	  X[i] = (float)((8.0 + 3.0) * Math.random() - 3.0);
  
	//for (int i = 0; i < 18; i++)
	//  System.out.println(X[i]);
    //System.out.println("");

	for (int i = 0; i < 11; i++)
	  for (int j = 0; j < 18; j++)
	  {
	  	switch(A[i])
		{
	    case 5:
	  	  double x1 = Math.tan(Math.pow(X[j], X[j])),
	  		     x2 = Math.pow(Math.E, Math.pow(X[j] / 2, 3)) + 1.0 / 3.0,
	  		     x3 = Math.pow(Math.tan(X[j]) * (1.0 / 4.0 + 2 / (1 - X[j])), 3);
	  	    
	  	  Res[i][j] =(float)Math.pow(x1, x2 / x3);
	  	  break;
	  	case 3:
		case 15:
		case 17:
		case 19:
		case 21:
	  	  Res[i][j] = (float)Math.asin(Math.sin(Math.exp(Math.abs(X[j]))));
	      break;
	  	default:
	  	  double x4 = (X[j] / 2 + 1.0 / 4.0) / Math.tan(X[j]),
	  	         x5 = Math.pow(X[j] * (X[j] - 1.0 / 3.0), 2),
	  	         x6 = Math.sin(Math.pow(x4, x5));
	  	  Res[i][j] = (float)Math.cbrt(x6);
	  	}
	  }
	
	for (int i = 0; i < 11; i++)
	{
	  for (int j = 0; j < 18; j++)
	  {
	  	String str = String.format("%.5f ", Res[i][j]);
	  	System.out.print(str);
	  }
	  System.out.println("");
	}
  }
}