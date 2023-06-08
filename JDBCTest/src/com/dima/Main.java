package com.dima;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static final String DB_NAME = "testdb.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:src/resources/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";


    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
//            Drop contacts table
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
//            Create contacts table if it doesn't exist
            statement.execute(("CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER, %s TEXT)")
                    .formatted(TABLE_CONTACTS, COLUMN_ID, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));
//            INSERT record into contacts table
            statement.execute("INSERT INTO %s (%s, %s, %s) VALUES('Tim', 55506, 'tim.lpa@help.com')"
                    .formatted(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));
//            INSERT record into contacts table
            statement.execute("INSERT INTO %s (%s, %s, %s) VALUES('Dima', 12345, 'dima.study@java.com')"
                    .formatted(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));
//            INSERT record into contacts table
            statement.execute("INSERT INTO %s (%s, %s, %s) VALUES('Ethan', 78492, 'eburk.lpa@work.com')"
                    .formatted(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));
//            INSERT record into contacts table
            statement.execute("INSERT INTO %s (%s, %s, %s) VALUES('Edward', 08038, 'ed.lpa.student@gmail.com')"
                    .formatted(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));
            statement.execute("UPDATE %s SET %s = 'dima.lpa.student@gmail.com' WHERE %s = 'Dima'"
                    .formatted(TABLE_CONTACTS, COLUMN_EMAIL, COLUMN_NAME));
            insertIntoDB(statement, "Alice", 45345, "alice.wonder@gmail.com");
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();
            ResultSet results = statement.executeQuery("SELECT * FROM %s".formatted(TABLE_CONTACTS));
            while(results.next()) {
                System.out.printf("%-5s %-7d %-5s%n", results.getString(COLUMN_NAME),
                        results.getInt(COLUMN_PHONE), results.getString(COLUMN_EMAIL));
            }

            results.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void insertIntoDB(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO %s (%s, %s, %s) VALUES('%s', %d, '%s')"
                .formatted(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL, name, phone, email));
    }
}
