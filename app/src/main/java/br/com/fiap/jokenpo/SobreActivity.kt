package br.com.fiap.jokenpo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.jokenpo.databinding.ActivitySobreBinding
import com.squareup.picasso.Picasso;

class SobreActivity : AppCompatActivity{

    private lateinit var binding : ActivitySobreBinding

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivitySobreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageView : ImageView = findViewById(R.id.image_view)
        val url = "https://media.istockphoto.com/photos/childs-hands-making-sign-as-rock-paper-and-scissors-picture-id829562356?b=1&k=20&m=829562356&s=612x612&w=0&h=FHSDpqqMqQD-d_uBnebpUhVomrWjR4qdmImuGpIAgD8="

        Picasso.get().load(url).into(imageView)

        binding.btnTelaPrincipal.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}