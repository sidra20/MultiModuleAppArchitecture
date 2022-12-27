package com.sidra.multimoduleapparch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sidra.multimoduleapparch.container.Component
import com.sidra.multimoduleapparch.databinding.ActivityMainBinding
import com.sidra.multimoduleapparch.databinding.LayoutPostsBinding

class PostsActivity : AppCompatActivity() {
    private lateinit var binding: LayoutPostsBinding
    val component = Component()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=LayoutPostsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.postsRv.layoutManager= LinearLayoutManager(this)
        binding.postsRv.adapter=component.postAdapter

        component.viewModel.getPosts.observe(this, Observer {
         component.postAdapter.updateList(it)
        })

        component.viewModel.msgLv.observe(this, Observer {
            it?.let {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()

            }

        })
    }
}