package uz.khasanboevboburjon.quizlet

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "QuizApp"
        setSupportActionBar(toolbar)


        mQuestionList = Constants.getQuestions()
        val optionOne: TextView = findViewById(R.id.option_one)
        val optionTwo: TextView = findViewById(R.id.option_two)
        val optionThree: TextView = findViewById(R.id.option_three)
        val optionFour: TextView = findViewById(R.id.option_four)
        val btnSubmit: AppCompatButton = findViewById(R.id.btn_submit)

        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        val btnSubmit: AppCompatButton = findViewById(R.id.btn_submit)
        val scoreCounter: TextView = findViewById(R.id.score_counter)
        val questionText: TextView = findViewById(R.id.question_id)
        val optionOne: TextView = findViewById(R.id.option_one)
        val optionTwo: TextView = findViewById(R.id.option_two)
        val optionThree: TextView = findViewById(R.id.option_three)
        val optionFour: TextView = findViewById(R.id.option_four)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)


        val question: Question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        scoreCounter.text = "$mCurrentPosition" + "/" + progressBar.max
        questionText.text = question.question
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val optionOne: TextView = findViewById(R.id.option_one)
        val optionTwo: TextView = findViewById(R.id.option_two)
        val optionThree: TextView = findViewById(R.id.option_three)
        val optionFour: TextView = findViewById(R.id.option_four)
        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)
        options.add(3, optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val btnSubmit: AppCompatButton = findViewById(R.id.btn_submit)
        val optionOne: TextView = findViewById(R.id.option_one)
        val optionTwo: TextView = findViewById(R.id.option_two)
        val optionThree: TextView = findViewById(R.id.option_three)
        val optionFour: TextView = findViewById(R.id.option_four)

        when (v?.id) {
            R.id.option_one -> {
                selectedOptionView(optionOne, selectedOptionNumber = 1)
            }
            R.id.option_two -> {
                selectedOptionView(optionTwo, selectedOptionNumber = 2)
            }
            R.id.option_three -> {
                selectedOptionView(optionThree, selectedOptionNumber = 3)
            }
            R.id.option_four -> {
                selectedOptionView(optionFour, selectedOptionNumber = 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)


                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        val optionOne: TextView = findViewById(R.id.option_one)
        val optionTwo: TextView = findViewById(R.id.option_two)
        val optionThree: TextView = findViewById(R.id.option_three)
        val optionFour: TextView = findViewById(R.id.option_four)
        when (answer) {
            1 -> {
                optionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

    private fun selectedOptionView(textV: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber
        textV.setTextColor(Color.parseColor("#363A43"))
        textV.setTypeface(textV.typeface, Typeface.BOLD)
        textV.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}