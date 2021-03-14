package Kablan.Serie_7.Exo15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public class ActorsAndMovies {

	public static void main(String[] args) {
		
		        ActorsAndMovies actorsAndMovies = new ActorsAndMovies();
		        Set<Movie> movies = actorsAndMovies.readMovies();
		        System.out.println("movies.size()) = " + movies.size());

		    }

		    public Set<Movie> readMovies() {

		        Function<String, Stream<Movie>> toMovie =
		                line -> {
		                    String[] elements = line.split("/");
		                    String title = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
		                    String releaseYear = elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));
		                    if (releaseYear.contains(",")) {
		                        // Movies with a coma in their title are discarded
		                        return Stream.empty();
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
