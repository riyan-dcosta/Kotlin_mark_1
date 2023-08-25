package com.example.kotlin_mark_1.core.common.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun graphBackground(
    modifier: Modifier = Modifier.fillMaxWidth(),
    lineColor: Color = Color.Blue
) {
    Spacer(
        modifier = modifier
            .drawWithCache {
                onDrawBehind {
                    val barWidthPx = 1.dp.toPx()
                    drawRect(color = lineColor, style = Stroke(barWidthPx))
                    val verticalLine = 4
                    val verticalSize = size.width / (verticalLine + 1)
                    repeat(verticalLine) { i ->
                        val startX = verticalSize * (i + 1)
                        drawLine(
                            lineColor,
                            start = Offset(startX, 0.0F),
                            end = Offset(startX, size.height),
                            strokeWidth = barWidthPx
                        )
                    }
                    val horizontalLine = 3
                    val horizontalSize = size.height / (horizontalLine + 1)
                    repeat(horizontalLine) { i ->
                        val startY = horizontalSize * (i + 1)
                        drawLine(
                            lineColor,
                            start = Offset(0f, startY),
                            end = Offset(size.width, startY),
                            strokeWidth = barWidthPx
                        )
                    }
                }
            }
    )


}

@Composable
fun generateLine(
    modifier: Modifier = Modifier.fillMaxWidth(),
    lineColor: Color = Color.Green
) {
    Canvas(modifier = modifier) {
        val lineStroke = 2.dp.toPx()
        val path = Path()
        path.moveTo(0f, 0f)
        path.cubicTo(0f, 0f, 50f, 100f, 100f, 200f)
        path.cubicTo(100f, 300f, 150f, 200f, 300f, 0f)
//        path.lineTo(size.width, size.height)
        path.close()

        val filledPath = Path()
        filledPath.addPath(path)
        filledPath.lineTo(size.width, size.height)
        filledPath.lineTo(0f, size.height)
        filledPath.close()

        val gradientInside = Brush.verticalGradient(
            listOf(
                lineColor.copy(alpha = 0.4f),
                Color.Transparent
            )
        )

        drawPath(path, lineColor, style = Stroke(lineStroke))
        drawPath(filledPath, brush = gradientInside, style = Fill)
    }
}

fun generatePath(
    modifier: Modifier,
    startPosition: Offset = Offset(0f, 0f)
): Path {
    val path = Path()
    path.moveTo(startPosition.x, startPosition.y)
    // generate line here
    path.close()
    return path
}

@Preview(showBackground = true, widthDp = 360, heightDp = 360)
@Composable
fun canvasView() {
    val canvasModifier = Modifier
        .padding(8.dp)
        .aspectRatio(3 / 2f)
    graphBackground(modifier = canvasModifier)
    generateLine(modifier = canvasModifier)
}

