package android.apk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;

public class CustomerDetailsActivity extends AppCompatActivity {
    TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabhost = (TabHost) findViewById(R.id.tabHost);
        tabhost.setup();
        TabHost.TabSpec  firstText = tabhost.newTabSpec("FIRSTTAB");
        firstText.setContent(R.id.FIRSTTAB);
        firstText.setIndicator("Personal");
        tabhost.addTab(firstText);
        TabHost.TabSpec secondText = tabhost.newTabSpec("SECONDTAB");
        secondText.setContent(R.id.SECONDTAB);
        secondText.setIndicator("Achieved");
        tabhost.addTab(secondText);
        TabHost.TabSpec thirdText = tabhost.newTabSpec("THIRDTAB");
        thirdText.setContent(R.id.THIRDTAB);
        thirdText.setIndicator("Education");
        tabhost.addTab(thirdText);

    }
}
