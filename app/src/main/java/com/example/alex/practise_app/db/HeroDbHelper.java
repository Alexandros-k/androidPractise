package com.example.alex.practise_app.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alex.practise_app.model.Hero;

import java.util.ArrayList;
import java.util.List;

import static com.example.alex.practise_app.db.HeroDbSchema.HeroTable.TABLE_NAME;

/**
 * Created by Alex on 6/12/2017.
 */

public class HeroDbHelper extends SQLiteOpenHelper {

    private static final String[] PROJECTION = {
            HeroDbSchema.HeroTable._ID,
            HeroDbSchema.HeroTable.COLUMN_NAME_CODENAME,
            HeroDbSchema.HeroTable.COLUMN_NAME_REALNAME,
            HeroDbSchema.HeroTable.COLUMN_NAME_SUPERPOWER,
    };


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HeroManagement.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private static final String SORT_ORDER = HeroDbSchema.HeroTable.COLUMN_NAME_REALNAME + " ASC";

    public HeroDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" +" "+ TABLE_NAME + " (_ID " + INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                HeroDbSchema.HeroTable.COLUMN_NAME_CODENAME + TEXT_TYPE + COMMA_SEP +
                HeroDbSchema.HeroTable.COLUMN_NAME_REALNAME + TEXT_TYPE + COMMA_SEP +
                HeroDbSchema.HeroTable.COLUMN_NAME_SUPERPOWER + TEXT_TYPE + ")");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade
        // policy is to simply discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private ContentValues getContentValues(Hero h1) {
        ContentValues values = new ContentValues();
        values.put(HeroDbSchema.HeroTable.COLUMN_NAME_CODENAME, h1.getCodeName());
        values.put(HeroDbSchema.HeroTable.COLUMN_NAME_REALNAME, h1.getRealName());
        values.put(HeroDbSchema.HeroTable.COLUMN_NAME_SUPERPOWER, h1.getSuperPower());

        return values;
    }

    private void insertHero(Hero h1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = getContentValues(h1);
        db.insert(TABLE_NAME, null, values);
    }

    public List<Hero> getHeroes() {
        SQLiteDatabase db = this.getReadableDatabase();
Cursor cursor = db.query(

        TABLE_NAME,           // The table to query
        PROJECTION,                                     // The columns to return
        null,                                    // The columns for the WHERE clause
        null,                                      // The values for the WHERE clause
        null,                                           // don't group the rows
        null,                                           // don't filter by row groups
        SORT_ORDER

);
        List<Hero> heroes = new ArrayList<>();
        int codeNameColumn = cursor.getColumnIndexOrThrow(HeroDbSchema.HeroTable.COLUMN_NAME_CODENAME);
        int realNameColumn = cursor.getColumnIndexOrThrow(HeroDbSchema.HeroTable.COLUMN_NAME_REALNAME);
        int superPowerColumn = cursor.getColumnIndexOrThrow(HeroDbSchema.HeroTable.COLUMN_NAME_SUPERPOWER);

        while (cursor.moveToNext()){
Hero hero = new Hero(
        cursor.getString(codeNameColumn),
        cursor.getString(realNameColumn),
        cursor.getString(superPowerColumn));

        heroes.add(hero);


        }
cursor.close();
        return heroes;


    }

    public int countHeroes() {
        SQLiteDatabase db = this.getWritableDatabase();
        String countQuery = "SELECT count(*) FROM " + HeroDbSchema.HeroTable.TABLE_NAME;
        Cursor mcursor = db.rawQuery(countQuery, null);
        mcursor.moveToFirst();
        return mcursor.getInt(0);
    }

    public void initDb() {
        if (countHeroes() == 0) {
            for (Hero hero : getHeroList()) {
                insertHero(hero);
            }
        }
    }

    private List<Hero> getHeroList(){
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("superman","Clark_Kent","fly"));
        heroes.add(new Hero("spiderman","Peter_Parker","strength"));
        heroes.add(new Hero("flash","Barry_Allen","speed"));
        heroes.add(new Hero("Storm","Aurora","fly"));
        heroes.add(new Hero("colosous","peter","strength"));
        heroes.add(new Hero("quicksilver","blabla","speed"));

        return heroes;
    }

}