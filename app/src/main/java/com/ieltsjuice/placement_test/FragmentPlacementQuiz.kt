package com.ieltsjuice.placement_test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.WithoutBottomNavigationBarActivity
import com.ieltsjuice.databinding.FragmentPlacementQuizBinding
import com.ieltsjuice.util.PAGE_NAME_KEY

class FragmentPlacementQuiz : Fragment() {
    lateinit var binding: FragmentPlacementQuizBinding
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlacementQuizBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStartPlacementTest.setOnClickListener {
            val intent = Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY,"placementQuestions")
            startActivity(intent)
        }
    }
}
