package android.apk;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;


public class LoginActivity extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;
    Database database;
    SQLiteDatabase db;
    Users users;
    SharedPreferences pref;
    private SharedPreferences.Editor editor;
    SharedPreferences pref2;
    private SharedPreferences.Editor editor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    etUsername = (EditText) findViewById(R.id.etABNumber2);
    etPassword = (EditText) findViewById(R.id.etPassword2);
        database = new Database(this);
    }

    public void onClickLogin(View view){
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if(etUsername.getText().toString().equals("")){
            etUsername.setError("Please supply your username");
        }
        else if(etPassword.getText().toString().equals("")){
            etPassword.setError("Please supply your password");
        }
        else {
            db=openOrCreateDatabase("ARKDB6.db",MODE_PRIVATE,null);
          /*  Intent login = new Intent(LoginActivity.this,WelcomeScreen.class);
            startActivity(login);*/
            String sql="SELECT Username, Password FROM Users";
            Cursor cursor = db.rawQuery(sql,null);
            Context context = null;
            Customers customers;
            pref2 = getSharedPreferences("UsersPref", LoginActivity.MODE_PRIVATE);
            editor2 = pref2.edit();

            editor2.putString("Username",username);
            editor2.putString("Password",password);
            editor2.commit();
            database.insertUsers(users);

            customers = new Customers("07890988712","Vusi","89098776212");
            database.insertCustomers(customers);

           /* Users users = new Users(username,password);
            database.insertUsers(users);

            Toast.makeText(LoginActivity.this,"registered!!!",Toast.LENGTH_SHORT).show();*/

         /* while(cursor.moveToNext()){
                String u_username=cursor.getString(0);
                String u_password=cursor.getString(1);

               // Toast.makeText(LoginActivity.this,"username="+username+" u_username="+u_username+" password="+password+" u_password="+u_password,Toast.LENGTH_SHORT).show();
                if(etUsername.getText().toString().equals(u_username) && u_password.equals(etPassword.getText().toString())){
                    Intent home = new Intent(LoginActivity.this,WelcomeScreen.class);
                    startActivity(home);
                    Toast.makeText(LoginActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this,"The credentials supplied are in correct",Toast.LENGTH_SHORT).show();
                }
           }*/
        }
    }
}
