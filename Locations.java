public class Locations {
    //make places voor edges.
    public static int n = 5;
    
    //init amount of vertices
    public static int m = 8;
    
    public static int[][]  places = new int[m][2];
	
    public static void main (String[] args) {
		int[] connected = new int[n];
		int[] connector = new int[n];
            
        // get random connections for the edges
        for( int i = 0; i < n; i ++) {
			// get random places
			connected[i] = (int)(Math.random() * ((m - 1) + 1)) + 1;
			// get new random for new place
			int h = connected[i];
			int k = connected[i];
			while(h == k)
				h = (int)(Math.random() * ((m - 1) + 1)) + 1;
            
			connector[i] = h;
            
			for(int t = 0; t < i; t++) {
				while (connector[t] == connector[i] && connected[t] == connected[i]) {
					connected[i] = (int)(Math.random() * ((m - 1) + 1)) + 1;
				}
			}
		}
	
		// print out connections for checking
		for( int i = 0; i < connected.length; i ++) { 
			System.out.print( connected[i] );
			System.out.println( " "+connector[i]);    
		}
        
		// init some more stuff
		int[][] places = new int[m][2];
	
		//Start given them coordinates based on edges
		for ( int i = 0; i < m; i++) {
	        // this is to cycly through all the places.
	        // check if places[i][] is connected to any other.
	        int connectedToX = checkerX(i+1, connected, connector);
	        int connectedToY = checkerY(i+1, connected, connector);
	        int Maxdistance = 300;
	        System.out.println(connectedToX);
	        System.out.println(connectedToY);
	        if (connectedToX > 0  && connectedToY > 0) {
            
	            int Xmax = places[connectedToX][0] + Maxdistance;
	            int Xmin = places[connectedToX][0]-Maxdistance;
            
	            int Ymax = places[connectedToY][1]+Maxdistance;
	            int Ymin = places[connectedToY][1] -Maxdistance;
            
            
	            //System.out.print(Xmax);
	            //System.out.println("  "+Xmin);
	            //System.out.print(Ymax);
	            //System.out.println("  "+Ymin + "\n");
            
            
	            if (places[connectedToX][0] + Maxdistance > 1000){
	                Xmax = 1000;
	            }
                
	            if (places[connectedToX][0]- Maxdistance < 0){
	                Xmin = 1;
	            }  
            
	            if (places[connectedToY][1]+ Maxdistance > 1000){
	                Ymax = 1000;
	            }
            
	            if (places[connectedToY][1] -Maxdistance < 0){
	                Ymin = 1;
	            }
        
	            System.out.print(Xmax);
	            System.out.println("  "+Xmin);
	            System.out.print(Ymax);
	            System.out.println("  "+Ymin);
            
            
	            places[i][0] = (int)(Math.random() * ((Xmax - Xmin) + 1)) + Xmin;
	            places[i][1] = (int)(Math.random() * ((Ymax - Ymin) + 1)) + Ymin;
	        } else {
				// get random places
				places[i][0] = (int)(Math.random() * ((1000 - 1) + 1)) + 1;
				places[i][1] = (int)(Math.random() * ((1000 - 1) + 1)) + 1;
			}
			//System.out.println(places[connectedTo][0]);
			//System.out.println(places[connectedTo][1]);
		}
        
		for (int i = 0; i < places.length; i ++) {
			System.out.print(places[i][0]);
			System.out.println(" " + places[i][1]);         
		}
	}
    
    public static int checkerX(int place, int[] connected, int[] connector) {
        int connections =  0;
        //System.out.println(connected[1]); 
        for ( int i = 0; i < n; i++) {
			if(connected[i] == place){
				connections = places[connector[i]- 1][0];
			}
			
			if( connector[i] == place){
				connections = places[connected[i]- 1][0];
			}
                
			// System.out.println(places[connected[i]- 1][0]);
        }
        
        return connections;
    }
    
    public static int checkerY(int place, int[] connected, int[] connector) {
        int connections =  0;
        
        for ( int i = 0; i < n; i++) {
            if(connected[i] == place){
				connections = places[connector[i]-1][1];
				System.out.println( "XD"); 
				return connections;
			}
                
			if( connector[i] == place){                    
				connections = places[connected[i]-1][1];
				return connections;
			}
        }
        return connections;
    }
}