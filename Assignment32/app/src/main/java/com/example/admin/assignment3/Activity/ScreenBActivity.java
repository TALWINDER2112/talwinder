package com.example.admin.assignment3.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.assignment3.ModelClass.DriverList;
import com.example.admin.assignment3.Adapter.DriverListAdapter;
import com.example.admin.assignment3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * class
 */
public class ScreenBActivity extends AppCompatActivity  {

    private List<DriverList> drivers;
    private RecyclerView rvDriverList;
    private DriverListAdapter driverListAdapter;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_b);

        drivers = new ArrayList<>();
        rvDriverList = (RecyclerView) findViewById(R.id.recycler_list);
        driverListAdapter = new DriverListAdapter(drivers);
        RecyclerView.LayoutManager driverLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvDriverList.setLayoutManager(driverLayoutManager);
        rvDriverList.setAdapter(driverListAdapter);

        getDetails();

    }
    /**
     * detaisl
     */
    private void getDetails() {
        DriverList driver = new DriverList("manoj", "1", "chandigarh");
        drivers.add(driver);

        driver = new DriverList("manoj", "2", "chandigarh");
        drivers.add(driver);

        driver = new DriverList("harman", "3", "mohali");
        drivers.add(driver);

        driver = new DriverList("diljot", "4", "chandigarh");
        drivers.add(driver);

        driver = new DriverList("kumar", "5", "panchkula");
        drivers.add(driver);

        driver = new DriverList("sanjay", "6", "mohali");
        drivers.add(driver);

        driver = new DriverList("vijay", "7", "chandigarh");
        drivers.add(driver);

        driver = new DriverList("raman", "8", "panchkula");
        drivers.add(driver);

        driver = new DriverList("sunny", "9", "chandigarh");
        drivers.add(driver);

        driver = new DriverList("sourav", "10", "mohali");
        drivers.add(driver);

        driver = new DriverList("shivam", "11", "panchkula");
        drivers.add(driver);
    }


}
