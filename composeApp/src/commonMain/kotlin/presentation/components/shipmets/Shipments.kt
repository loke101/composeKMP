package presentation.components.shipmets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource

class Shipments {

}

@Composable
fun ShipmentListMain() {

}

@Composable
fun ShipmentListContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color.White
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(MR.images.person_shipment_1),
                            "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            "Autl Sethi",
                            fontFamily = FontFamily.SansSerif,
                            style = MaterialTheme.typography.body1
                        )
                        Image(
                            painterResource(MR.images.phone_call_1),
                            "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Change Status")
                        Image(painterResource(MR.images.editor_1), "")
                    }
                }
                Row {
                    Image(painterResource(MR.images.file_awb_2), "")
                    Text("CC001064646")
                }

            }
        }

    }

}

