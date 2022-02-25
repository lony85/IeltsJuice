package com.ieltsjuice.placement_test

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentPlacementResultBinding

class FragmentPlacementResult:Fragment() {
    lateinit var binding : FragmentPlacementResultBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlacementResultBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments


        when (bundle?.getInt(KEY_testResult)) {
            in 0..18 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleA1)
                binding.icResultA1.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleA1)
                binding.txtDescription.text = getString(R.string.txtDescriptionA1)
            }
            in 19..36 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleA2)
                binding.icResultA2.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleA2)
                binding.txtDescription.text = getString(R.string.txtDescriptionA2)
            }
            in 37..54 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleB1)
                binding.icResultB1.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleB1)
                binding.txtDescription.text = getString(R.string.txtDescriptionB1)
            }
            in 55..72 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleB2)
                binding.icResultB2.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleB2)
                binding.txtDescription.text = getString(R.string.txtDescriptionB2)
            }
            in 73..90 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleC1)
                binding.icResultC1.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleC1)
                binding.txtDescription.text = getString(R.string.txtDescriptionC1)
            }
            in 91..108 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleC2)
                binding.icResultC1.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleC2)
                binding.txtDescription.text = getString(R.string.txtDescriptionC2)
            }
        }
    }
}