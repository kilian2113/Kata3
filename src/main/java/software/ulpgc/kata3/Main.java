package software.ulpgc.kata3;

import software.ulpgc.kata3.io.HistogramBuilder;
import software.ulpgc.kata3.io.MovieDeserializer;
import software.ulpgc.kata3.io.RemoteMovieLoader;
import software.ulpgc.kata3.model.Histogram;
import software.ulpgc.kata3.model.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new RemoteMovieLoader(MovieDeserializer::fromTsv).loadAll();
        display(new HistogramBuilder(Movie::year).build(movies));
    }

    public static void display(Histogram histogram) {
        for(int key : histogram){
            System.out.println(key + " " + histogram.count(key));
        }
    }
}
