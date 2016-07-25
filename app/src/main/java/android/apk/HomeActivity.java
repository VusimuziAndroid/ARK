package android.apk;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;
import android.content.Intent;

public class HomeActivity extends AppCompatActivity {
   TabHost tabhost;
    EditText etCustomerName;
    EditText etCustomerNumber;
    EditText etIDNumber;
    Database database;
    Messages messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etCustomerName = (EditText) findViewById(R.id.etCustomerName);
        etCustomerNumber = (EditText) findViewById(R.id.etCustomerNumber);
        etIDNumber = (EditText) findViewById(R.id.etIDNumber);
        database = new Database(this);
       /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);*/
    }

   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/
    public void onClick(View view){
        String customerName=etCustomerName.getText().toString();
        String customerNumber=etCustomerNumber.getText().toString();
        String idNumber=etIDNumber.getText().toString();

        if(etCustomerName.getText().toString().equals("")){
            etCustomerName.setError("Please supply your name");
        }
        else if(etCustomerNumber.getText().toString().equals("")){
            etCustomerNumber.setError("Please supply your customer number");
        }
        else if(etIDNumber.getText().toString().equals("")){
            etIDNumber.setError("Please supply your ID Number");
        }
        else {
          //  Customers customer = new Customers(etCustomerNumber.,)
           // messages = new Messages(customerName,message,cellNumbers);
           // Toast.makeText(HomeActivity.this,"username="+username+" message="+message+" cell numbers="+cellNumbers,Toast.LENGTH_SHORT).show();
           // database.insertMessag
          //  Toast.makeText(HomeActivity.this,"username="+username+" message="+message+" cell numbers="+cellNumbers,Toast.LENGTH_SHORT).show();
            Toast.makeText(HomeActivity.this," Customer Name="+customerName+" Customer Number="+customerNumber+" ID Number="+idNumber,Toast.LENGTH_SHORT).show();
            Customers customers = new Customers(customerName,customerNumber,idNumber);
            database.insertCustomers(customers);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
