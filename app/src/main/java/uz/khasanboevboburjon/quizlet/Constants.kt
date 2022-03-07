package uz.khasanboevboburjon.quizlet

object Constants{

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS:String = "correct_answer"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
         val question1 = Question(1,
             "\"Arrive\" to'g'ri tarjimani toping.",
             "Maqola",
             "Yetib kelmoq",
             "Bekor qilmoq",
             "Musobaqa",
             2)

        questionList.add(question1)

        val question2 = Question(2,
            "\"Article\" to'g'ri tarjimani toping.",
            "Maqola",
            "Yetib kelmoq",
            "Bekor qilmoq",
            "Musobaqa",
            1)

        questionList.add(question2)

        val question3 = Question(3,
            "\"Cancel\" to'g'ri tarjimani toping.",
            "Maqola",
            "Yetib kelmoq",
            "Bekor qilmoq",
            "Musobaqa",
            3)

        questionList.add(question3)

        val question4 = Question(4,
            "\"Competition\" to'g'ri tarjimani toping.",
            "Maqola",
            "Yetib kelmoq",
            "Bekor qilmoq",
            "Musobaqa",
            4)

        questionList.add(question4)

        val question5 = Question(5,
            "\"Explain\" to'g'ri tarjimani toping.",
            "Ro'y bermoq, yuz bermoq",
            "Qanchalik tez-tez",
            "Tushintirmoq",
            "Taklif qilmoq",
            3)

        questionList.add(question5)

        val question6 = Question(6,
            "\"Invite\" to'g'ri tarjimani toping.",
            "Ro'y bermoq, yuz bermoq",
            "Qanchalik tez-tez",
            "Tushintirmoq",
            "Taklif qilmoq",
            4)

        questionList.add(question4)

        val question7 = Question(7,
            "\"How often\" to'g'ri tarjimani toping.",
            "Ro'y bermoq, yuz bermoq",
            "Qanchalik tez-tez",
            "Tushintirmoq",
            "Taklif qilmoq",
            2)

        questionList.add(question7)

        val question8 = Question(8,
            "\"Happen\" to'g'ri tarjimani toping.",
            "Ro'y bermoq, yuz bermoq",
            "Qanchalik tez-tez",
            "Tushintirmoq",
            "Taklif qilmoq",
            1)

        questionList.add(question8)

        val question9 = Question(9,
            "\"Last\" to'g'ri tarjimani toping.",
            "Davom etmoq",
            "Qanchalik tez-tez",
            "Uchlashuv",
            "Sotmoq",
            1)

        questionList.add(question9)

        val question10 = Question(10,
            "\"Mean\" to'g'ri tarjimani toping.",
            "Bo'sh",
            "Kumush",
            "Bekor qilmoq",
            "Ma'no bildirmoq",
            4)

        questionList.add(question10)
        return questionList
    }
}