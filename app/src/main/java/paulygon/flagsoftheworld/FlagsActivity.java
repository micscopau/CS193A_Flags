package paulygon.flagsoftheworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FlagsActivity extends AppCompatActivity {
    private static final String[] COUNTRIES = {
            "Australia",
            "Fiji",
            "Germany",
            "Japan",
            "Mexico",
            "Netherlands",
            "USA"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);

        //add a new button to the screen (using java!)

//        Button bttn = new Button(this);
//        Button bttn2 = new Button(this);
//        Button bttn3 = new Button(this);
//
//        bttn.setText("My Button");
//        bttn2.setText("My other button");
//        bttn3.setText("We don't talk about this button");

        //set button width/height
        //   note that there are subclasses of
        //   ViewGroup.LayoutParams
        //   therefore we can call other functions for formatting

//        //ViewGroup.LayoutParams params = new ViewGroup.LayoutParams( //can also use this line for different functions
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT /*width*/, ViewGroup.LayoutParams.WRAP_CONTENT /*height*/);

//        bttn.setLayoutParams(params);
//        bttn2.setLayoutParams(params);
//        bttn3.setLayoutParams(params);
//
//        bttn.setPadding(40,0,30,20); //note these units probably not the same as "sp"

        //LinearLayout layout = (LinearLayout) findViewById(R.id.activity_flags);
        GridLayout layout = (GridLayout) findViewById(R.id.activity_flags);

//        layout.addView(bttn,1); //layout.addView(bttn,1) // sets index location on layout
//        layout.addView(bttn2);
//        layout.addView(bttn3);

        for (String name: COUNTRIES){
            addFlag(name, layout);
        }

    }

    //countryName = "USA"
    private void addFlag(String countryName, GridLayout layout){

        View flag = getLayoutInflater().inflate(R.layout.flag,
                /*parent*/ null /*layout*/); //null better if want to create the thing, the mess with other settings before adding to screen

        //   findViewById(...); // talking to entire chunk
        flag.findViewById(R.id.flag_text); //talking to just small flag

        TextView tv = (TextView) flag.findViewById(R.id.flag_text);
        tv.setText(countryName);

        //R.drawable.United States
        //int flagImageID = getResources().getIdentifier(countryName, "drawable", getPackageName());

        countryName = countryName.replace(" ","").toLowerCase(); //convert contry names to lower case and remove whitespace

        int flagImageID = getResources().getIdentifier(countryName, "drawable", getPackageName());

        ImageView img = (ImageView) flag.findViewById(R.id.flag_image);
        img.setImageResource(flagImageID);

        layout.addView(flag);

    }
}
