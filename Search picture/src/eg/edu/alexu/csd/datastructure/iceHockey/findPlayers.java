package eg.edu.alexu.csd.datastructure.iceHockey;
import java.awt.Point;
public class findPlayers {
  java.awt.Point[] findPlayers(String[] photo,int team,int threshold){
	  char [][] a=new char[photo.length][photo[1].length()];
	  int [][]  b=new int[a.length+2][a[1].length+2];
	  Point[] c=new Point[1000];int i,j;
	  for(i=0;i<500;i++) 
		  c[i]=new Point(-1,-1);
		  for(i=0;i<photo.length;i++) {
			for(j=0;j<photo[1].length();j++)
				a[i][j]=photo[i].charAt(j);
		}
	    	for(i=0;i<a.length;i++) {
	    		for(j=0;j<a[1].length;j++) {
	    			if(Character.getNumericValue(a[i][j])==team)
	    				b[i+1][j+1]=1;
	    			else
	    				b[i+1][j+1]=0;
	    		}
	    	}
	    	int n=0,xmin,xmax,ymin,ymax,o=0;;Integer l;boolean found;
        while(n!=(b.length-2)*(b[1].length-2)) {
        	xmin=0;xmax=0;ymin=0;ymax=0;found=false;n=0;
        	int p=0;found=false;
        	for(i=1;i<b.length-1;i++) {
        		j=1;
        		while(j<b[1].length-1) {
        			if(b[i][j]==1&&found==false) {
        				b[i][j]=2;j++;p++;found=true;
        			}
        			if(b[i][j]==1) {
        				if(b[i][j-1]==2||b[i][j+1]==2||b[i-1][j]==2||b[i+1][j]==2) {
        					b[i][j]=2;j++;p++;
        				}
        				else j++;
        			}
        			else j++;
        			
        		}
        		j=b[1].length-2;
        		while(j>=1) {
        			if(b[i][j]==2&&b[i][j-1]==1) {
        				b[i][j-1]=2;j--;p++;
        			}
        			else j--;
        		}
        	}
        	if(p*4>=threshold) {
        		o++;
        		l=p*4;
        	}
        	else
        		l= null;
           if(l!=null) {
        		 i=1;j=1;found=false;
         		while(i<b.length-1) {
         			if(found==false) {
         			   while(j<b[1].length-1&&found==false) {
         				  if(b[i][j]==2) {
         					xmin=xmax=j;
         					ymin=ymax=i;
         					j++;found=true;break;
         				   }
         				   else j++;
         			   }
         			   j=1;
         			 }
         			else break;
         			i++;
         		}
         		i=1;
         		while(i<b.length-1) {
         			while(j<b[1].length-1) {
         				if(b[i][j]==2) {
         				if(j<xmin) xmin=j;
         				else if(j>xmax) xmax=j;
         				else if(i<ymin) ymin=i;
         				else if(i>ymax) ymax=i;
         				j++;
         				}
         				else j++;
         			}
         			j=1;i++;
         		}
         		i=o-1;
               c[i].x=xmin+xmax-1;c[i].y=ymin+ymax-1;
         	   for(i=1;i<b.length-1;i++) {
         		for(j=1;j<b[1].length-1;j++) {
         			if(b[i][j]==2) b[i][j]=0;
         			if(b[i][j]==0) n++;
         		}
         	}
          }
        	else {
        		for(i=1;i<b.length-1;i++) {
             		for(j=1;j<b[1].length-1;j++) {
             			if(b[i][j]==2) b[i][j]=0;
             			 if(b[i][j]==0) n++;
             		}
             	}
          }
        }
        Point[]s=new Point[o];
        for(i=0;i<o;i++)
        	s[i]=new Point(-1,-1);
        for(i=0;i<o;i++) {
        	s[i].x=c[i].x;s[i].y=c[i].y;
        }
		return s;
	 
}
}
