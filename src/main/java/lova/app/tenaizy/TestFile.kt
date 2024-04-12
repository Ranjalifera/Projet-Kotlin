package lova.app.tenaizy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lova.app.tenaizy.data.DataSource
import lova.app.tenaizy.model.Event

@Preview
@Composable
fun EventApp() {
    EventList(
        eventList = DataSource().loadEvent()
    )
}

@Composable
fun EventCard(event: Event, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Text(
                text = LocalContext.current.getString(event.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Image(
                painter = painterResource(event.imageResourceId),
                contentDescription = stringResource(event.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}

@Preview
@Composable
private fun EventCardPreview() {
    EventCard(Event(R.string.nom_event, R.drawable.background2_tech))
}

@Composable
fun EventList(eventList: List<Event>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(eventList) {event ->
            EventCard(
                event = event,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}