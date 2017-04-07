package com.example.admin.assignment2.Model;

/**
 * Created by Admin on 04-04-2017.
 */
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Class
 */
public class Student implements Parcelable {
    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {

        public Student createFromParcel(final Parcel in) {
            return new Student(in);
        }

        public Student[] newArray(final int size) {
            return new Student[size];
        }
    };
    private String name;
    private String schoolName;
    private String email;
    private String gender;
    private String rollNo;



    /**
     * Constructor
     * @param name name
     * @param schoolName schoolname
     * @param email email
     * @param gender gender
     * @param rollNo rollNo
     */
    public Student(final String name, final String schoolName, final String email, final int gender, final String rollNo)
    {
        this.name = name;
        this.schoolName = schoolName;
        this.email = email;
        this.gender = gender == 0 ? "MALE" : gender == 1 ? "FEMALE" : "OTHER";
        this.rollNo = rollNo;

    }

    /**
     * Construct
     * @param in in
     */
    public Student(final Parcel in) {
         // the order needs to be the same as in writeToParcel() method
        this.name = in.readString();
        this.schoolName = in.readString();
        this.email = in.readString();
        this.gender = in.readString();
        this.rollNo = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(name);
        dest.writeString(schoolName);
        dest.writeString(email);
        dest.writeString(gender);
        dest.writeString(rollNo);

    }


    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return School Name
     */
    public String getSchoolName() {

        return schoolName;
    }

    /**
     *
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return Gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @return Roll Number
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     *
     * @param name set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @param schoolName set
     */
    public void setSchoolName(final String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     *
     * @param email set
      */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     *
     * @param gender set
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     *
     * @param rollNo set
     */
    public void setRollNo(final String rollNo) {
        this.rollNo = rollNo;
    }
}
