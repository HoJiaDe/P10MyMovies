package sg.edu.rp.c346.p10mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movies> alMovies;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovies);


        alMovies = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2014, 10, 15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015, 4, 15);

        Movies item1 = new Movies("The Avengers", "2012", "pg13", "Action | Sci-Fi", date1, 4, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        Movies item2 = new Movies("Planes", "2013", "pg", "Animation | Comedy", date2,2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race..");
        alMovies.add(item1);
        alMovies.add(item2);

        caMovie = new CustomAdapter(this, R.layout.movie_item, alMovies);

        lvMovie.setAdapter(caMovie);


        lvMovie.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getBaseContext(), Movie_Details.class);
            Movies currentMovie = alMovies.get(position);
            intent.putExtra("title", currentMovie.getTitle());
            intent.putExtra("year", currentMovie.getYear());
            intent.putExtra("genre", currentMovie.getGenre());
            intent.putExtra("desc", currentMovie.getDescription());
            intent.putExtra("rated", currentMovie.getRated());

            intent.putExtra("watchDate", getDateString(currentMovie.getWatched_on()));
            intent.putExtra("theatre", currentMovie.getIn_theatre());
            intent.putExtra("star", currentMovie.getRating());
            startActivity(intent);
        });



    }
    public static String getDateString(Calendar date) {
        String str = date.get(Calendar.DAY_OF_MONTH)+"/"+date.get(Calendar.MONTH)+"/"+date.get(Calendar.YEAR);
        return str;
    }

}