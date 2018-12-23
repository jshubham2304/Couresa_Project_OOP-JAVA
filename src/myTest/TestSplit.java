package myTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import module6.EarthquakeMarker;
import module6.LandQuakeMarker;
import parsing.ParseFeed;
import processing.core.PApplet;

public class TestSplit extends PApplet{
	static String earthquakesURL = "quiz2.atom";
	private static List<Marker> quakeMarkers;

	public void splitText() {
		String[] rows = loadStrings("testSplit");
		//System.out.println(rows[0]);

		for( String row : rows){
			String[] columns = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			System.out.println("Length of columns array: " + columns.length);
			for( int i=0; i<columns.length; i++){
				System.out.println((i+1) + ". " + columns[i]);
			}
			System.out.println("End of line");
			System.out.println("\n\n\n");
		}

	}
	
	   private void sortAndPrint(int numToPrint){
		   
//			 If we're asked to print more items that are available in the array, only print as many items as are available in the array
			   
			   int sizeOfQuakesArr = quakeMarkers.size();
			   
			   if(numToPrint>sizeOfQuakesArr){
				   numToPrint=sizeOfQuakesArr;
			   }
			   
			   System.out.print("Hello shubham");
//			   Check type safety and use a wildcard to create a relationship between the Object class and the EarthquakeMarker class
			   if(quakeMarkers.get(0) instanceof EarthquakeMarker){
				   List<?> arr= quakeMarkers;
				   List<EarthquakeMarker> quakeArr = (List<EarthquakeMarker>) arr;
				   Collections.sort(quakeArr);
				   for(int i=0; i<numToPrint; i++){
					   System.out.println(quakeArr.get(i));
				   }
			   }
		   }
	   
	public static void main(String[] args) {

		//     STEP 3: read in earthquake RSS feed
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(null, earthquakesURL);
	    quakeMarkers = new ArrayList<Marker>();
	    
	    for(PointFeature feature : earthquakes) {
		  //check if LandQuake
	    	System.out.println(feature);
		    quakeMarkers.add(new LandQuakeMarker(feature));
		  }
		 
		
	}

}
