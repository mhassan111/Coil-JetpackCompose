package com.compose.coil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.*
import coil.request.ImageRequest
import coil.size.Size
import com.compose.coil.ui.theme.JetPackComposeTutTheme

class CoilImageLoading : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTutTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {


                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

//                        AsyncImage(
//                            modifier = Modifier.height(200.dp).width(200.dp),
//                            model = "https://source.unsplash.com/user/c_v_r",
//                            contentDescription = "Logo Image"
//                        )

//                        SubcomposeAsyncImage(
//                            model = "https://example.com/image.jpg",
//                            loading = {
//                                CircularProgressIndicator()
//                            },
//                            error = {
//                                Text("Error loading logo")
//                            },
//                            contentDescription = "Logo Image"
//                        )

//                        SubcomposeAsyncImage(
//                            model = "https://example.com/image.jpg",
//                            contentDescription = "Logo Image"
//                        ) {
//                            val state = painter.state
//                            if (state is AsyncImagePainter.State.Loading) {
//                                CircularProgressIndicator()
//                            } else if (state is AsyncImagePainter.State.Error) {
//                                SubcomposeAsyncImageContent()
//                            }
//                        }

                        val painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://source.unsplash.com/user/c_v_r")
                                .size(Size.ORIGINAL) // Set the target size to load the image at.
                                .build()
                        )

                        if (painter.state is AsyncImagePainter.State.Success) {
                            // This will be executed during the first composition if the image is in the memory cache.
                        } else if (painter.state is AsyncImagePainter.State.Loading) {
                            CircularProgressIndicator()
                        }
                        Image(painter = painter, contentDescription = "Logo Image")
                    }
                }
            }
        }
    }

}