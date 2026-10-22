package org.umn.servisin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.umn.servisin.ReusableComponents.RatingStars
import org.umn.servisin.datas.ServisDataSource
import org.umn.servisin.model.Worker
import org.umn.servisin.navigation.Screen
import org.umn.servisin.ui.theme.mainGradientBrush
import java.text.NumberFormat
import java.util.Locale

@Composable
fun WorkerProfile(navController: NavController, worker: Worker) {
    val WorkerProfile = ServisDataSource.workers
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainGradientBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 48.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White.copy(alpha = 0.6f), shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Text(
                    text = "Worker Profile",
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = {  },
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White.copy(alpha = 0.6f), shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }


            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = worker.picture),
                    contentDescription = "${worker.name}'s picture",
                    modifier = Modifier.size(355.dp)
                )

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .align(Alignment.BottomCenter),
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Column(
                        modifier = Modifier.padding(30.dp, top = 60.dp)
                    ) {
                        Row() {
                            Text(
                                "${worker.name}",
                                style = MaterialTheme.typography.displayLarge.copy(
                                    color = MaterialTheme.colorScheme.primary,
                                    textAlign = TextAlign.Center
                                )
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(
                                    onClick = { },
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(
                                            Color(0xFF157145),
                                            shape = CircleShape
                                        )
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Chat,
                                        contentDescription = "Chat",
                                        tint = Color.White
                                    )
                                }

                                Spacer(modifier = Modifier.width(8.dp))

                                IconButton(
                                    onClick = { },
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(
                                            Color(0xFF157145),
                                            shape = CircleShape
                                        )
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Call,
                                        contentDescription = "Call",
                                        tint = Color.White
                                    )
                                }
                            }
                        }


                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(fontWeight = FontWeight.Bold)
                                ) {
                                    append(
                                        "Rp. ${
                                            NumberFormat.getNumberInstance(Locale("id", "ID"))
                                                .format(worker.payPerHour)
                                        }"
                                    )
                                }
                                append(" / Jam")
                            },
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center
                            )
                        )

                        Spacer(modifier = Modifier.padding(12.dp))

                        WorkerSkills(worker = worker)

                        Spacer(modifier = Modifier.padding(12.dp))

                        Text(
                            "Deskripsi: ${worker.description}"
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Review",
                                style = MaterialTheme.typography.displayLarge.copy(
                                    color = MaterialTheme.colorScheme.primary,
                                    textAlign = TextAlign.Center
                                )
                            )

                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "expand review",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                        Button(
                            onClick = {

                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(65.dp)
                        ) {
                            Text(
                                text = "Pesan Sekarang",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    color = MaterialTheme.colorScheme.surface
                                )
                            )
                        }

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .offset(y = 300.dp)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF157145))
                            .padding(16.dp)
                    ) {
                        Text(
                            "Experience",
                            style = MaterialTheme.typography.labelLarge.copy(
                                color = MaterialTheme.colorScheme.surface
                            )
                        )
                        Text(
                            "${worker.experience} years",
                            style = MaterialTheme.typography.titleLarge.copy(
                                color = MaterialTheme.colorScheme.surface
                            )
                        )
                    }

                    Spacer(modifier = Modifier.padding(20.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF157145))
                            .padding(16.dp)
                    ) {
                        Text(
                            "Rating",
                            style = MaterialTheme.typography.labelLarge.copy(
                                color = MaterialTheme.colorScheme.surface
                            )
                        )

                        Spacer(modifier = Modifier.padding(4.dp))

                        RatingStars(
                            rating = worker.rating,
                            Color.White
                        )
                    }
                }


            }
        }
    }
}

@Composable
fun WorkerSkills(worker: Worker) {
    Row {
        Text(
            text = "Keahlian: ",
            modifier = Modifier.padding(top = 6.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            worker.keahlian.forEach { skill ->
                Text(
                    text = skill,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFFE0F2E9))
                        .padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        ),
                    color = Color(0xFF157145),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkerProfilePreview() {
    WorkerProfile(
        navController = rememberNavController(),
        worker = ServisDataSource.workers[0]
    )
}

