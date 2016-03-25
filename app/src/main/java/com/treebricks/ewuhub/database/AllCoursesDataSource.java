package com.treebricks.ewuhub.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;

public class AllCoursesDataSource
{
    public static final String LOGTAG = "EwuHub";
    Cursor cursor = null;
    private String table = "AllCourses";
    private static final String[] allCloumns = {
            "CourseName"
    };
    public ArrayList<String> findAll(Context context)
    {
        DatabaseHelper dbhelper = new DatabaseHelper(context);
        ArrayList<String> allCourses = new ArrayList<String>();
        try {
            dbhelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            dbhelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = dbhelper.query(table, allCloumns, null, null, null, null, null);
        Log.i(LOGTAG, "Database Successfully Connected!");

        if (cursor.moveToFirst()) {
            do {
                String string = cursor.getString(cursor.getColumnIndex("CourseName"));
                allCourses.add(string);
            } while (cursor.moveToNext());
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return allCourses;
    }

}
