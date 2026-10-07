package kr.ac.kumoh.ce.s20240463.s26w06lazylist.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kr.ac.kumoh.ce.s20240463.s26w06lazylist.model.Song

class SongViewModel : ViewModel() {
    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()
//    val songs: StateFlow<List<Song>> = _songs.asStateFlow()

    init {
        add(Song(1, "Neon Horizon", "Pixel Wave"))
        add(Song(2, "Midnight Coffee", "The Afterhours"))
        add(Song(3, "Gravity Reset", "Lunarcat"))
    }

    fun add(song: Song) {
        // 새로운 리스트를 만들고 song 추가
        // Shallow copy
        _songs.update { it + song }
    }
}