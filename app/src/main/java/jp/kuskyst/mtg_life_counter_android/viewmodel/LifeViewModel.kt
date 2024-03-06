package jp.kuskyst.mtg_life_counter_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity
import jp.kuskyst.mtg_life_counter_android.model.repository.LifeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class LifeViewModel @Inject constructor(
    private val repository: LifeRepository
) :  ViewModel() {

    val life = MutableLiveData<LifeEntity>()

    fun getLife() {
        this.viewModelScope.launch(Dispatchers.IO) {
            life.postValue(repository.getLife(LocalDate.now().toString()))
        }
    }

    fun saveLife(entity: LifeEntity) {
        this.viewModelScope.launch(Dispatchers.IO) {
            repository.saveLife(entity)
            life.postValue(entity)
        }
    }

}