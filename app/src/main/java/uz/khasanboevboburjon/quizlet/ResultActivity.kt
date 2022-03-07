package uz.khasanboevboburjon.quizlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val name = findViewById<TextView>(R.id.name_tv)
        val userName = intent.getStringExtra(Constants.USER_NAME)
        name.text = userName
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        val score = findViewById<TextView>(R.id.score_tv)
        score.text = "Your score is $correctAnswers out of $totalQuestion."

        val  finish = findViewById<AppCompatButton>(R.id.btn_finish)

        finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}