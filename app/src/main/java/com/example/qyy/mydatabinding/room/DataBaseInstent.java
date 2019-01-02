package com.example.qyy.mydatabinding.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

public class DataBaseInstent {
    private static MyDataBase myDataBase;

    public static MyDataBase getDataBase(Context context) {
        if (myDataBase == null) {
            myDataBase = Room.databaseBuilder(context, MyDataBase.class, "qyydata")
                    .allowMainThreadQueries()//room 是不支持主线程访问，除非加上这句
                    .addMigrations(MIGRATION_1_2,MIGRATION_2_3,MIGRATION_3_4)
                    .build();
        }
        return myDataBase;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `Fruit` (`fruitid` INTEGER, "
                    + "`name` TEXT, PRIMARY KEY(`fruitid`))");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE qyy "
                    + " ADD COLUMN pub_year TEXT");
        }
    };
    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE qyy "
                    + " ADD COLUMN two TEXT");
        }
    };
}
