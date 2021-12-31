package fr.example.bikeathome;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BikeAtHome.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(MainActivity context){
        super((Context) context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "CREATE TABLE Session("
                + "   id_session integer primary key autoincrement,"
                + "   Nom VARCHAR(50) NOT NULL,"
                + "   Difficulte INT NOT NULL CHECK(Difficulte >= 0 AND Difficulte < 3)"
                + ");";
        String strSql2 ="CREATE TABLE Item("
                + "   Id_Item INTEGER PRIMARY KEY autoincrement,"
                + "   Duree INT NOT NULL CHECK(Duree > 0),"
                + "   Puissance INT NOT NULL CHECK(Puissance >= 0),"
                + "   Frequence INT CHECK(Frequence > 0),"
                + "   Place INT NOT NULL CHECK(Place >= 0),"
                + "   Session int not null,"
                + "   FOREIGN KEY(Session) REFERENCES Session(id_session)"
                + ");";
        db.execSQL(strSql);
        db.execSQL(strSql2);
        Log.i( "DATABASE1", "creation session + item");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int ajouterSession(String nom, int difficulte){
        nom = nom.replace("'", "''");
        String strSql = "insert into Session (Nom, Difficulte) values('"
                    + nom
                    + "',"
                    + difficulte
                    + ");";
        this.getWritableDatabase().execSQL(strSql);

        String strSql2 = "Select max(id_session) from Session;";
        Cursor cursor1 = this.getReadableDatabase().rawQuery(strSql2, null);
        cursor1.moveToFirst();
        int i = cursor1.getInt(0);
        Log.i("DATABASE1", "insert Session");
        return i;
    }

    public void ajouterItem(int id_session, int duree, int puissance, int frequence, int place){
        String strSql = "insert into Item (Duree, Puissance, Frequence, Place, Session) values("
                + duree
                + ","
                + puissance
                + ","
                + frequence
                + ","
                + place
                + ","
                + id_session
                + ");";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE1", "insert Item");
    }

    public void supprimerItem(int id_item){
        String strSql = "Delete from Item Where Id_Item = "
                    + id_item
                    + ";";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE1", "remove Item");
    }

    public void supprimerSession(int id_session){
        String strSql = "Delete from Item where Session ="
                    + id_session
                    + ";";
        String strSql2 ="Delete from Session where id_session = "
                    + id_session
                    + ";";
        this.getWritableDatabase().execSQL(strSql);
        this.getWritableDatabase().execSQL(strSql2);
        Log.i("DATABASE1", "remove Session");
    }

    public List<Session> readListSession(){
        List<Session> sessionList = new ArrayList<>();

        String strSql1 = "Select * From Session order by id_session";
        Cursor cursor1 = this.getReadableDatabase().rawQuery(strSql1, null);
        cursor1.moveToFirst();

        while( !cursor1.isAfterLast()){
            Session currentSession = new Session( cursor1.getString(1), cursor1.getInt(2));
            currentSession.setId_session(cursor1.getInt(0));

            String strSql2 = "Select * From Item where Session = " + currentSession.getId_session() + " ORDER BY Place ";
            Cursor cursor2 = this.getReadableDatabase().rawQuery(strSql2, null);
            cursor2.moveToFirst();

            while( !cursor2.isAfterLast()){
                Item currentItem = new Item( cursor2.getInt(1)/60, cursor2.getInt(2), cursor2.getInt(3));
                currentItem.setPlace(cursor2.getInt(4));
                currentSession.addItem(currentItem);
                cursor2.moveToNext();
                Log.i("DATABASE1", "item lu");
            }
            Log.i("DATABASE1", "session lu");
            sessionList.add(currentSession);
            cursor1.moveToNext();
        }

        return sessionList;
    }

}
