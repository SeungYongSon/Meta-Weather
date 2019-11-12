package com.meta.weather.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class DataBindingFragment<T: ViewDataBinding> : Fragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    lateinit var rootView: View
    lateinit var binding: T

    abstract val layoutId: Int

    abstract val viewModel: BaseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        rootView = binding.root

        return rootView
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>
            = fragmentInjector
}