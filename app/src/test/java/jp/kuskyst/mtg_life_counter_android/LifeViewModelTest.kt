package jp.kuskyst.mtg_life_counter_android

import androidx.room.Room
import dagger.hilt.android.testing.HiltAndroidTest
import jp.kuskyst.mtg_life_counter_android.model.db.LifeDatabase
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity
import jp.kuskyst.mtg_life_counter_android.model.repository.LifeRepository
import jp.kuskyst.mtg_life_counter_android.viewmodel.LifeViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import java.time.LocalDate

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
class LifeViewModelTest {

    private val now = LocalDate.now().toString()
    private lateinit var target: LifeViewModel

    @Before
    fun setUp() {
        this.target = LifeViewModel(LifeRepository(Room
                .databaseBuilder(RuntimeEnvironment.getApplication().applicationContext,
                    LifeDatabase::class.java, "life")
                .build().lifeDao()))
    }

    @Test
    fun getLife_notExist() {
        this.target.getLife()
        this.target.life.observeForever {
            assertEquals(20, it.left)
            assertEquals(20, it.right)
        }
    }

    @Test
    fun saveLife_success() {
        this.target.saveLife(LifeEntity(now, 10, 10))
        this.target.life.observeForever {
            assertEquals(10, it.left)
            assertEquals(10, it.right)
        }
    }

    @Test
    fun getLife_exist() {
        this.target.getLife()
        this.target.life.observeForever {
            assertEquals(10, it.left)
            assertEquals(10, it.right)
        }
    }

}