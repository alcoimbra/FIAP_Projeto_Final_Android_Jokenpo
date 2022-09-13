package br.com.fiap.jokenpo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.jokenpo.databinding.ActivityJogarBinding
import java.util.*

class JogarActivity : AppCompatActivity{

    private lateinit var binding : ActivityJogarBinding

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityJogarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textResultado.setText("Escolha uma Opção Abaixo: ")
        binding.txtPlacarUsuario.text = "0"
        binding.txtPlacarCPU.text = "0"

        binding.imagePedra.setOnClickListener {
            this.opcaoSelecionada("Pedra")
        }

        binding.imagePapel.setOnClickListener {
            this.opcaoSelecionada("Papel")
        }

        binding.imageTesoura.setOnClickListener {
            this.opcaoSelecionada("Tesoura")
        }
    }

    fun opcaoSelecionada(escolhaUsuario : String) {
        binding.textResultado.setText("Escolha uma Opção Abaixo: ")

        var contPlacarUsuario = Integer.valueOf(binding.txtPlacarUsuario.text.toString())
        var contPlacarCPU = Integer.valueOf(binding.txtPlacarCPU.text.toString())
        val jogadas = arrayOf("Pedra", "Papel", "Tesoura")
        val escolhaApp = jogadas[Random().nextInt(3)]

        when(escolhaApp) {
            "Pedra" -> binding.imageEscolhaCPU.setImageResource(R.drawable.rock)
            "Papel" -> binding.imageEscolhaCPU.setImageResource(R.drawable.paper)
            "Tesoura" -> binding.imageEscolhaCPU.setImageResource(R.drawable.scissor)
        }

        when(escolhaUsuario){
            "Pedra" -> binding.imageEscolhaJogador.setImageResource(R.drawable.rock)
            "Papel" -> binding.imageEscolhaJogador.setImageResource(R.drawable.paper)
            "Tesoura" -> binding.imageEscolhaJogador.setImageResource(R.drawable.scissor)
        }

        if (escolhaUsuario == "Papel" && escolhaApp == "Pedra" ||
            escolhaUsuario == "Pedra" && escolhaApp == "Tesoura" ||
            escolhaUsuario == "Tesoura" && escolhaApp == "Papel") {
            contPlacarUsuario  += 2
            binding.txtPlacarUsuario.text = contPlacarUsuario.toString()
            binding.textResultado.text = "Parabéns, vitória sua!"
        } else if (escolhaApp == escolhaUsuario) { // EMPATE
            binding.textResultado.text = "Empate!"
            contPlacarUsuario += 1
            binding.txtPlacarUsuario.text = contPlacarUsuario.toString()

            contPlacarCPU += 1
            binding.txtPlacarCPU.text = contPlacarCPU.toString()
        } else { // VITORIA DO APP
            contPlacarCPU  += 2
            binding.txtPlacarCPU.text = contPlacarCPU.toString()
            binding.textResultado.text = "Você perdeu!"

            var proximaTela = Intent(this, JogoFimActivity::class.java)
            proximaTela.putExtra("contPlacarUsuario",contPlacarUsuario)
            proximaTela.putExtra("contPlacarCPU",contPlacarCPU)
            startActivity(proximaTela)
            finish()
        }
    }
}