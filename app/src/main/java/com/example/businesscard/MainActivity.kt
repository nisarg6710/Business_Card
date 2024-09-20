package com.example.businesscard

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    BusinessCardApp()
                    BusinessCardApp2()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(){
    BusinessInfoCard(
      name = stringResource(R.string.name_for),
      description = stringResource(R.string.description_for_name),
//      backgroundColor = Color(0xff98fb98),
      image=  painterResource(R.drawable.android_logo)
    )
}

@Composable
fun BusinessCardApp2(){
    BusinessInfoCard2(
        phoneNumber = stringResource(R.string.phone_number),
        shareHandle = stringResource(R.string.X_handle),
        email = stringResource(R.string.email),
        image1 =  painterResource(R.drawable.call_24dp_e8eaed),
        image2 =  painterResource(R.drawable.share_24dp_e8eaed),
        image3 =  painterResource(R.drawable.email_24dp_e8eaed)
    )
}


@Composable
private fun BusinessInfoCard(
    name: String,
    description: String,
    image: Painter,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color(0xffffe5b4))
        .padding(top = 250.dp),

//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
//        Spacer(modifier = Modifier.height(.dp))
        Image(
            painter = image,
            contentDescription = "Image 1",
            modifier = Modifier
                .size(100.dp)
                .background(Color.Black)
//                .height(200.dp)
        )
//        Spacer(modifier = Modifier.height(200.dp))
        Text(
            text = name,
            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Red
        )
//        Spacer(modifier = Modifier.height(200.dp))

        Text(
            text = description,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp,
            color = Color.Red
        )
//        Spacer(modifier = Modifier.height(200.dp))
    }
}

@Composable
private fun BusinessInfoCard2(
    phoneNumber: String,
    shareHandle: String,
    email: String,
    image1: Painter,
    image2: Painter,
    image3: Painter,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(bottom = 35.dp, start = 105.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
        ){

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = image1,
                contentDescription = "image of phone",
                modifier = Modifier
                    .size(25.dp)
                    .width(200.dp)
                    .background(Color.Black)


            )
            Spacer(modifier = Modifier.width(8.dp)) // Adds space between the icon and text
            Text(
                text = phoneNumber,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Red
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = image2,
                contentDescription = "image of share sign",
                modifier = Modifier
                    .size(25.dp)
                    .background(Color.Black)

            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = shareHandle,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Red
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ){
            Icon(
                painter = image3,
                contentDescription = " image of mail sign",
                modifier = Modifier
                    .size(25.dp)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = email,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Red
            )
        }
        
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
        BusinessCardApp2()
    }
}