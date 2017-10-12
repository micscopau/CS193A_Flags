package paulygon.flagsoftheworld;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import stanford.androidlib.SimpleActivity;

public class FlagsActivity extends SimpleActivity {
    private static final String[] COUNTRIES = {
            "Australia",
            "Fiji",
            "Germany",
            "Japan",
            "Mexico",
            "Netherlands",
            "USA"
    };

    //instance initializer
    //runs before any other code (on construction)
    {
        setTraceLifecycle(true); //uses the stanford library to allow tracking of onPause, etc.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);


        GridLayout layout = (GridLayout) findViewById(R.id.activity_flags);

        for (String name: COUNTRIES){
            addFlag(name, layout);
        }

    }

    //countryName = "USA"
    private void addFlag(final String countryName, GridLayout layout){

        View flag = getLayoutInflater().inflate(R.layout.flag,
                /*parent*/ null /*layout*/); //null better if want to create the thing, then mess with other settings before adding to screen

        //   findViewById(...); // talking to entire chunk
        flag.findViewById(R.id.flag_text); //talking to just small flag

        TextView tv = (TextView) flag.findViewById(R.id.flag_text);
        tv.setText(countryName);

        String countryName2 = countryName.replace(" ","").toLowerCase(); //convert contry names to lower case and remove whitespace
        int flagImageID = getResources().getIdentifier(countryName2, "drawable", getPackageName());

        ImageButton img = (ImageButton) flag.findViewById(R.id.flag_image);
        img.setImageResource(flagImageID);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                doTheDialog(countryName);
            }
        });

        layout.addView(flag);

    }

    private void doTheDialog(String countryName){
        //Toast.makeText(FlagsActivity.this, "You clicked " + countryName, Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(FlagsActivity.this);
        builder.setTitle("My Dialog");
        builder.setMessage("You clicked " + countryName);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //code to run when OK is pressed
                Toast.makeText(FlagsActivity.this, "You clicked OK", Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
