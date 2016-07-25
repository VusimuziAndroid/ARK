package android.apk;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by Vusi Ngwenya on 7/20/2016.
 */
public class Database  extends SQLiteOpenHelper{

    private static final String LOGCAT = null;
    private static final android.database.sqlite.SQLiteDatabase.CursorFactory MODE_PRIVATE = null;
    public static final String DATABASE_NAME = "ARKDB6.db";
    SQLiteDatabase db;

    DatabaseValues databaseValues = new DatabaseValues();
    public Database(Context context) {
        super(context,DATABASE_NAME, null, 1);
        Log.d(LOGCAT, "Created");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;

        db.execSQL(" CREATE TABLE " + databaseValues.TABLE_NAME + "(Username TEXT, CellNumbers TEXT,Message TEXT);");
        db.execSQL(" CREATE TABLE " + databaseValues.TABLE_NAME2 + "(Username TEXT, Password TEXT);");
        db.execSQL(" CREATE TABLE " + databaseValues.TABLE_NAME3 + "(CustomerNumber TEXT,CustomerName TEXT,IDNumber TEXT);");
        Log.e("DATABASE OPERATIONS", "Table created ...");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query = "DROP TABLE IF EXISTS Users";
        db.execSQL(query);
    }
    public void insertMessages(Messages messages){
        Tag Tag=null;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(databaseValues.COLUMN_NAME1,messages.getUsername());
        values.put(databaseValues.COLUMN_NAME2,messages.cellNumbers);
        values.put(databaseValues.COLUMN_NAME3,messages.getMessage());
        db.insert(databaseValues.TABLE_NAME, null, values);
        db.close();
    }
    public void insertUsers(Users users){
        Tag Tag=null;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(databaseValues.USERS_COLUMN_NAME1,users.getUsername());
        values.put(databaseValues.USERS_COLUMN_NAME2,users.getPassword());
        db.insert(databaseValues.TABLE_NAME2, null, values);
        db.close();
    }
    public void insertCustomers(Customers customers){
        Tag Tag=null;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(databaseValues.CUSTOMERS_COLUMN_NAME1,customers.getCustomerNumber());
        values.put(databaseValues.CUSTOMERS_COLUMN_NAME2,customers.getCustomerName());
        values.put(databaseValues.CUSTOMERS_COLUMN_NAME3,customers.getIdNumber());
        db.insert(databaseValues.TABLE_NAME2, null, values);
        db.close();
    }
  /*  public void insertWorkExperience(WorkExperience workExperience){
        Tag Tag=null;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(databaseValues.EX_COLUMN_NAME1,workExperience.getUsername());
        values.put(databaseValues.EX_COLUMN_NAME2,workExperience.getCountry());
        values.put(databaseValues.EX_COLUMN_NAME3,workExperience.getCity());
        values.put(databaseValues.EX_COLUMN_NAME4,workExperience.getJobs());
        values.put(databaseValues.EX_COLUMN_NAME5,workExperience.getDepartment());
        values.put(databaseValues.EX_COLUMN_NAME6,workExperience.getPostCode());
        db.insert(databaseValues.TABLE_NAME2, null, values);
        db.close();
    }
    public void insertPicture(WorkExperience workExperience){
        Tag Tag=null;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(databaseValues.EX_COLUMN_NAME1,workExperience.getUsername());
        values.put(databaseValues.EX_COLUMN_NAME2,workExperience.getCountry());
        values.put(databaseValues.EX_COLUMN_NAME3,workExperience.getCity());
        values.put(databaseValues.EX_COLUMN_NAME4,workExperience.getJobs());
        values.put(databaseValues.EX_COLUMN_NAME5,workExperience.getDepartment());
        values.put(databaseValues.EX_COLUMN_NAME6,workExperience.getPostCode());
        db.insert(databaseValues.TABLE_NAME2, null, values);
        db.close();
    }*/

    private class DatabaseValues{
        private static final String TABLE_NAME = "Messages";
        private static final String TABLE_NAME2 = "Users";
        private static final String TABLE_NAME3 = "Customers";
        private static final String COLUMN_NAME1="Username";
        private static final String COLUMN_NAME2 = "CellNumbers";
        private static final String COLUMN_NAME3 = "Message";
       /* private static final String COLUMN_NAME4 = "Password";*/
        private static final String USERS_COLUMN_NAME1="Username";
        private static final String USERS_COLUMN_NAME2="Password";
        private static final String CUSTOMERS_COLUMN_NAME1="CustomerNumber";
        private static final String CUSTOMERS_COLUMN_NAME2="CustomerName";
        private static final String CUSTOMERS_COLUMN_NAME3="IDNumber";
        private static final String EX_COLUMN_NAME4="Job";
        private static final String EX_COLUMN_NAME5="Department";
        private static final String EX_COLUMN_NAME6="PostCode";
    }


}
