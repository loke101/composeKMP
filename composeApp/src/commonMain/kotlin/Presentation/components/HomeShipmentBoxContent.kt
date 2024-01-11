package Presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun HomeBoxContent() {
    Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            ShipmentBoxScreen(   //Undelivered
                imgIcon = painterResource(MR.images.undelivered_1),
                shipmentStatus = "Undelivered",
                shipmentCount = "20",
                color = listOf(
                    colorResource(MR.colors.undeliveredStartColor),
                    colorResource(MR.colors.undeliveredEndColor)
                )
            )
            Spacer(modifier = Modifier.padding(8.dp))
            ShipmentBoxScreen(   //NotAttempted
                imgIcon = painterResource(MR.images.notattempted_1),
                shipmentStatus = "Not Attempted",
                shipmentCount = "23",
                color = listOf(
                    colorResource(MR.colors.notAttemeptedStartColor),
                    colorResource(MR.colors.notAttemeptedEndColor)
                )
            )

        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            ShipmentBoxScreen(   //Undelivered
                imgIcon = painterResource(MR.images.deliveredimg_1),
                shipmentStatus = "Delivered",
                shipmentCount = "20",
                color = listOf(
                    colorResource(MR.colors.deliveredStartColor),
                    colorResource(MR.colors.deliveredEndColor)
                )
            )
            Spacer(modifier = Modifier.padding(9.dp))
            ShipmentBoxScreen(   //NotAttempted
                imgIcon = painterResource(MR.images.boxes_2),
                shipmentStatus = "Total Shipments",
                shipmentCount = "23",
                color = listOf(
                    colorResource(MR.colors.totalStartColor),
                    colorResource(MR.colors.totalEndColor)
                )
            )
        }
    }


}