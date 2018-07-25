package sg.edu.rp.c346.p10mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by 17010617 on 25/7/2018.
 */

public class Movie_Details extends AppCompatActivity {

    TextView tvTitle;
    TextView tvDetails;
    TextView tvDesc;
    TextView tvDate;
    TextView tvTheatre;
    ImageView imageView1;
    RatingBar starRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__details);

        tvTitle = findViewById(R.id.textViewTitle);
        tvDetails = findViewById(R.id.textViewGenre);
        tvDesc = findViewById(R.id.textViewDescription);
        tvDate = findViewById(R.id.textViewWatchedOn);
        imageView1 = findViewById(R.id.imageViewRated);
        tvTheatre = findViewById(R.id.textViewTheatre);
        starRate = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();
        tvTitle.setText(intentReceived.getStringExtra("title"));
        tvDetails.setText((intentReceived.getStringExtra("year")) + " - " + (intentReceived.getStringExtra("genre")));
        tvDesc.setText((intentReceived.getStringExtra("desc")));
        tvDate.setText("Watch on: " + (intentReceived.getStringExtra("watchDate")));
        tvTheatre.setText("In-Theatre: " + (intentReceived.getStringExtra("theatre")));
        String rating = intentReceived.getStringExtra("rated");

        int stars = intentReceived.getIntExtra("star", 0);
        starRate.setRating(stars);

        if(rating.equalsIgnoreCase("g")){
            imageView1.setImageResource(R.drawable.rating_g);
        }
        else if (rating.equalsIgnoreCase("pg")){
            imageView1.setImageResource(R.drawable.rating_pg);
        }
        else if (rating.equalsIgnoreCase("pg13")){
            imageView1.setImageResource(R.drawable.rating_pg13);
        }
        else if (rating.equalsIgnoreCase("m18")){
            imageView1.setImageResource(R.drawable.rating_m18);
        }
        else if (rating.equalsIgnoreCase("nc16")){
            imageView1.setImageResource(R.drawable.rating_nc16);
        }
        else if (rating.equalsIgnoreCase("r21")){
            imageView1.setImageResource(R.drawable.rating_r21);
        }



    }

}
