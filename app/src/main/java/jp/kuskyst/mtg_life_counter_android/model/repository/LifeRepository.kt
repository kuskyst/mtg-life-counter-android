package jp.kuskyst.mtg_life_counter_android.model.repository

import jp.kuskyst.mtg_life_counter_android.model.dao.LifeDao
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity
import javax.inject.Inject

class LifeRepository @Inject constructor(private val lifeDao: LifeDao) {

    fun getLife(): LifeEntity {
        val res = lifeDao.getLife()
        return if (res.isEmpty()) LifeEntity("1", 20, 20) else res[0]
    }

    fun saveLife(entity: LifeEntity) {
        lifeDao.saveLife(entity)
    }

}