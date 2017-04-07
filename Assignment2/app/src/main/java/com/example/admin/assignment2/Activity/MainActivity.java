package com.example.admin.assignment2.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.admin.assignment2.Adapter.ListAdapter;
import com.example.admin.assignment2.R;
import com.example.admin.assignment2.Model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *this is class
 */

public class MainActivity extends AppCompatActivity {

    /**
     *@param savedInstanceState this
     */
    private static final int REQ_CODE_ADD_STUDENT = 1;
    private static int reqCodeEditStudent;
    private Button btnAddStudent;
    private ArrayList<Student> allStudents = new ArrayList<Student>();
    private ListView lvAllStudents;
    private ToggleButton tbtnView;
    private GridView glAllStudents;
    private Spinner spinnerSort;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent addStudentActivity = new Intent(MainActivity.this, Main2Activity.class);
        addStudentActivity.putExtra("VIEW_TYPE", 0);
        btnAddStudent = (Button) findViewById(R.id.btnAddStudent);
        tbtnView = (ToggleButton) findViewById(R.id.tbtnView);
        glAllStudents = (GridView) findViewById(R.id.gv_student);
        lvAllStudents = (ListView) findViewById(R.id.student_list);
        spinnerSort = (Spinner) findViewById(R.id.spinner_sort);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sort, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapter);
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivityForResult(addStudentActivity, REQ_CODE_ADD_STUDENT);
            }

        });

        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                if (position == 0) {
                    Collections.sort(allStudents, new Comparator<Student>() {
                        public int compare(final Student student1, final Student student2) {
                            return Integer.parseInt(student1.getRollNo()) < Integer.parseInt(student2.getRollNo()) ? -1 : 1;
                        }
                    });
                    setListAdapter();

                } else {
                    Collections.sort(allStudents, new Comparator<Student>() {
                        public int compare(final Student student1, final Student student2) {
                            if (student1.getName() == student2.getName()) {
                                return 0;
                            }
                            return student1.getName().compareTo(student2.getName());
                        }
                    });
                    setListAdapter();

                }

            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {

            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        lvAllStudents = (ListView) findViewById(R.id.student_list);
        if (requestCode == REQ_CODE_ADD_STUDENT) {
            if (resultCode == RESULT_OK) {
                allStudents.add((Student) data.getParcelableExtra("NEW_STUDENT"));
                lvAllStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                        reqCodeEditStudent = position;
                        showDialog(view, position);
                    }
                });

                glAllStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                        reqCodeEditStudent = position;
                        showDialog(view, position);
                    }
                });
            }
        } else if (requestCode == reqCodeEditStudent) {
            if (resultCode == RESULT_OK) {
                allStudents.set(reqCodeEditStudent, (Student) data.getParcelableExtra("NEW_STUDENT"));
            }
        }

        setListAdapter();
    }

    /**
     * Adapter
     */
    public void setListAdapter() {

        Toast.makeText(getApplicationContext(), "Entered", Toast.LENGTH_SHORT);
        final ListAdapter listAdapter = new ListAdapter(this, R.layout.row_for_list, allStudents);
        if (tbtnView.isChecked()) {
            glAllStudents.setAdapter(listAdapter);
        } else {
            lvAllStudents.setAdapter(listAdapter);
        }
        tbtnView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                if (isChecked) {
                    glAllStudents.setVisibility(View.VISIBLE);
                    glAllStudents.setAdapter(listAdapter);
                    lvAllStudents.setVisibility(View.INVISIBLE);
                } else {
                    lvAllStudents.setVisibility(View.VISIBLE);
                    lvAllStudents.setAdapter(listAdapter);
                    glAllStudents.setVisibility(View.INVISIBLE);

                }
            }
        });



    }

    /**
     *
     * @param view view
     * @param position position
     */
    public void showDialog(final View view, final int position) {
        new AlertDialog.Builder(view.getContext())
                .setMessage("Select Action")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        new AlertDialog.Builder(view.getContext())
                                .setMessage("ARE YOU SURE?")
                                .setNegativeButton("NO", null)
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(final DialogInterface dialog, final int which) {
                                        allStudents.remove(position);
                                        setListAdapter();
                                    }
                                }).show();
                    }
                })
                .setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        Intent viewActivity = new Intent(MainActivity.this, Main2Activity.class);
                        viewActivity.putExtra("STUDENT_DATA", allStudents.get(position));
                        viewActivity.putExtra("VIEW_TYPE", 1);
                        startActivityForResult(viewActivity, reqCodeEditStudent);
                    }
                })
                .setNegativeButton("view", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        Intent viewActivity = new Intent(MainActivity.this, Main2Activity.class);
                        viewActivity.putExtra("STUDENT_DATA", allStudents.get(position));
                        viewActivity.putExtra("VIEW_TYPE", 2);
                        startActivityForResult(viewActivity, reqCodeEditStudent);

                    }
                }).show();
    }
}
