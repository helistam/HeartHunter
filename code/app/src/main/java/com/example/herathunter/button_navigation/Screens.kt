import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterVintage
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
        val photos = listOf(R.drawable.pic, R.drawable.pic2, R.drawable.pic3,R.drawable.pic4,R.drawable.pic5)
        val names=listOf("Jane 20 \n NOT funny ","Jhon 29 \n Funny ", "Misha 58 \nNOT Serious","Kate 18 \n Serious ", "Sara 29 \n Funny ")

        SwipeablePhotos(photos,names)
        //SwipeablePictureScreen(photos)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun SwipeablePhotos(photos: List<Int>, names: List<String>) {
    var currentPhotoIndex by remember { mutableStateOf(0) }
    var offsetX by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        // TopAppBar with buttons
        TopAppBar(
            title = {

            },
            navigationIcon = {
                // You can add a navigation icon or leave it empty
            },
            actions = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp) // Adjust the overall padding
                ) {
                    IconButton(onClick = {
                        // Handle button click
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = null,
                            tint = Color.Red // Set the desired color
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp)) // Adjust the spacing between icons
                    IconButton(onClick = {
                        // Handle button click
                    }) {
                        Icon(
                            imageVector = Icons.Default.HeartBroken,
                            contentDescription = null,
                            tint = Color.Green // Set the desired color
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp)) // Adjust the spacing between icons
                    IconButton(onClick = {
                        // Handle button click
                    }) {
                        Icon(
                            imageVector = Icons.Default.FilterVintage,
                            contentDescription = null,
                            tint = Color.Blue // Set the desired color
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp)) // Adjust the spacing between icons
                    IconButton(onClick = {
                        // Handle button click
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.dheart),
                            contentDescription = null,
                            tint = Color.Magenta // Set the desired color
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .height(50.dp) // Set the desired height
        )

        // Swipeable photos content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, _, _ ->
                        if (pan.x > 0) {
                            // Swipe to the right
                            offsetX += pan.x
                            if (offsetX > 200) {
                                currentPhotoIndex = (currentPhotoIndex + 1) % photos.size
                                offsetX = 0f
                            }
                        } else if (pan.x < 0) {
                            // Swipe to the left
                            offsetX += pan.x
                            if (offsetX < -200) {
                                currentPhotoIndex = (currentPhotoIndex - 1 + photos.size) % photos.size
                                offsetX = 0f
                            }
                        }
                    }
                }
        ) {
            Image(
                painter = painterResource(id = photos[currentPhotoIndex]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = offsetX.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = names[currentPhotoIndex],
                    color = Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
                )
            }
        }
    }
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
fun Screen4(currentTheme: Theme, onThemeChange: (Theme) -> Unit) {
    YourProfile(currentTheme)
    //дальше новое
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 312.dp, end = 15.dp)
    ) {
        Button(
            onClick = {
                val newTheme = if (currentTheme == Theme.Light) Theme.Dark else Theme.Light
                onThemeChange(newTheme)
            },
            modifier = Modifier.widthIn(max = 200.dp),
            border = BorderStroke(3.dp, Color.DarkGray)
        ) {
            Text(
                text = if (currentTheme == Theme.Light) "Switch to Dark Mode" else "Switch to Light Mode",
                fontSize = 20.sp,
                textAlign = TextAlign.Center, // Выравнивание текста по центру
                modifier = Modifier.padding(5.dp) // Отступы вокруг текста
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourProfile(currentTheme: Theme)
{

    Text(
        "Profile",
        color = Color.Red,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        fontWeight= FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp) // Уменьшил вертикальный отступ
    )

    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp,vertical = 60.dp)//отступ
    ) {
        val textColor = if (currentTheme == Theme.Light) Color.Black else Color.White
        Text("Name Surname", color = textColor,fontSize = 30.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp))
    }
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 30.dp, vertical = 140.dp)
    ) {
        val email = remember{mutableStateOf("")}
        val placeHolderColor = if (currentTheme == Theme.Light) Color.Black else Color.White
        Image(
            painter = painterResource(id = R.drawable.photo1),
            contentDescription = null, // Provide a description if needed for accessibility
            contentScale = ContentScale.Crop,//обрезать картинку если не влазит
            modifier = Modifier
                .size(130.dp)
                .clip(CircleShape)// круглая форма
        )
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            placeholder = { Text(text = "Tell the world a few words about yourself",color = placeHolderColor) }, // Плэйсхолдер
            textStyle = TextStyle(fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth().height(120.dp).padding(start = 16.dp)
        )
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 260.dp),contentAlignment = Alignment.TopCenter){
        val placeHolderColor = if (currentTheme == Theme.Light) Color.Black else Color.White
        val email = remember{mutableStateOf("")}
        Column(modifier=Modifier.padding(20.dp)) {
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                placeholder = { Text(text = "Share a glimplse of you! Briefly describe yourself and make your profile stand out",color = placeHolderColor) }, // Плэйсхолдер
                textStyle = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth().height(120.dp).padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp)) // Добавляем пространство между элементами
            Row {
                Button(
                    onClick = {},
                    border = BorderStroke(3.dp, Color.DarkGray)
                ) {
                    Text("Edit profile", fontSize = 20.sp, modifier = Modifier.padding(vertical = 17.dp, horizontal = 10.dp))
                }
                Spacer(modifier = Modifier.width(16.dp)) // Добавляем пространство между кнопками

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
                    androidx.compose.material3.Text("Previous message")
                }
            }
        }
    }
}