package com.example.apprecuperacionfranciscopereztejera.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apprecuperacionfranciscopereztejera.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem() {

    Card(
        onClick = { },
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color(red = 62, green = 62, blue = 62)),
        shape =  RoundedCornerShape(10.dp),
        border = BorderStroke(4.dp, Color.White)
    ) {
        Row {
            Text(
                text = "Tipo de vehículo: Turiusmo",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(10.dp),
                color = Color.White)
        }
        Spacer(modifier = Modifier
            .height(1.dp)
            .background(Color.White))
        
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 35.dp, top = 10.dp, bottom = 20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logazo),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
                    .weight(1f)
            ) {
                Text(text = "Marca: Ford",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White)
                Text(text = "Modelo: Fiesta",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White)
                Text(text = " Precio: 3000 €",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White)
            }

        }
    }
}
@Preview
@Composable
fun LoginPreview() {
    CardItem()
}