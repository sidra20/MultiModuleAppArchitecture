package com.sidra.multimoduleapparch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sidra.multimoduleapparch.container.Component
import com.sidra.multimoduleapparch.databinding.ActivityMainBinding
import com.sidra.multimoduleapparch.databinding.LayoutAddBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val component = Component()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.notesRv.layoutManager=LinearLayoutManager(this)
        binding.notesRv.adapter=component.noteAdapter

        component.viewModel.allNotes.observe(this, Observer {
            component.noteAdapter.updateList(it)
        })

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }



    }
}