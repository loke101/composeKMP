package Presentation.components.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.icerockdev.library.MR
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

data class MenuItems(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: Painter
)


@OptIn(ExperimentalResourceApi::class)
@Composable
fun getDrawerMenuItems(): List<MenuItems> {
    return listOf(
        MenuItems(
            id = "home",
            title = "Home",
            contentDescription = "Go to home screen",
            icon = dev.icerock.moko.resources.compose.painterResource(MR.images.dashboard_1)
        ),
        MenuItems(
            id = "sendMoney",
            title = "Send Money",
            contentDescription = "Go to send screen",
            icon = dev.icerock.moko.resources.compose.painterResource(MR.images.send_money_1)
        ),
        MenuItems(
            id = "transactionHistory",
            title = "Transaction History",
            contentDescription = "Go to trans screen",
            icon = dev.icerock.moko.resources.compose.painterResource(MR.images.file_1)
        ),
        MenuItems(
            id = "callLogs",
            title = "Call Logs",
            contentDescription = "Go to logs screen",
            icon = dev.icerock.moko.resources.compose.painterResource(MR.images.call_logs_1)
        ),
        MenuItems(
            id = "missCall",
            title = "Missed Calls",
            contentDescription = "Go to missed screen",
            icon = dev.icerock.moko.resources.compose.painterResource(MR.images.missed_call_1)
        ),
        MenuItems(
            id = "support",
            title = "Support",
            contentDescription = "Go to support screen",
            icon = dev.icerock.moko.resources.compose.painterResource(MR.images.customer_support_1)
        ),
        MenuItems(
            id = "aboutUs",
            title = "About Us",
            contentDescription = "Go to about screen",
            icon = dev.icerock.moko.resources.compose.painterResource(MR.images.info_1)
        ),
        MenuItems(
            id = "logout",
            title = "Logout",
            contentDescription = "Go to logout screen",
            icon = dev.icerock.moko.resources.compose.painterResource(MR.images.logout_1)
        ),


        )
}
