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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Helper mydb ;
    private Button BtnSearch;
    private EditText hotelTxt;
    private EditText checkinTxt;
    private EditText checkoutTxt;
    private EditText roomNum;
    private EditText adultNum;
    private EditText childNum;
    private EditText contactNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mydb = new Helper(this);

        BtnSearch = (Button)findViewById(R.id.searchBtn);
        BtnSearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                hotelTxt = (EditText)findViewById(R.id.hotelName);
                String hotelN = String.valueOf(hotelTxt.getText());
                checkinTxt = (EditText)findViewById(R.id.checkIn);
                String checkinT = String.valueOf(checkinTxt.getText());
                checkoutTxt = (EditText)findViewById(R.id.checkout);
                String checkoutT = String.valueOf(checkoutTxt.getText());
                roomNum = (EditText)findViewById(R.id.roomsTxt);
                int RoomNo = Integer.parseInt(roomNum.getText().toString());
                adultNum = (EditText)findViewById(R.id.adultTxt);
                int AdultNo = Integer.parseInt(adultNum.getText().toString());
                childNum = (EditText)findViewById(R.id.childTxt);
                int ChildNo = Integer.parseInt(childNum.getText().toString());
                contactNo = (EditText)findViewById(R.id.contactNo);
                String contactNum = contactNo.getText().toString();

//
                if(!((contactNum.equals("")) && (RoomNo == 0) && (AdultNo == 0) && (ChildNo == 0) && (hotelN.equalsIgnoreCase("")) && (checkinT.equalsIgnoreCase("") && checkinT.length() == 9) && (checkoutT.equalsIgnoreCase("") && checkoutT.length() == 9)))
                {
                    int rownum = mydb.numberOfRows();
                    mydb.insertDetails(rownum++,hotelN, checkinT, checkoutT, RoomNo, AdultNo, ChildNo, contactNum);
                    Bundle extras = getIntent().getExtras();

                    Intent viewDetails = new Intent(getApplicationContext(), ViewDetails.class);
                    startActivity(viewDetails);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
