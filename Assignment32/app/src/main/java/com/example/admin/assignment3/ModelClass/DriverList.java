package com.example.admin.assignment3.ModelClass;

/**
 * Created by Admin on 20-04-2017.
 */

public class DriverList {

    private String driverID;
    private String driverName;
    private String driverLocation;

    /**
     * constructor
     */
    public DriverList() {

    }

    /**
     *
     * @param driverName dname
     * @param driverID dId
     * @param driverLocation Dlocation
     */
    public DriverList(final String driverName, final String driverID, final String driverLocation) {
        this.driverName = driverName;
        this.driverID = driverID;
        this.driverLocation = driverLocation;
    }

    /**
     *
     * @param driverID did
     */
    public void setDriverID(final String driverID) {
        this.driverID = driverID;
    }

    /**
     *
     * @param driverName dname
     */
    public void setDriverName(final String driverName) {
        this.driverName = driverName;
    }

    /**
     *
     * @param driverLocation dlocation
     */
    public void setDriverLocation(final String driverLocation) {
        this.driverLocation = driverLocation;
    }

    /**
     *
     * @return ID
     */
    public String getDriverID() {
        return driverID;
    }

    /**
     *
     * @return name
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     *
     * @return location
     */
    public String getDriverLocation() {
        return driverLocation;
    }


}
