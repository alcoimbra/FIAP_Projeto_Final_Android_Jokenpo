package br.com.fiap.jokenpo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity{

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJogar.setOnClickListener{
            startActivity(Intent(this, JogarActivity::class.java))
            finish()
        }

        binding.btnSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
            finish()
        }

        binding.btnSair.setOnClickListener {
            val itnent = Intent(Intent.ACTION_MAIN)

            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            startActivity(intent)
        }
    }
}