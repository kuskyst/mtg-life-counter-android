package jp.kuskyst.mtg_life_counter_android.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity

@Dao
interface LifeDao {

    @Query("SELECT * from life")
    fun get(): List<LifeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(lifeEntity: LifeEntity)

}