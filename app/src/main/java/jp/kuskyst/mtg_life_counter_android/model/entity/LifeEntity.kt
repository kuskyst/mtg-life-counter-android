package jp.kuskyst.mtg_life_counter_android.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "life")
data class LifeEntity(
    @PrimaryKey
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "left")
    val left: Int,
    @ColumnInfo(name = "right")
    val right: Int
)