package com.example.admin.assignment3.Adapter;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.assignment3.Activity.ScreenCActivity;
import com.example.admin.assignment3.ModelClass.DriverList;
import com.example.admin.assignment3.R;

import java.util.List;

/**
 * Created by Admin on 20-04-2017.
 */

public class DriverListAdapter extends RecyclerView.Adapter<DriverListAdapter.MyViewHolder> {
    private List<DriverList> driverList;
    private Intent intent;

    /**
     *
     * @param driverList dlist
     */
    public DriverListAdapter(final List<DriverList> driverList) {
        this.driverList = driverList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.driver_list_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        DriverList driver = driverList.get(position);
        holder.tvDriverID.setText(driver.getDriverID());
        holder.tvDriverName.setText(driver.getDriverName());
        holder.tvDriverLocation.setText(driver.getDriverLocation());
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

    /**
     * class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDriverID, tvDriverName, tvDriverLocation;

        /**
         *
         * @param view view
         */
        public MyViewHolder(final View view) {
            super(view);
            tvDriverID = (TextView) view.findViewById(R.id.tv_driver_id);
            tvDriverName = (TextView) view.findViewById(R.id.tv_driver_name);
            tvDriverLocation = (TextView) view.findViewById(R.id.tv_driver_location);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    //Toast.makeText(v.getContext(), driverList.get(getAdapterPosition()).getDriverName(), Toast.LENGTH_SHORT).show();
                    intent = new Intent(v.getContext(), ScreenCActivity.class);

                    ContextCompat.startActivity(v.getContext(), intent, null);
                }
            });


        }

    }


}
