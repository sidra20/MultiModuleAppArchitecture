package com.sidra.multimoduleapparch

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.sidra.multimoduleapparch.container.Component
import com.sidra.multimoduleapparch.databinding.LayoutAddBinding
import com.sidra.multimoduleapparch.viewmodel.AppViewModel
import com.sidra.service.Service.ServiceRepo
import org.koin.android.ext.android.inject

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: LayoutAddBinding
    val component = Component()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.layout_add)
        binding.viewModel=component.viewModel
        binding.lifecycleOwner=this
        binding.home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        component.viewModel.msgLv.observe(this, Observer {
            it?.let {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()

            }

        })

    }
}