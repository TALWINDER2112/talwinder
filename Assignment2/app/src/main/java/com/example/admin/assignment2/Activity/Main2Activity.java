package com.example.admin.assignment2.Activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.content.Intent;
import android.widget.Toast;

import com.example.admin.assignment2.R;
import com.example.admin.assignment2.Model.Student;

/**
 * class
 */


public class Main2Activity extends AppCompatActivity {
    /**
     * @param savedInstanceState app
     */

    private EditText etName;
    private EditText etSchoolName;
    private EditText etEmail;
    private RadioGroup radioGrpGender;
    private EditText etRollNo;
    private Button btnSave;
    private Intent intentGetViewType;
    private Student newStudent;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intentGetViewType = getIntent();

        btnSave = (Button) findViewById(R.id.btnSave);
        etName = (EditText) findViewById(R.id.et_student_name);
        etSchoolName = (EditText) findViewById(R.id.et_school_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        radioGrpGender = (RadioGroup) findViewById(R.id.radio_group_gender);
        etRollNo = (EditText) findViewById(R.id.et_roll_number);

        if (intentGetViewType.getIntExtra("VIEW_TYPE", -1) == 1) {
            setData();
        } else if (intentGetViewType.getIntExtra("VIEW_TYPE", -1) == 2) {
            setData();
            disableEdit();

        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(final View v) {
                if (intentGetViewType.getIntExtra("VIEW_TYPE", -1) == 0) {
                    newStudent = new Student(etName.getText().toString(),
                            etSchoolName.getText().toString(),
                            etEmail.getText().toString(),
                            radioGrpGender.getCheckedRadioButtonId(),
                            etRollNo.getText().toString());
                } else if (intentGetViewType.getIntExtra("VIEW_TYPE", -1) == 1) {
                    newStudent = intentGetViewType.getParcelableExtra("STUDENT_DATA");
                    newStudent.setName(etName.getText().toString());
                    newStudent.setEmail(etEmail.getText().toString());
                    newStudent.setGender(radioGrpGender.getCheckedRadioButtonId() == 0 ? "MALE" : "FEMALE");
                    newStudent.setSchoolName(etSchoolName.getText().toString());
                    newStudent.setRollNo(etRollNo.getText().toString());
                } else {
                    finish();
                }
                Intent setResults = new Intent();
                setResults.putExtra("NEW_STUDENT", newStudent);
                setResult(Activity.RESULT_OK, setResults);
                Toast.makeText(getApplicationContext(), "DONE", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }

    /**
     * SET DATA
     */
    public void setData() {
        newStudent = intentGetViewType.getParcelableExtra("STUDENT_DATA");
        etName.setText(newStudent.getName());
        etSchoolName.setText(newStudent.getSchoolName());
        etEmail.setText(newStudent.getEmail());
        etRollNo.setText(newStudent.getRollNo());
        btnSave.setText("UPDATE");
    }

    /**
     * Disable Edit Function
     */
    public void disableEdit() {
        etName.setEnabled(false);
        etRollNo.setEnabled(false);
        etEmail.setEnabled(false);
        etSchoolName.setEnabled(false);
        radioGrpGender.setEnabled(false);
        btnSave.setText("DONE");
    }
}
