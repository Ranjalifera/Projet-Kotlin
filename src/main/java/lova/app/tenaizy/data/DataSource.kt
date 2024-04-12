package lova.app.tenaizy.data

import lova.app.tenaizy.R
import lova.app.tenaizy.model.Event

class DataSource() {
    fun loadEvent(): List<Event> {
        return listOf<Event>(
            Event(R.string.conf, R.drawable.background2_tech),
            Event(R.string.minipr, R.drawable.background_tech),
            Event(R.string.algo, R.drawable.background2_tech),
            Event(R.string.jardinage, R.drawable.background_tech),
            Event(R.string.sport, R.drawable.background2_tech),
            Event(R.string.recep, R.drawable.background_tech),
        )
    }
}