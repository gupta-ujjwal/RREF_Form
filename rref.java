import java.util.scanner;

public class RREF
{


void rep(float a[][],int row,int col,int c)
{
	int i,j;
	float b;
	for(i=c+1;i<row;i++)
	{
		if(a[i][c]!=0)
			break;
	}
	if(i!=row)
	{
	for(j=0;j<=col;j++)
	{
		b=a[c][j];
		a[c][j]=a[i][j];
		a[i][j]=b;
	}}
}
	
void mark(float a[][],int row,int col, int c)
{
	int i;
	for(i=c;i<row;i++)
	{
		if(a[i][c]==0)
			a[i][col]=0;
		else
			a[i][col]=1;
	}
}

void div(float a[][], int row,int col,int c)
{
	int i,j;
	float num;
	for(i=c;i<row;i++)
	{
		if(a[i][col]==1)
		{ 
			num=a[i][c];
			for(j=c;j<col;j++)
			{
				a[i][j]=a[i][j]/num;
			}
		}
	}
}

void sub(float a[][], int row ,int col,int c)
{
	int i,j;
	float num;
	for(i=c+1;i<row;i++)
	{
		if(a[i][col]==1)
		{
			for(j=c;j<col;j++)
				a[i][j]=a[i][j]-a[c][j];
		}
	}
}
public static void main(String args[])
{
	RREF ob =new RREF();
	Scanner in =new Scanner(System.in);
	int row,col,i,j;
System.out.println("enter value of row and column");
row=in.nextInt();
col=in.nextInt();
float a[][]=new float[row][col+1];
System.out.println("Enter values");
for(i=0;i<row;i++)
{
	for(j=0;j<col;j++)
	{
		a[i][j]=in.nextFloat();
	}
}
System.out.println();
i=0;
if(a[0][0]==0)
	ob.rep(a,row,col,i);
for(i=0;i<col-1;i++)
{
	if(i>=row)
		break;
	if(a[i][i]==0)
	{
		ob.rep(a,row,col,i);
	}
ob.mark(a,row,col,i);		
ob.div(a,row,col,i);
ob.sub(a,row,col,i);
}

for(i=0;i<row;i++)
{
	for(j=0;j<col;j++)
		a[i][j]=Math.round(a[i][j]);
}
for(i=0;i<row;i++)
{
	for(j=0;j<col;j++)
		System.out.print((int)a[i][j]+"            ");
	System.out.println();
}
}
}
