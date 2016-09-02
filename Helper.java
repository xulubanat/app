package administrator.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Helper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Booking";

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String CREATE_BOOKING_TABLE = "CREATE TABLE bookingDetails( " +
                "customerID INTEGER PRIMARY KEY, " +
                "hoteN TEXT, " + "checkI TEXT, " + "checkO TEXT, " + "noOfRooms INTEGER, " + "noOfAdults INTEGER, " + "noOfChildren INTEGER, " +
                "contactNumber TEXT )";

        sqLiteDatabase.execSQL(CREATE_BOOKING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS bookingDetails");

        this.onCreate(db);
    }

    public boolean insertDetails(int cid, String hn, String ci, String co, int nr,int na, int nc, String cn)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("customerID", cid);
        contentValues.put("hoteN", hn);
        contentValues.put("checkI", ci);
        contentValues.put("checkO", co);
        contentValues.put("noOfRooms", nr);
        contentValues.put("noOfAdults", na);
        contentValues.put("noOfChildren", nc);
        contentValues.put("contactNumber", cn);
        db.insert("bookingDetails", null, contentValues);
        this.getAllDetails();
        return true;
    }

    public Cursor getData(int cid){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from bookingDetails where customerID="+cid+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "bookingDetails");
        return numRows;
    }

    public boolean updateDetails (int cid, String hn, String ci, String co, int nr,int na, int nc, String cn)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoteN", hn);
        contentValues.put("checkI", ci);
        contentValues.put("checkO", co);
        contentValues.put("noOfRooms", nr);
        contentValues.put("noOfAdults", na);
        contentValues.put("noOfChildren", nc);
        contentValues.put("contactNumber", cn);
        db.update("bookingDetails", contentValues, "customerID = ? ", new String[] { Integer.toString(cid) } );
        return true;
    }

    public Integer deleteDetails (Integer cid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("bookingDetails",
                "id = ? ",
                new String[] { Integer.toString(cid) });
    }

    public ArrayList<String> getAllDetails()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from bookingDetails", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("hoteN")));
            res.moveToNext();
        }
        return array_list;
    }
}
