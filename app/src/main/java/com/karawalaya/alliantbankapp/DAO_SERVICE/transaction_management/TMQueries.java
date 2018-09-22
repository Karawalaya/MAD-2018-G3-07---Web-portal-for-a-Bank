package com.karawalaya.alliantbankapp.DAO_SERVICE.transaction_management;

public class TMQueries {
    public static final String TM_TABLE01 = "customer";
    public static final String TM_TABLE01_COL01 = "customerId";
    public static final String TM_TABLE01_COL02 = "firstName";
    public static final String TM_TABLE01_COL03 = "lastName";
    public static final String TM_TABLE01_COL04 = "age";
    public static final String TM_TABLE01_COL05 = "gender";
    public static final String TM_TABLE01_COL06 = "addressStreet";
    public static final String TM_TABLE01_COL07 = "addressCity";
    public static final String TM_TABLE01_COL08 = "addressProvince";
    public static final String TM_TABLE01_COL09 = "addressZip";
    public static final String TM_TABLE01_COL10 = "contactNumber";
    public static final String TM_TABLE01_COL11 = "email";

    public static final String TM_Query_TABLE01_CREATE = "CREATE TABLE " + TM_TABLE01 + "(" +
            TM_TABLE01_COL01 + " CHAR(10) NOT NULL," +
            TM_TABLE01_COL02 + " TEXT NOT NULL," +
            TM_TABLE01_COL03 + " TEXT NOT NULL," +
            TM_TABLE01_COL04 + " INTEGER NOT NULL," +
            TM_TABLE01_COL05 + " TEXT NOT NULL," +
            TM_TABLE01_COL06 + " TEXT NOT NULL," +
            TM_TABLE01_COL07 + " TEXT NOT NULL," +
            TM_TABLE01_COL08 + " TEXT NOT NULL," +
            TM_TABLE01_COL09 + " INTEGER NOT NULL," +
            TM_TABLE01_COL10 + " CHAR(10) NOT NULL," +
            TM_TABLE01_COL11 + " TEXT NOT NULL," +
            "CONSTRAINT pk_customer PRIMARY KEY ("  + TM_TABLE01_COL01 + "),"+
            "CONSTRAINT chk01_customer CHECK (" + TM_TABLE01_COL05 + " IN ('Male', 'Female'))" +
            ");";
    public static final String TM_Query_TABLE01_SELECT_ALL = "SELECT * FROM " + TM_TABLE01 + ";";
    public static final String TM_Query_TABLE01_INSERT = "INSERT INTO " + TM_TABLE01 + "(" + TM_TABLE01_COL01 + ", " + TM_TABLE01_COL02 + ", " + TM_TABLE01_COL03 + ", " + TM_TABLE01_COL04 +
            ", " + TM_TABLE01_COL05 + ", " + TM_TABLE01_COL06 + ", " + TM_TABLE01_COL07 + ", " + TM_TABLE01_COL08 + ", " + TM_TABLE01_COL09 + ", " + TM_TABLE01_COL10 + ", " + TM_TABLE01_COL11 +
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String TM_Query_TABLE01_DROP = "DROP TABLE IF EXISTS " + TM_TABLE01 + ";";


    public static final String TM_TABLE02 = "account";
    public static final String TM_TABLE02_COL01 = "customerId";
    public static final String TM_TABLE02_COL02 = "accountNo";
    public static final String TM_TABLE02_COL03 = "balance";

    public static final String TM_Query_TABLE02_CREATE = "CREATE TABLE " + TM_TABLE02 + "(" +
            TM_TABLE02_COL01 + " CHAR(10) NOT NULL," +
            TM_TABLE02_COL02 + " INTEGER NOT NULL UNIQUE," +
            TM_TABLE02_COL03 + " REAL NOT NULL," +
            "CONSTRAINT pk_account PRIMARY KEY ("  + TM_TABLE02_COL01 + "),"+
            "CONSTRAINT fk01_account FOREIGN KEY (" + TM_TABLE02_COL01 + ") REFERENCES " + TM_TABLE01 + " (" + TM_TABLE01_COL01 + ") ON DELETE CASCADE ON UPDATE CASCADE" +
            ");";
    public static final String TM_Query_TABLE02_SELECT_ALL = "SELECT * FROM " + TM_TABLE02 + ";";
    public static final String TM_Query_TABLE02_INSERT = "INSERT INTO " + TM_TABLE02 + "(" + TM_TABLE02_COL01 + ", " + TM_TABLE02_COL02 + ", " + TM_TABLE02_COL03 + ") VALUES (?, ?, ?);";
    public static final String TM_Query_TABLE02_DROP = "DROP TABLE IF EXISTS " + TM_TABLE02 + ";";

    public static final String TM_Query_UM_FIND = "SELECT * FROM " + TM_TABLE01 + " c INNER JOIN " + TM_TABLE02 + " a ON c." + TM_TABLE01_COL01 + " = a." + TM_TABLE02_COL01 + " WHERE c." + TM_TABLE01_COL11 + "=? AND a." + TM_TABLE02_COL02 + "=?;";
}