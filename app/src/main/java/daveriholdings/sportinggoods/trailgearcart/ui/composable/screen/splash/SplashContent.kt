package daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import daveriholdings.sportinggoods.trailgearcart.R
import daveriholdings.sportinggoods.trailgearcart.ui.theme.LocalDimens
import kotlinx.coroutines.delay

private const val INTRO_ANIMATION_DURATION_MS = 1400
private const val LOADER_CYCLE_DURATION_MS = 1100

/**
 * Пауза после схождения строки. Весь вариант держится на бегунке, а он должен
 * успеть пройти хотя бы полный цикл — иначе индикатор мелькнёт и исчезнет
 * раньше, чем прочитается как ожидание.
 */
private const val LOADER_HOLD_MS = 1100L

private val LogoSize = 64.dp
private val TrackWidth = 96.dp
private val TrackHeight = 3.dp
private val ThumbWidth = 32.dp

/** Разъезд логотипа и названия навстречу друг другу из разнесённых позиций. */
private val ConvergeDistance = 20.dp

/**
 * Строчная композиция: логотип и название сходятся навстречу друг другу в одну
 * строку, под ней бежит короткий индикатор.
 *
 * Остальные варианты складывают заставку по вертикали и заполняют центр
 * экрана; здесь весь знак занимает одну строку, а место под ним отдано
 * ожиданию. Индикатор не декоративный: переход ждёт не только конца анимации,
 * но и ответа репозитория, и бегунок честно показывает это ожидание. Он
 * бесконечный намеренно — заставка не знает, сколько осталось, а поддельная
 * шкала прогресса обещала бы знание, которого нет.
 */
@Composable
fun SplashContent(
    modifier: Modifier = Modifier,
    onAnimationFinished: () -> Unit,
) {
    val dimens = LocalDimens.current

    val intro = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        intro.animateTo(
            targetValue = 1f,
            animationSpec = tween(INTRO_ANIMATION_DURATION_MS, easing = FastOutSlowInEasing),
        )
        delay(LOADER_HOLD_MS)
        onAnimationFinished()
    }

    val loader = rememberInfiniteTransition(label = "SplashLoader")
    val thumbPosition by loader.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(LOADER_CYCLE_DURATION_MS, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "SplashLoaderThumb",
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = stringResource(R.string.toxye_app_logo_description),
                    modifier = Modifier
                        .size(LogoSize)
                        .clip(RoundedCornerShape(dimens.cornerRadius))
                        .graphicsLayer {
                            alpha = intro.value
                            translationX = -(1f - intro.value) * ConvergeDistance.toPx()
                        },
                )

                Spacer(modifier = Modifier.width(dimens.contentSpacing))

                Text(
                    text = stringResource(R.string.app_name),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.graphicsLayer {
                        alpha = intro.value
                        translationX = (1f - intro.value) * ConvergeDistance.toPx()
                    },
                )
            }

            Spacer(modifier = Modifier.height(dimens.sectionGap))

            Box(
                modifier = Modifier
                    .width(TrackWidth)
                    .height(TrackHeight)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                    .graphicsLayer { alpha = intro.value },
            ) {
                Box(
                    modifier = Modifier
                        .offset(x = (TrackWidth - ThumbWidth) * thumbPosition)
                        .width(ThumbWidth)
                        .fillMaxHeight()
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                )
            }
        }
    }
}
