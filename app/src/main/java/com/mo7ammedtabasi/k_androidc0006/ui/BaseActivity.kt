package com.mo7ammedtabasi.k_androidc0006.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB:ViewBinding> : AppCompatActivity() {

    abstract val LOG_TAG : String
    abstract val bindingInflater: (LayoutInflater) -> VB
    private var _binding : ViewBinding? = null
    protected val binding: VB?
        get() = _binding as VB?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
        addCallBack()
    }
//    private var _binding: ViewBinding? = null
//    abstract val bindingInflater: (LayoutInflater) -> VB
//    @Suppress("UNCHECKED_CAST")
//    protected val binding: VB
//        get() = _binding as VB
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        _binding = bindingInflater.invoke(layoutInflater)
//        setContentView(requireNotNull(_binding).root)
//        setup()
//        addCallBack()
//    }

    abstract fun setup()
    abstract fun addCallBack()
    protected fun log(value : Any){
        Log.d(LOG_TAG,value.toString())
    }
}
