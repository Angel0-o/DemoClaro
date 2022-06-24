package com.moragar.democlaro.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.moragar.democlaro.R
import com.moragar.democlaro.databinding.FragmentDemoListBinding
import com.moragar.democlaro.model.data.Demo
import com.moragar.democlaro.view.adapter.DemoAdapter
import com.moragar.democlaro.viewmodel.DemoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoListFragment : Fragment(),DemoAdapter.OnDemoListener {
    private lateinit var binding: FragmentDemoListBinding
    private lateinit var adapter: DemoAdapter
    private val demoViewModel:DemoListViewModel by viewModels()
    private val demoList:MutableList<Demo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDemoListBinding.bind(view)
        adapter = DemoAdapter(demoList)
        adapter.setDemoListener(this)
        binding.rvDemo.adapter = adapter
        initViewModels()
    }

    private fun initViewModels() {
        demoViewModel.getDemoList()
        demoViewModel.demoLiveData.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                demoList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun OnDemoClickListener(position: Int) {
        binding.title.text = demoList[position].title
    }

    override fun OnDemoLongClickListener(position: Int) {
        val alert = AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.dialog_delete_title))
            .setPositiveButton(getString(R.string.dialog_msg_accept), DialogInterface.OnClickListener { dialog, which ->
                demoList.removeAt(position)
                adapter.notifyDataSetChanged()
                Toast.makeText(requireContext(),getString(R.string.dialog_msg_delete_success), Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton(getString(R.string.dialog_msg_cancel), DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            .create().show()
    }
}