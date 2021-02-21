package com.hugl.peekme.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.hugl.peekme.R
import com.hugl.peekme.databinding.ActivityMainBinding
import com.hugl.peekme.ui.base.BaseActivity
import com.hugl.peekme.utils.ViewModelFactory
import com.hugl.peekme.utils.observe
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityMainBinding

    override fun initializeViewModel() {
        viewModel = viewModelFactory.create(viewModel::class.java)
    }

    override fun observeViewModel() {
        observe(viewModel.recipeData, ::writeText)

    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initIntentData()

    }

    private fun writeText(str:String) {
        binding.text.text=str

    }
}