package ru.zhogin.testtask18012024.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.zhogin.testtask18012024.data.models.ListServer
import ru.zhogin.testtask18012024.ui.theme.PurpleGrey40
import ru.zhogin.testtask18012024.utils.CommonUtils

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    list: List<ListServer>
) {
    LazyColumn() {


        items(list.size) { item ->
            Item(item = list[item])

        }
    }
}
// of course I should use dividers but copy and paste was faster way

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Item(
    item: ListServer
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(PurpleGrey40)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = item.title,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp),
                fontWeight = FontWeight.Bold

            )
            Text(
                text = item.description,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp, start = 4.dp, end = 4.dp)
            )
            Row {
                Text(
                    text = "Type:",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, start = 4.dp)
                )
                Text(
                    text = item.type.title,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
                )
            }
            Row {
                Text(
                    text = "Tags:",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, start = 4.dp)
                )
                LazyRow {
                    items(item.tags.size) { tag ->
                        Text(
                            text = item.tags[tag],
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
                        )
                    }
                }
            }
            HyperlinkText(
                fullText = item.url, modifier = Modifier
                    .padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
            )
            Row {
                Text(
                    text = "Date time stamp:",
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
                )
                Text(
                    text = CommonUtils.convertLongToTime(item.dateTimestamp),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
                )
            }
            Row {
                Text(
                    text = "Start date time stamp:",
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
                )

                Text(
                    text = CommonUtils.convertLongToTime(item.startDateTimestamp),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
                )
            }
            Row {
                Text(
                    text = "End date time stamp:",
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
                )
                Text(
                    text = CommonUtils.convertLongToTime(item.endDateTimestamp),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp, end = 4.dp, start = 4.dp)
                )
            }


        }
    }
}
// took this function from another project and because i was in a hurry didn't have enough time to property adapted to this project
@Composable
fun HyperlinkText(
    modifier: Modifier = Modifier,
    fullText: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    linkTextColor: Color = Color.Blue,
    linkTextFontWeight: FontWeight = FontWeight.Medium,
    linkTextDecoration: TextDecoration = TextDecoration.Underline,


    ) {
    val annotatedString = buildAnnotatedString {
        append(fullText)
        fullText.forEachIndexed { index, link ->
            val startIndex = 0
            val endIndex = startIndex + fullText.length - 1
            addStyle(
                style = SpanStyle(
                    color = linkTextColor,

                    fontWeight = linkTextFontWeight,
                    textDecoration = linkTextDecoration
                ),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "URL",
                annotation = fullText,
                start = startIndex,
                end = endIndex
            )
        }
        addStyle(
            style = SpanStyle(
                fontSize = fontSize
            ),
            start = 0,
            end = fullText.length - 1
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        onClick = {
            annotatedString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}