package android.in.th.ungexchang;

import android.in.th.ungexchang.fragment.MainFragment;
import android.in.th.ungexchang.fragment.ShowRateExchangeFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SetUp Drawer
        setUpDrawer();

//        Add Fragment to Activity
        addFragment(savedInstanceState);

//        Home Controller
        homeController();

//        Show Rate Controller
        showRateController();

    }   // Main Method

    private void showRateController() {
        TextView textView = findViewById(R.id.txtRateExchange);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentMainFragment, new ShowRateExchangeFragment())
                        .commit();
                drawerLayout.closeDrawers();
            }
        });
    }

    private void homeController() {
        TextView textView = findViewById(R.id.txtHome);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentMainFragment, new MainFragment()).commit();
                drawerLayout.closeDrawers();
            }
        });
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
//            Condition is True

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment())
                    .commit();

        }   // if
    }

    private void setUpDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout);
    }

}   // Main Class
