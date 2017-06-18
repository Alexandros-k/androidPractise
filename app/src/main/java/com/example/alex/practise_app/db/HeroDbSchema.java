package com.example.alex.practise_app.db;

import android.provider.BaseColumns;

/**
 * Created by Alex on 6/12/2017.
 */

public class HeroDbSchema {

    public HeroDbSchema() {
    }

public static abstract class HeroTable implements BaseColumns{
    public static final String TABLE_NAME="heros";
    public static final String COLUMN_NAME_CODENAME="code_name";
    public static final String COLUMN_NAME_REALNAME="real_name";
    public static final String COLUMN_NAME_SUPERPOWER ="superpower";



}
}
