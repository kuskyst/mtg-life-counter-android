package jp.kuskyst.mtg_life_counter_android.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.kuskyst.mtg_life_counter_android.model.db.LifeDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, LifeDatabase::class.java, "life").build()

    @Singleton
    @Provides
    fun provideDao(db: LifeDatabase) = db.lifeDao()

}