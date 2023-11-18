import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herathunter.R
import kotlin.math.roundToInt

@Composable
fun Screen1() {
    Surface (
        color= Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        val photos = listOf(R.drawable.photo1, R.drawable.pic4, R.drawable.photo1)
        SwipeablePictureScreen(photos)
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeablePictureScreen(photos: List<Int>) {
    var currentPhotoIndex by remember { mutableStateOf(0) }
    var offsetX by remember { mutableStateOf(0f) }

    val pictureWidth = 1f.dp
    val screenWidth = 1f.dp

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            // Picture in the middle that can be swiped
            Box(
                modifier = Modifier
                    .fillParentMaxSize()
                    .background(Color.Red)
                    .swipeable(
                        state = rememberSwipeableState(initialValue = offsetX),
                        anchors = mapOf(0f to 0f, (screenWidth - pictureWidth.value.dp).value to (screenWidth - pictureWidth.value.dp).value),
                        thresholds = { _, _ -> FractionalThreshold(0.05f) },
                        orientation = Orientation.Horizontal
                    )
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { _, dragAmount ->
                            val newIndex = currentPhotoIndex - (dragAmount.dp / pictureWidth).roundToInt()
                            val newOffsetX = screenWidth.value * newIndex.toFloat()
                            if (newIndex in photos.indices &&
                                newOffsetX >= 0 &&
                                newOffsetX <= (photos.size - 1) * screenWidth.value) {
                                currentPhotoIndex = newIndex
                                offsetX = newOffsetX
                            }
                        }
                    }
            ) {
                Image(
                    painter = painterResource(id = photos[currentPhotoIndex]),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit,
                    contentDescription = null
                )
            }
        }
    }
}
@Composable
fun PhotoSlider(photos: List<Int>){

}



@Composable
fun Screen2() {
    PhotoGallery()
}

@Composable
fun PhotoGallery() {
    val photos = listOf(
        PhotoItem(R.drawable.photo1, "Фото 1"),
        PhotoItem(R.drawable.photo1, "Фото 2"),
        PhotoItem(R.drawable.photo1, "Фото 3"),
        PhotoItem(R.drawable.photo1, "Фото 4"),
        PhotoItem(R.drawable.photo1, "Фото 5"),
        PhotoItem(R.drawable.photo1, "Фото 6"),
        PhotoItem(R.drawable.photo1, "Фото 7"),
        PhotoItem(R.drawable.photo1, "Фото 8"),
        // Добавьте больше фотографий при необходимости
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp, start = 16.dp, end = 16.dp) // Учитываем высоту навигационной панели и добавляем отступы
    ) {
        item {
            Text(text = "Matches", fontSize = 30.sp)
        }
        items(photos.chunked(2)) { rowPhotos ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                for (photo in rowPhotos) {
                    PhotoItem(photo)
                }
            }
        }

        // Добавляем Spacer для пустого пространства под фотографиями
        item {
            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}

@Composable
fun PhotoItem(photoItem: PhotoItem) {
    Box(
        modifier = Modifier
            .size(width = 190.dp, height = 300.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = photoItem.imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(8.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = photoItem.caption,
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
}

data class PhotoItem(val imageRes: Int, val caption: String)


@Composable
fun Screen3(onClick:()->Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)//отступ
            .clickable {
                Log.d("MyLog", "Clicked")
            },) {
        itemsIndexed(
            listOf("Name1,Surname1","Name2,Surname2","Name3,Surname3","Name4,Surname4","Name3,Surname3","Name4,Surname4")
        ){ index,item-> //itemsIndexed вернет индекс и значение по списку
            val args=item.toString().split(",")
            ListItem(args[0],args[1],onClick)
        }
    }

}
@Composable
fun Screen4() {
    YourProfile()
}
@Composable
fun YourProfile()
{
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)//отступ
    ) {
        Image (
            painter = painterResource(id = R.drawable.photo1),
            contentDescription = null, // Provide a description if needed for accessibility
            contentScale= ContentScale.Crop,//обрезать картинку если не влазит
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)// круглая форма
        )
        Text("Name Surname",fontSize = 30.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp))
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 120.dp),contentAlignment = Alignment.TopCenter){

        val email = remember{mutableStateOf("")}
        Column(modifier=Modifier.padding(20.dp)) {
            TextField(
                value = email.value,
                onValueChange = {
                    // Заменяем пробелы на пустую строку
                    val newValue = it.replace("\\s".toRegex(), "")
                    email.value = newValue
                },
                textStyle = TextStyle(fontSize =  28.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp)) // Добавляем пространство между элементами
            Row {
                Button(
                    onClick = {},
                    border = BorderStroke(3.dp, Color.DarkGray)
                ) {
                    Text("Edit profile", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.width(16.dp)) // Добавляем пространство между кнопками
                Button(
                    onClick = {},
                    border = BorderStroke(3.dp, Color.DarkGray)
                ) {
                    Text("Settings", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
fun Screen5(onClick:()->Unit) {
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)//отступ
      ) {
        Image (
            painter = painterResource(id = R.drawable.icon2),
            contentDescription = null, // Provide a description if needed for accessibility
            contentScale= ContentScale.Crop,//обрезать картинку если не влазит
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)// круглая форма
                .clickable {
                    onClick()
                    Log.d("MyLog", "Clicked")
                },
        )
        Image (
            painter = painterResource(id = R.drawable.photo1),
            contentDescription = null, // Provide a description if needed for accessibility
            contentScale= ContentScale.Crop,//обрезать картинку если не влазит
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)// круглая форма
        )
        Text("Name Surname", textAlign= TextAlign.Center,fontSize = 25.sp)

    }
}
@Composable
private fun ListItem(name: String,surname:String,onClick:()->Unit)
{
    Card(       //контейнер для каждой строки ( выступ, углы и тд)
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)//отступ
            .clickable {
                onClick()
                Log.d("MyLog", "Clicked")
            },
        shape = RoundedCornerShape(15.dp),//закругление углов
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp) //подьем над экраном
    ) {
        Box()
        {
            Row(){//элементы по горизонтали
                Image(
                    painter = painterResource(id = R.drawable.photo1),
                    contentDescription = null, // Provide a description if needed for accessibility
                    contentScale= ContentScale.Crop,//обрезать картинку если не влазит
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)// круглая форма
                )
                Column(modifier= Modifier.padding(start=16.dp)){//элементы по вертикали
                    androidx.compose.material3.Text(name+"  "+surname)
                    androidx.compose.material3.Text("Privios message")
                }
            }
        }
    }
}