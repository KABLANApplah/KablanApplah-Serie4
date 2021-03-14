package Kablan.Serie_7.Exo15;


// Je suis en Binome avec Bah Cherif Younouss donc toutes les series que j'ai deposé et que je deposerai ca sera avec lui depuis la serie 0
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;


public class Exo15 {

	public static void main(String[] args) {
	
		        ActorsAndMovies actorsAndMovies = new ActorsAndMovies();
		        Set<Movie> movies = actorsAndMovies.readMovies();
		        
		        System.out.println("*~~~~~~~~~~Question 1~~~~~~~~~~~~~~~~~~~~*\n");
		        System.out.println("movies.size() = " + movies.size());
		        System.out.println("\n");
		        
		        System.out.println("*~~~~~~~~~~Question 2~~~~~~~~~~~~~~~~~~~~*\n");
		        List<Actor> actors1 = 
		        movies.stream()
		        	.flatMap(movie -> movie.actors().stream())
		        	.collect(Collectors.toList());
		        System.out.println("# actors = " + actors1.size());
		        
		        Set<Actor> actors = 
		        movies.stream()
		        	.flatMap(movie -> movie.actors().stream())
		        	.collect(Collectors.toSet());
		        System.out.println("# actors = " + actors.size());
		        
		        long numberOfActors = 
		        movies.stream()
					.flatMap(movie -> movie.actors().stream())
					.distinct()
					.count();
		        System.out.println("count actors = " + numberOfActors);
		        
		        System.out.println("*~~~~~~~~~~Question 3~~~~~~~~~~~~~~~~~~~*"); 
		        long numberOfYears = 
		        movies.stream()
		        	.map(movie -> movie.releaseYear())
		        	.distinct()
		        	.count();
		        System.out.println("number of years = " + numberOfYears);
		        
		        System.out.println("*~~~~~~~~~~Question 4~~~~~~~~~~~~~~~~~~~*");
		        Comparator<Movie> comparator1 =
		        		Comparator.comparing(movie -> movie.actors().size());
		        
		        
		        System.out.println("*~~~~~~~~~~Question 6~~~~~~~~~~~~~~~~~~~~*");
		        Comparator<Movie> comparator =
		        		Comparator.comparing(movie -> movie.actors().size());
				Movie movieWithMaxActors = 
		        		movies.stream()
				        	.max(comparator)
				        	.orElseThrow();
		        System.out.println("Movie with max actors = " + movieWithMaxActors.title());
		        System.out.println("# actors = " + movieWithMaxActors.actors().size());
		        
		        System.out.println("*~~~~~~~~~~Question 7~~~~~~~~~~~~~~~~~~~~*");
		        Map<Actor, Long> map = 
			        movies.stream()
						.flatMap(movie -> movie.actors().stream())
						.collect(
								Collectors.groupingBy(
										Function.identity(), 
										Collectors.counting()
								)
						);
		        Actor cate = new Actor("Blanchett", "Cate");
		        System.out.println("Cate Blanchett : " + map.get(cate));
		        Actor legolas = new Actor("Bloom", "Orlando");
		        System.out.println("Bloom Orlando : " + map.get(legolas));
		        
		        Map.Entry<Actor, Long> entry = 
			        map.entrySet().stream()
				        .max(Comparator.comparing(Map.Entry::getValue))
				        .orElseThrow();
		        System.out.println("Entry = " + entry);
		        
		        System.out.println("*~~~~~~~~~~Question 8~~~~~~~~~~~~~~~~~~~~*");

		        @SuppressWarnings("unused")
				Map.Entry<Actor, Long> maxEntry = 
			        movies.stream()
						.flatMap(movie -> movie.actors().stream())
						.collect(
								Collectors.groupingBy(
										Function.identity(), 
										Collectors.counting()
								)
						).entrySet().stream()
				        .max(Comparator.comparing(Map.Entry::getValue))
				        .orElseThrow();
		        
		        Collector<Movie, ?, Entry<Actor, Long>> myAwesomeCollector = 
		        		Collectors.collectingAndThen(
								Collectors.flatMapping(
										movie -> movie.actors().stream(), 
										Collectors.groupingBy(
												Function.identity(), 
												Collectors.counting()
										)
								), 
								m -> m.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
							    .orElseThrow()
							);
				Map.Entry<Actor, Long> maxEntry2 = 
		        movies.stream().collect(myAwesomeCollector);
		        System.out.println("maxEntry2 = " + maxEntry2);
		        
		        
		        Map<Integer, Entry<Actor, Long>> mapPerYear = movies.stream()
		        	.collect(
		        			Collectors.groupingBy(
		        					Movie::releaseYear, 
		        					myAwesomeCollector
		        			)
		        	);
		        
		        System.out.println("\n1970 - 1990");
		        Set<Entry<Integer,Entry<Actor,Long>>> entrySet = mapPerYear.entrySet();
		        for (Entry<Integer, Entry<Actor, Long>> entry2 : entrySet) {
					if (entry2.getKey() > 1970 && entry2.getKey() < 1990) {
						System.out.println(entry2);
					}
				}
		        
		        Entry<Integer, Entry<Actor, Long>> entry2 = 
		        		mapPerYear.entrySet().stream()
				        	.max(Comparator.comparing(e -> e.getValue().getValue()))
				        	.orElseThrow();
		        System.out.println("entry 2 = " + entry2);
		        
		    }

		    public Set<Movie> readMovies() {

		        Function<String, Stream<Movie>> toMovie =
		                line -> {
		                    String[] elements = line.split("/");
		                    String title = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
		                    String releaseYear = elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));
		                    if (releaseYear.contains(",")) {
		                        
		                    	int indexOfComa = releaseYear.indexOf(",");
		                    	releaseYear = releaseYear.substring(0, indexOfComa);
		                        
		                    }
		                    Movie movie = new Movie(title, Integer.valueOf(releaseYear));


		                    for (int i = 1; i < elements.length; i++) {
		                        String[] name = elements[i].split(", ");
		                        String lastName = name[0].trim(); 
		                        String firstName = "";
		                        if (name.length > 1) {
		                            firstName = name[1].trim();
		                        }

		                        Actor actor = new Actor(lastName, firstName);
		                        movie.addActor(actor);
		                    }
		                    return Stream.of(movie);
		                };

		        try (FileInputStream fis = new FileInputStream("files/movies-mpaa.txt.gz");
		             GZIPInputStream gzis = new GZIPInputStream(fis);
		             InputStreamReader reader = new InputStreamReader(gzis);
		             BufferedReader bufferedReader = new BufferedReader(reader);
		             Stream<String> lines = bufferedReader.lines();
		        ) {

		            return lines.flatMap(toMovie).collect(Collectors.toSet());

		        } catch (IOException e) {
		            System.out.println("e.getMessage() = " + e.getMessage());
		        }

		        return Set.of();
		    }
		
	

}
