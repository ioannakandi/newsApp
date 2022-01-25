package newsApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class apiInterraction {

	public ArrayList<News> trendingNews(String country, String newsCategory) throws IOException { 
		
		ArrayList<News> trending= new ArrayList<News>();
		
		URL url = null;
		
		if(country.equals("mine"))
		{
			//set the country as the one that is set by the system
			country = System.getProperty("user.country").toLowerCase();
		}
		
		//check if category is "show all" and if yes change the url accordingly
		if(newsCategory.equals("show all"))
		{
			url = new URL("https://newsapi.org/v2/top-headlines?country="+country+
					"&apiKey=e044b24f4539454da899784e52aa9c6c");
		}
		else
		{
			// Create a neat value object to hold the URL
			url = new URL("https://newsapi.org/v2/top-headlines?country="+country+"&category="+newsCategory+
					"&apiKey=e044b24f4539454da899784e52aa9c6c");
		}

		// Open a connection(?) on the URL(??) and cast the response(???)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");

		//make the request and store the response as br
		BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		StringBuilder sb = new StringBuilder();
		
		// (append) api response to turn sb to a tangible object
		String output;
		while ((output = br.readLine()) != null) {
		  sb.append(output);
		}
		
		//the API response is a json array, so specific fields are needed from the response and not all of them
		JsonObject object = (JsonObject) new JsonParser().parse(sb.toString());
        JsonArray stories = (JsonArray) object.get("articles");
        for(int i=0; i<stories.size(); i++){
        	try {
        		JsonObject story= (JsonObject) stories.get(i);
        		
                String story_title = story.get("title").getAsString();
                
                //get the story description
                String story_description = story.get("description").getAsString();
                
                //get the story description
                String story_upload = story.get("publishedAt").getAsString();
                
                //get the story description
                String story_url = story.get("url").getAsString();
                
                
                //create News object (based on the retrieved parameters)
                News retrievedStory = new News(story_title,story_description,story_upload,story_url,country,newsCategory);
                //store the news into the array list
                trending.add(retrievedStory);
                //delete the object
                retrievedStory = null;
                
        	}
        	catch(Exception e)
        	{
        		//this try catch is used because some fields from the response might be null
        	}
        	
            
        }	
        //return the array list with the news
        return trending;
		
	}
	
	

}
