package jp.kuskyst.mtg_life_counter_android.model.repository

import jp.kuskyst.mtg_life_counter_android.model.dao.LifeDao
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity
import javax.inject.Inject

class LifeRepository @Inject constructor(private val lifeDao: LifeDao) {

    fun getLife(date: String): LifeEntity {
        return this.lifeDao.getLife(date) ?: LifeEntity(date, 20, 20)
    }

    fun saveLife(entity: LifeEntity) {
        this.lifeDao.saveLife(entity)
    }

}