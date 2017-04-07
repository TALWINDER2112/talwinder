package com.example.admin.assignment2.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.admin.assignment2.R;
import com.example.admin.assignment2.Model.Student;

import java.util.List;

/**
 * Created by Admin on 04-04-2017.
 */


public class ListAdapter extends ArrayAdapter<Student> {
    /**
     * @param context            cnt
     * @param textViewResourceId id
     */
    public ListAdapter(final Context context, final int textViewResourceId) {
        super(context, textViewResourceId);
    }

    /**
     * @param context  cnt
     * @param resource rsr
     * @param items    itm
     */
    public ListAdapter(final Context context, final int resource, final List<Student> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater viewInflater;
            viewInflater = LayoutInflater.from(getContext());
            view = viewInflater.inflate(R.layout.row_for_list, parent, false);
        }

        Student positionStudent = getItem(position);

        if (positionStudent != null) {

            TextView tvRollNo = (TextView) view.findViewById(R.id.tv_roll_number);
            TextView tvStudentName = (TextView) view.findViewById(R.id.tv_Student_name);
            TextView tvSchoolName = (TextView) view.findViewById(R.id.tv_school_name);
            TextView tvGender = (TextView) view.findViewById(R.id.tv_gender);
            TextView tvEmail = (TextView) view.findViewById(R.id.tv_email);
            tvStudentName.setText("NAME : " + positionStudent.getName());
            tvRollNo.setText("ROLL NO : " + positionStudent.getRollNo());
            tvEmail.setText("EMAIL :" + positionStudent.getEmail());
            tvSchoolName.setText("SCHOOL : " + positionStudent.getSchoolName());
            tvGender.setText("GENDER : " + positionStudent.getGender());


        }
        return view;
    }
}