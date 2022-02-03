package newsApp;

import java.io.IOException;
import java.util.ArrayList;

public class SpecifiedNews {

	// initiating specified news method for "search" input in the main menu. 
	public ArrayList<News> searchTrending(String searchText, String searchType, ArrayList<News> trending) throws IOException, InterruptedException {
		ArrayList<News> filteredNews = new ArrayList<News>();
		// using if for each user-specified input (either keyword,source,date,language or category input in the "search" menu)
	
		if(searchType.equals("keyword"))
		{
			// Iterating using for loop to show the news
	        for (int i = 0; i < trending.size(); i++)
	        {
	        	if(trending.get(i).title.contains(searchText) || trending.get(i).description.contains(searchText))
	        	{
	        		//create News object (based on retrieved parameters)
	                News filtered = new News(trending.get(i).title,trending.get(i).description,trending.get(i).uploadDate,trending.get(i).url,trending.get(i).country,trending.get(i).category);
	                //store the news into the array list
	                filteredNews.add(filtered);
	                //delete the object
	                filtered = null;
	        	}
	        }
		}
		else if(searchType.equals("source"))
		{
			// Iterating using for loop to show the news
	        for (int i = 0; i < trending.size(); i++)
	        {
	        	if(trending.get(i).title.contains(searchText))
	        	{
	        		//create News object (based on retrieved parameters)
	                News filtered = new News(trending.get(i).title,trending.get(i).description,trending.get(i).uploadDate,trending.get(i).url,trending.get(i).country,trending.get(i).category);
	                //store the news into the array list
	                filteredNews.add(filtered);
	                //delete the object
	                filtered = null;
	        	}
	        }
		}
		else if(searchType.equals("date"))
		{
			// Iterating using for loop to show the news
	        for (int i = 0; i < trending.size(); i++)
	        {
	        	if(trending.get(i).uploadDate.contains(searchText))
	        	{
	        		//create News object (based on retrieved parameters)
	                News filtered = new News(trending.get(i).title,trending.get(i).description,trending.get(i).uploadDate,trending.get(i).url,trending.get(i).country,trending.get(i).category);
	                //store the news into the array list
	                filteredNews.add(filtered);
	                //delete the object
	                filtered = null;
	        	}
	        }
		}
		else if(searchType.equals("language"))
		{
			// Iterating using for loop to show the news
	        for (int i = 0; i < trending.size(); i++)
	        {
	        	if(trending.get(i).country.contains(searchText))
	        	{
	        		//create News object (based on retrieved parameters)
	                News filtered = new News(trending.get(i).title,trending.get(i).description,trending.get(i).uploadDate,trending.get(i).url,trending.get(i).country,trending.get(i).category);
	                //store the news into the array list
	                filteredNews.add(filtered);
	                //delete the object
	                filtered = null;
	        	}
	        }
		}
		else if(searchType.equals("category"))
		{
			// Iterating using for loop to show the news
	        for (int i = 0; i < trending.size(); i++)
	        {
	        	if(trending.get(i).category.contains(searchText))
	        	{
	        		//create News object (based on retrieved parameters)
	                News filtered = new News(trending.get(i).title,trending.get(i).description,trending.get(i).uploadDate,trending.get(i).url,trending.get(i).country,trending.get(i).category);
	                //store the news into the array list
	                filteredNews.add(filtered);
	                //delete the object
	                filtered = null;
	        	}
	        }
		}
		else
		{
			return null;
		}
		
        
		return filteredNews;
    }
	
}
	
	

