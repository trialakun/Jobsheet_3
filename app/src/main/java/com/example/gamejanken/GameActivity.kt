package com.example.gamejanken

import android.os.Bundle
import android.widget.ImageView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private lateinit var computerImageView: ImageView
    private lateinit var rockImageView: ImageButton
    private lateinit var scissorsImageView: ImageButton
    private lateinit var paperImageView: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents(){
        computerImageView = findViewById(R.id.computerImageView)
        rockImageView = findViewById(R.id.rockImageButton)
        scissorsImageView = findViewById(R.id.scissorsImageButton)
        paperImageView = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListeners(){
        rockImageView.setOnClickListener{ startGame("ROCK")}
        scissorsImageView.setOnClickListener{ startGame("SCISSORS")}
        paperImageView.setOnClickListener{ startGame("PAPER")}
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when{
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.tryagain)
            Game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.winner)
            else -> resultImageView.setImageResource(R.drawable.gameover)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListeners()
    }
}