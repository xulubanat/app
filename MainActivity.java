package administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button hotelSearch;
    private EditText usrN;
    EditText passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hotelSearch = (Button)findViewById(R.id.button);


        hotelSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                usrN = (EditText)findViewById(R.id.username);
                passw = (EditText)findViewById(R.id.password);

                final String userN = usrN.getText().toString();
                final String passW = String.valueOf(passw.getText());
                if(userN.equals("a") && passW.equals("a"))
                {
                    Intent classIntent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(classIntent);
                }
                else
                    Toast.makeText(getApplicationContext(), "Please enter correct credentials", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
