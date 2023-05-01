package com.codingwithze.networkingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.codingwithze.networkingretrofit.databinding.ActivityUpdateNewsBinding
import com.codingwithze.networkingretrofit.model.DataNews
import com.codingwithze.networkingretrofit.viewmodel.NewsViewModel

class UpdateNewsActivity : AppCompatActivity() {

    lateinit var binding : ActivityUpdateNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener {
            var id = intent.getStringExtra("update")
            var title = binding.updTitle.text.toString()
            var author = binding.updAuthor.text.toString()
            var img = binding.updImage.text.toString()
            var desc = binding.updDescription.text.toString()
            updateDataNews(id!!.toInt(),title,img,author, desc)

        }
    }

    fun updateDataNews(id : Int, title : String, image: String, author : String, desc : String){
        var viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.callUpdDataNews(id, title, image, author, desc)
        viewModel.putNews().observe(this,{
            if (it != null){
                //message
            }
        })
    }
}