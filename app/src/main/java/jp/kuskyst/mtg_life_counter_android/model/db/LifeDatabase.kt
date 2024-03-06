package jp.kuskyst.mtg_life_counter_android.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.kuskyst.mtg_life_counter_android.model.dao.LifeDao
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity

@Database(entities = [LifeEntity::class], version = 1)
abstract class LifeDatabase : RoomDatabase() {

    abstract fun lifeDao(): LifeDao

}