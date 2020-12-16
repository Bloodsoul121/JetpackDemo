package com.blood.jetpackdemo.room;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.blood.jetpackdemo.MainApplication;

@TypeConverters({Converters.class})
@Database(entities = {User.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "app.db";

    private static class Holder {
        private static final AppDatabase sInstance = Room.databaseBuilder(MainApplication.getContext(), AppDatabase.class, DB_NAME)
                .addMigrations(new Migration(1, 2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE users ADD COLUMN level INTEGER not null Default 1");
                    }
                })
                .addMigrations(new Migration(2, 3) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE users ADD COLUMN birthday INTEGER not null Default 0");
                    }
                })
//                .addMigrations(new Migration(2, 3) {
//                    @Override
//                    public void migrate(@NonNull SupportSQLiteDatabase database) {
//                        database.execSQL("ALTER TABLE users ADD COLUMN sex INTEGER not null Default 0");
//                    }
//                })
//                .addMigrations(new Migration(3, 4) {
//                    @Override
//                    public void migrate(@NonNull SupportSQLiteDatabase database) {
//                        database.execSQL("ALTER TABLE users ADD COLUMN coin INTEGER not null Default 10");
//                    }
//                })
                .fallbackToDestructiveMigration() // 升级, 当未匹配到版本的时候就会直接删除表然后重新创建。
                .allowMainThreadQueries()
                .build();
    }

    public static AppDatabase getInstance() {
        return Holder.sInstance;
    }

    public abstract UserDao getUserDao();

}
