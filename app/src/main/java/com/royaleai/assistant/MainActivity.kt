
package com.royaleai.assistant

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    private lateinit var chatLayout: LinearLayout
    private lateinit var input: EditText

    private val white = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(18, 18, 18, 18)
        root.setBackgroundColor(Color.rgb(15, 20, 35))

        val title = TextView(this)
        title.text = "ROYale AI"
        title.textSize = 28f
        title.setTextColor(Color.rgb(255, 190, 50))
        title.gravity = Gravity.CENTER
        root.addView(title)

        val subtitle = TextView(this)
        subtitle.text = "مربی حرفه‌ای Ranked کلش رویال"
        subtitle.textSize = 16f
        subtitle.setTextColor(white)
        subtitle.gravity = Gravity.CENTER
        root.addView(subtitle)

        val scroll = ScrollView(this)
        chatLayout = LinearLayout(this)
        chatLayout.orientation = LinearLayout.VERTICAL
        chatLayout.setPadding(8, 20, 8, 20)

        scroll.addView(chatLayout)

        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        input = EditText(this)
        input.hint = "سؤالت درباره بازی رو بنویس..."
        input.setTextColor(white)
        input.setHintTextColor(Color.LTGRAY)
        input.setSingleLine(true)

        val bottom = LinearLayout(this)
        bottom.orientation = LinearLayout.HORIZONTAL

        bottom.addView(
            input,
            LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
        )

        val send = Button(this)
        send.text = "ارسال"
        bottom.addView(send)

        send.setOnClickListener {
            val message = input.text.toString().trim()

            if (message.isNotEmpty()) {
                addMessage("شما: $message")
                addMessage(
                    "RoyaleAI: پیام دریافت شد! برای تحلیل حرفه‌ای دک، حریف و تصمیم‌های Ranked، اتصال هوش مصنوعی واقعی در مرحله بعد فعال می‌شود."
                )
                input.text.clear()
            }
        }

        root.addView(bottom)
        setContentView(root)

        addMessage(
            "سلام قهرمان! من RoyaleAI هستم، مربی رقابتی کلش رویال."
        )
        addMessage(
            "هدف من کمک به بردن مسابقات Ranked است؛ نه آموزش چیزهایی که خودت بلدی!"
        )
        addMessage(
            "به‌زودی تحلیل دک، بررسی حریف و پیشنهاد تاکتیک‌های حرفه‌ای رو بهت ارائه می‌دم."
        )
    }

    private fun addMessage(message: String) {
        val text = TextView(this)
        text.text = message
        text.textSize = 16f
        text.setTextColor(white)
        text.setPadding(14, 14, 14, 14)

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 8, 0, 8)

        chatLayout.addView(text, params)
    }
}
