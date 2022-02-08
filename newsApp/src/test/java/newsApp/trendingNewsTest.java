package newsApp;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;


import org.junit.Test;

public class trendingNewsTest {

	@Test
	public void testTrendingNews() throws IOException 
 { 
		ArrayList<News> trending= new ArrayList<News>();
		apiInterraction request = new apiInterraction();
		
		
		trending = request.trendingNews("us","business");
		// Iterating using for loop to show/display the news
        for (int i = 0; i < trending.size(); i++)
        {
        	// Printing and display the elements in ArrayList mentioned above
	        System.out.print("Title :"+trending.get(i).title + "\n");
	        System.out.print("Description :"+trending.get(i).description + "\n");
	        System.out.print("Date :"+trending.get(i).uploadDate + "\n");
	        System.out.print("URL :"+trending.get(i).url + "\n");
	        System.out.print("Category :"+trending.get(i).category + "\n");
	        System.out.print("Country :"+trending.get(i).country + "\n");
	        
        }
		
	}
	
}
	

	