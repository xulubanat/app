package administrator.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewDetails extends AppCompatActivity {

    private Button submitbtn;
    private TextView hn;
    private TextView ci;
    private TextView co;
    private TextView nr;
    private TextView ng;
    private TextView cn;
    private Helper mydb ;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mydb = new Helper(this);
        submitbtn = (Button)findViewById(R.id.submitBtn);
        hn = (TextView)findViewById(R.id.hotelN);
        ci = (TextView)findViewById(R.id.checkInDate);
        co = (TextView)findViewById(R.id.checkoutDate);
        nr = (TextView)findViewById(R.id.numOfRooms);
        ng = (TextView)findViewById(R.id.guestNums);
        cn = (TextView)findViewById(R.id.contactNum);

        int rownum = mydb.numberOfRows();
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            int Value = rownum;//extras.getInt("1");

            if (Value > 0) {

                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String hoteln = rs.getString(rs.getColumnIndex("hoteN"));
                String checkI = rs.getString(rs.getColumnIndex("checkI"));
                String checkO = rs.getString(rs.getColumnIndex("checkO"));
                int numRooms = rs.getInt(rs.getColumnIndex("noOfRooms"));
                int numAd = rs.getInt(rs.getColumnIndex("noOfAdults"));
                int numCh = rs.getInt(rs.getColumnIndex("noOfChildren"));
                String contactNums = rs.getString(rs.getColumnIndex("contactNumber"));
                int numOfG = numAd + numCh;

                if (!rs.isClosed()) {
                    rs.close();
                }

                hn.setText((CharSequence) hoteln);
                hn.setFocusable(false);

                ci.setText((CharSequence) checkI);
                ci.setFocusable(false);

                co.setText((CharSequence) checkO);
                co.setFocusable(false);

                nr.setText((CharSequence) (String.valueOf(numRooms)));
                nr.setFocusable(false);

                ng.setText((CharSequence) (String.valueOf(numOfG)));
                ng.setFocusable(false);

                cn.setText((CharSequence) contactNums);
                cn.setFocusable(false);
            }
        }
        submitbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent viewDetails = new Intent(getApplicationContext(), SuccessScreen.class);
                startActivity(viewDetails);

            }
        });
    }

}
