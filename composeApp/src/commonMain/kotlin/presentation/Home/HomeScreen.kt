package presentation.Home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource
import kotlinx.coroutines.launch
import presentation.components.DrawerBody
import presentation.components.DrawerHeader
import presentation.components.HomeBottomContent
import presentation.components.HomeBoxContent
import presentation.components.HomeTopContent
import presentation.components.TopBar
import presentation.components.menu.MenuItems
import presentation.components.menu.getDrawerMenuItems

class HomeScreen : Screen {
    @Composable
    override fun Content() {

        HomeMainScreen()
    }

}


@Composable
fun HomeMainScreen() {
    val drawerItems = remember { mutableStateListOf<MenuItems>() }
    drawerItems.addAll(getDrawerMenuItems())
    HomeScreenContent(drawerItems)
}

@Composable
private fun HomeScreenContent(
    drawerItems: SnapshotStateList<MenuItems>,
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {},
                text = { Text("Fuel") },
                icon = {
                    Icon(
                        painter = painterResource(MR.images.fuel_1),
                        contentDescription = "",
                        Modifier.size(24.dp),
                        tint = Color.White
                    )
                },
                backgroundColor = colorResource(MR.colors.blackOff),
                contentColor = Color.White,
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        topBar = {
            TopBar {
                scope.launch {
                    scaffoldState.drawerState.open()

                }

            }
        },
        drawerContent = {
            DrawerHeader()
            DrawerBody(items = (drawerItems), modifier = Modifier.width(290.dp), onItemClick = {})
        }

    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(it.calculateBottomPadding())
                .background(colorResource(MR.colors.backColor)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                //outer-card
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp
                ),
                elevation = 10.dp,
                backgroundColor = Color.White,

                ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Card(//inner-card
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        shape = RoundedCornerShape(18.dp),
                        elevation = 8.dp,
                        backgroundColor = colorResource(MR.colors.cardViewBack)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                                .fillMaxWidth(),
                            text = "Shipment Metrics",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif,
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),

                            ) {
                            Spacer(modifier = Modifier.height(50.dp))
                            HomeTopContent()
                            Spacer(modifier = Modifier.height(50.dp))
                            HomeBoxContent()

                        }

                    }
                    HomeBottomContent()
                }


            }


        }

    }
}

