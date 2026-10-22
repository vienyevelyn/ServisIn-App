
package org.umn.servisin.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.umn.servisin.ReusableComponents.RatingStars
import org.umn.servisin.datas.ServisDataSource
import org.umn.servisin.model.Worker
import org.umn.servisin.navigation.Screen
import org.umn.servisin.ui.theme.mainGradientBrush

private val StarGold = Color(0xFFF2B01E)

@Composable
fun WorkerCategory(navController: NavController) {
    val workers = ServisDataSource.workers

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainGradientBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 48.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 20.dp
                )
        ) {
            // Header: Back button, title, filter
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
                        .background(
                            Color.White.copy(alpha = 0.6f),
                            CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Text(
                    text = "Our People",
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = { /* Add filter functionality here */ },
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            Color.White.copy(alpha = 0.6f),
                            CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = "Filter",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Search bar (visual only for now)
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                color = Color.White.copy(alpha = 0.6f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.6f
                        )
                    )

                    Text(
                        text = "Cari Nama..",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.5f
                            )
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "People Near You",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Worker list
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = workers,
                    key = { it.name }
                ) { worker ->
                    WorkerCard(
                        worker = worker,
                        onBookNowClick = {
                            navController.navigate(
                                "WorkerProfile/${Uri.encode(worker.name)}"
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun WorkerCard(
    worker: Worker,
    onBookNowClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            // Worker picture
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
                    .background(Color(0xFFE2E6E3)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = worker.picture),
                    contentDescription = worker.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        horizontal = 12.dp,
                        vertical = 10.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                // Worker name and booking button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = worker.name,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ),
                        maxLines = 1,
                        modifier = Modifier.weight(1f)
                    )
                }

                // Worker rating and review count
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingStars(
                        rating = worker.rating,
                        Color(0xFF157145)
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = String.format("%.1f", worker.rating),
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                }

                // Worker expertise badges
                if (worker.keahlian.isNotEmpty()) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        worker.keahlian.forEach { skill ->
                            Text(
                                text = "• $skill",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.Black,
                                    fontSize = 11.sp,
                                    lineHeight = 15.sp
                                )
                            )
                        }
                    }
                }

                // Worker experience
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Experience",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(3.dp))

                    Text(
                        text = "${worker.experience} years experience",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 11.sp
                        )
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ){
                    // Hourly rate
                    Text(
                        text = "Rp. ${
                            java.text.NumberFormat
                                .getNumberInstance(java.util.Locale("id", "ID"))
                                .format(worker.payPerHour)
                        } / Jam",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Button(
                        onClick = onBookNowClick,
                        shape = RoundedCornerShape(50.dp),
                        contentPadding = PaddingValues(
                            horizontal = 10.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor =
                                MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier.height(30.dp)
                    ) {
                        Text(
                            text = "Book Now",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 11.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WorkerCategoryPreview() {
    WorkerCategory(
        navController = rememberNavController()
    )
}
