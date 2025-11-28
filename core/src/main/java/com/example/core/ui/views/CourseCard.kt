import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.ui.theme.AppColors

@Composable
fun CourseCard(
    title: String,
    description: String,
    price: String,
    rate: String,
    startDate: String,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(236.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(AppColors.DarkGray)
    ) {
        // Cover (заглушка)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(114.dp)
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .background(Color.Gray) // TODO: заменить на ImageLoader
        )

        Column(
            modifier = Modifier
                .padding(top = 130.dp, start = 16.dp, end = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = title,
                    style = AppTypography.titleMedium,
                    color = AppColors.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = description,
                    style = AppTypography.bodySmall,
                    color = AppColors.White.copy(alpha = 0.7f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "$price ₽",
                    style = AppTypography.titleMedium,
                    color = AppColors.White
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    // Rating
                    Box(
                        modifier = Modifier
                            .background(AppColors.Glass, RoundedCornerShape(12.dp))
                            .padding(vertical = 4.dp, horizontal = 6.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = null, tint = AppColors.White, modifier = Modifier.size(12.dp))
                            Text(text = rate, style = AppTypography.labelSmall, color = AppColors.White)
                        }
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    // Date
                    Box(
                        modifier = Modifier
                            .background(AppColors.Glass, RoundedCornerShape(12.dp))
                            .padding(vertical = 4.dp, horizontal = 6.dp)
                    ) {
                        Text(text = startDate, style = AppTypography.labelSmall, color = AppColors.White)
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.clickable { onFavoriteClick() }
                ) {
                    Text(
                        text = "Подробнее",
                        style = AppTypography.labelMedium,
                        color = AppColors.White
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = AppColors.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        // Bookmark button (top-right)
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 8.dp, end = 8.dp)
                .size(28.dp)
                .background(
                    color = if (isFavorite) AppColors.Green else AppColors.Glass,
                    shape = RoundedCornerShape(14.dp)
                )
                .clickable { onFavoriteClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = null,
                tint = AppColors.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}