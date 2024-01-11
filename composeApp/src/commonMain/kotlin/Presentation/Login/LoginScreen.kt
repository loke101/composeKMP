package Presentation.Login

import Presentation.Home.HomeScreen
import Presentation.components.VerifyOtpDialogMain
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

class LoginScreen :Screen{
    @Composable
    override fun Content() {
        val localNavigator = LocalNavigator.currentOrThrow
        LoginScreenMain(localNavigator)
    }

}


@Composable
fun LoginScreenMain(localNavigator: Navigator){
    val openDialog = remember { mutableStateOf(false) }
    Scaffold(Modifier.fillMaxSize()){
        LoginScreenContent(onSendOtp = {openDialog.value=true},
            openDialog = openDialog.value,
            onDismiss = {openDialog.value = false},
            onOkClicked={localNavigator.push(HomeScreen())}
        )

    }

}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun LoginScreenContent(onSendOtp: () -> Unit, openDialog:Boolean,onDismiss:()->Unit,onOkClicked:()->Unit) {
    Column(
        Modifier
            .background(colorResource(MR.colors.backColor))
            .fillMaxSize(),
    ) {
        Box(
            Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(MR.images.login_back_1),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.98f)
                    .fillMaxHeight(0.90f)
                    .align(Alignment.Center)
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 150.dp, top = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(MR.strings.dependo),
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif

                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp, start = 10.dp),
            ) {
                Text(
                    text = stringResource(MR.strings.welcome_to),
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = stringResource(MR.strings.stc_riders_app),
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = stringResource(MR.strings.please_sign_in_to_continue),
                    Modifier.padding(top = 18.dp),
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.DarkGray

                )
                Column(
                    Modifier
                        .padding(top = 75.dp, start = 10.dp).
                        fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = { mobile -> },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),


                        modifier = Modifier.align(Alignment.Start),
                        label = {
                            Text(
                                text = stringResource(MR.strings.enter_your_mobile_number),
                                style = MaterialTheme.typography.subtitle1,
                                fontFamily = FontFamily.SansSerif
                            )
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Rounded.Person,
                                contentDescription = "",
                                tint = Color.DarkGray
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(),
                        singleLine = true,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                onSendOtp.invoke()
                            },

                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(),
                        ) {
                            Text(text = "Send OTP", modifier = Modifier.padding(4.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                Icons.Rounded.ArrowForward,
                                contentDescription = "login",
                                tint = Color.White
                            )

                        }
                    }
                }

            }


        }
        when {
            openDialog -> {
                VerifyOtpDialogMain(onOk = {onOkClicked.invoke()}, isDialogVisible =openDialog , onDismiss = {onDismiss.invoke()})
            }
        }

    }
}