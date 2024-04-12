package lova.app.tenaizy

import android.os.Bundle
import android.window.SplashScreen
import androidx.compose.material3.Icon
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import lova.app.tenaizy.ui.theme.TenaIzyTheme
import java.text.NumberFormat
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import lova.app.tenaizy.ui.theme.TenaIzyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TenaIzyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    /*GreetingText(
                        message = "Happy Birthday Lova!",
                        from = "From Ranja",
                        modifier = Modifier.padding(8.dp)
                    )*/
                    //TipTimeLayout()
                    SplashScreen()
                }
            }
        }
    }
}



@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            color = Color.Green,
            fontSize = 94.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}


@Composable
fun FormulaireLayout() {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 40.dp)
                .padding(top = 24.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //Date
            Text(
                text = stringResource(R.string.date),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            EditDateField(
                label = R.string.date,
                leadingIcon = R.drawable.calendrier1,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            //Heure
            Text(
                text = stringResource(R.string.heure),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            EditHeureField(
                label = R.string.heure,
                leadingIcon = R.drawable.lhorloge1,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            //Lieu
            Text(
                text = stringResource(R.string.lieu),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            EditLieuField(
                label = R.string.lieu,
                leadingIcon = R.drawable.marqueur1,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            //Nom événement
            Text(
                text = stringResource(R.string.nom_event),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            EditNomField(
                label = R.string.nom_event,
                leadingIcon = R.drawable.calendar_star1,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            //Type événement
            Text(
                text = stringResource(R.string.theme),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            EditTypeField(
                label = R.string.theme,
                leadingIcon = R.drawable.category1,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            //Participants
            Text(
                text = stringResource(R.string.participants),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            EditParticipantsField(
                label = R.string.participants,
                leadingIcon = R.drawable.users_alt1,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            //Descri
            Text(
                text = stringResource(R.string.descri),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            EditDescriField(
                label = R.string.descri,
                leadingIcon = R.drawable.edit1,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(150.dp))
        }
}

//Textfield date
@Composable
fun EditDateField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {

    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.format_date)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer la date...")
        }
    )
}

//Textfield heure
@Composable
fun EditHeureField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.format_heure)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer l'heure...")
            }
    )
}

//Textfield Lieu
@Composable
fun EditLieuField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.adresse)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer le lieu...")
        }
    )
}

//Textfield nom événement
@Composable
fun EditNomField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.event)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer le nom de l'évènement...")
        }
    )
}

//Textfield type événement
@Composable
fun EditTypeField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.type)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer le type d'évènement...")
        }
    )
}

//Participants
@Composable
fun EditParticipantsField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.membres)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer les participants...")
        }
    )
}

//Description de l'évènement
@Composable
fun EditDescriField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.resume)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer une description sur l'évènement...")
        }
    )
}


//Fonction pour le calcul de pourboire
private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

/*@Preview(showBackground = true)
@Composable
fun TipTimePreview() {
    TenaIzyTheme {
        //Greeting("Lova")
        //GreetingText(message = "Happy Birthday Lova!", from = "From Ranja")
        TipTimeLayout()
    }
}*/

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.background_get)
    Box(modifier) {
        Image(
            modifier = Modifier.size(900.dp),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
        )
        FormulaireLayout()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TenaIzyTheme {
        //Greeting("Lova")
        //GreetingText(message = "Happy Birthday Lova!", from = "From Ranja")
        SplashScreen()
    }
}