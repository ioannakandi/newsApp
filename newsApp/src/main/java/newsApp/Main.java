package newsApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//exception handling using try/catch
		
		try {	
			// array list to store the trending news (to go through them later on)
			ArrayList<News> trending= new ArrayList<News>();
			
			Scanner sc = new Scanner(System.in);
			//while loop to keep asking the user for input (it's like the main menu of the app)
			while (true) {
				System.out.println("~.~"+
						" Enter 'trending' for trending news " +
						"~.~"+
						"\n~.~ Enter 'search' for specified news " + "~.~"+
						
						"\n~.~ or 'quit' to exit "+ "~.~"
						);
				String choice = sc.nextLine();
				if (choice.equals("trending")) {
					//ask the user for their country input
					System.out.println("Please type the country of your liking, or enter 'mine' if you want to use "
							+ "your current location.");
					String country = sc.nextLine();
					//ask the user for their category of choice
					System.out.println("Please type your topic of interest, or enter 'show all' if you'd like all topics.");
					String category = sc.nextLine();
					apiInterraction request = new apiInterraction();
					
					
					trending = request.trendingNews(country.toString(),category.toString());
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
				else if(choice.equals("search")) {
					// menu selection for specified (by the user) search/news. If they typed "search" in the main menu, then this search-oriented menu will be shown
					System.out.println(" ~.~"+
							" Enter 'keyword' to search the title/description for user-specified news " + "~.~" +
							
							"\n ~.~ Type 'source' for source/URL-based search ~.~ " +
							
							"\n ~.~ Type 'date' for date-based search ~.~ "+
						
							"\n ~.~ Type 'category' for category-based search ~.~ "+
							
							"\n ~.~ Type 'language' for language-specific search ~.~ "
							);
					String searchType = sc.nextLine();
					System.out.println("Please enter search term.");
					String searchText = sc.nextLine();
					
					//create object and array list to store the search results
					SpecifiedNews requestfilteredNews = new SpecifiedNews();
					ArrayList<News> filteredNews = new ArrayList<News>();
					filteredNews = requestfilteredNews.searchTrending(searchText.toString(),searchType.toString(),trending);
					
					// Iterating using for loop to show the retrieved news of the user-specified search results.
			        try {
						for (int i = 0; i < filteredNews.size(); i++)
						{
							System.out.print("Title :"+filteredNews.get(i).title + "\n");
						    System.out.print("Description :"+filteredNews.get(i).description + "\n");
						    System.out.print("Date :"+filteredNews.get(i).uploadDate + "\n");
						    System.out.print("URL :"+filteredNews.get(i).url + "\n");
						    System.out.print("Category :"+filteredNews.get(i).category + "\n");
						    System.out.print("Country :"+filteredNews.get(i).country + "\n");
						}
					} catch (Exception e) {
						
						 // printStackTrace method
			            // prints line numbers + call stack
			            e.printStackTrace();
			  
			            // Prints what exception has been thrown
			            System.out.println(e);
				}
					
					
				}
				else if(choice.equals("quit")) {
					//break from while loop and exit the app when "quit" is typed in 
					break;
				}
				else
				{  // error message for unknown input (input not corresponding to any of the menus/choices mentioned above)
					System.out.println("Unidentified text. Try again.");
				}
			}
	} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
