package android.apk;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BondActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvMessage;
    Database database;
    Messages messages;
    SharedPreferences pref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bond);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
       // tvName = (TextView) findViewById(R.id.tvName);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
    }

    public void insertMessage2(View view){
        pref = getSharedPreferences("UsersPref", MODE_PRIVATE);
        editor = pref.edit();
       // editor.commit();
        String username="ab123";
        String cellNumbers="0712345654";

        Messages messages = new Messages(username,cellNumbers,tvMessage.getText().toString());
        database.insertMessages(messages);
      /*  messages = new Messages(username,tvMessage.getText().toString());
        database.insertMessages(messages);*/
    }
}
