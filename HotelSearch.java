package administrator.myapplication;

import android.content.Intent;
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

public class HotelSearch extends AppCompatActivity {

    private Button BtnSearch;
//    private EditText hotelTxt;
//    private EditText checkinTxt;
//    private EditText checkoutTxt;
 //   private Spinner roomsSpn;
//    private Spinner adultSpn;
 //   private Spinner childSpn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BtnSearch = (Button)findViewById(R.id.searchBtn);

        BtnSearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
//                hotelTxt = (EditText)findViewById(R.id.hotelName);
//                String hotelN = String.valueOf(hotelTxt.getText());
//                checkinTxt = (EditText)findViewById(R.id.checkIn);
 //               String checkinT = String.valueOf(checkinTxt.getText());
//                checkoutTxt = (EditText)findViewById(R.id.checkout);
//                String checkoutT = String.valueOf(checkoutTxt.getText());
//                roomsSpn = (Spinner) findViewById(R.id.rooms);
 //               String roomNum = String.valueOf(roomsSpn.getSelectedItem());
 //               adultSpn = (Spinner) findViewById(R.id.adults);
  //              String adultNum = String.valueOf(adultSpn.getSelectedItem());
   //             childSpn = (Spinner) findViewById(R.id.children);
 //               String childNum = String.valueOf(childSpn.getSelectedItem());
//
//                if(!((hotelN.equalsIgnoreCase("")) && (checkinT.equalsIgnoreCase("")) && (checkoutT.equalsIgnoreCase("")) && (roomNum.equalsIgnoreCase("")) && (adultNum.equalsIgnoreCase("")) && (childNum.equalsIgnoreCase(""))))
//                {
                    Intent viewDetails = new Intent(getApplicationContext(), ViewDetails.class);
                    startActivity(viewDetails);
//                }
 //               else
 //               {
 //                   Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_LONG).show();
 //               }
            }
        });
  //      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
