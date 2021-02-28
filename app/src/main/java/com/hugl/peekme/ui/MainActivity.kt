package com.hugl.peekme.ui

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hugl.peekme.databinding.ActivityMainBinding
import com.hugl.peekme.domain.Heroes
import com.hugl.peekme.remote.Resource
import com.hugl.peekme.ui.base.BaseActivity
import com.hugl.peekme.utils.ViewModelFactory
import com.hugl.peekme.utils.observe
import timber.log.Timber
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityMainBinding

    private lateinit var heroesAdapter: HeroesAdapter


    override fun initializeViewModel() {
        viewModel = viewModelFactory.create(viewModel::class.java)
    }

    override fun observeViewModel() {
        observe(viewModel.heroesLiveData,::showHeroes)
    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initIntentData()
        val layoutManager = GridLayoutManager(this,9 )
        binding.heroesList.layoutManager = layoutManager
        binding.heroesList.setHasFixedSize(true)
    }

    private fun showHeroes(content: Resource<Heroes>) {
        when (content) {
            is Resource.Success -> content.data?.let { bindListData(heroes = it) }

        }
    }

    private fun bindListData(heroes: Heroes) {
        if (!(heroes.heroesList.isNullOrEmpty())) {
            heroesAdapter = HeroesAdapter(heroes.heroesList)
            binding.heroesList.adapter=heroesAdapter

        } else {
        }
    }
}