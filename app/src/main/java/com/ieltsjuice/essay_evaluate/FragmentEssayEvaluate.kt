package com.ieltsjuice.essay_evaluate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.internetconnection.NetworkChecker
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.FirebaseAIException
import com.google.firebase.ai.type.GenerativeBackend
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentEssayEvaluateBinding
import kotlinx.coroutines.launch


class FragmentEssayEvaluate : Fragment() {

    private val model = Firebase.ai(backend = GenerativeBackend.googleAI())
        .generativeModel("gemini-2.5-flash")

    lateinit var binding: FragmentEssayEvaluateBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEssayEvaluateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.buttonEssayEvaluate.setOnClickListener {
            binding.essayFeedback.text = ""
            binding.essayFeedBackTitle.visibility = View.INVISIBLE
            if (NetworkChecker(this.requireActivity()).isInternetConnected) {
                checkUserCountryCode(context!!) { countryCode ->
                    if (countryCode == "IR") {
                        Log.e("GeoCheck", "User is from $countryCode")
                        Toast.makeText(
                            context,
                            "Unfortunately, you can't use this feature from Iran.",
                            Toast.LENGTH_SHORT
                        ).show()
                        // block feature or redirect
                    } else {
                        Log.e("GeoCheck", "User is from $countryCode")
                        val topic = binding.txtTopic.editText?.text
                        val userResponse = binding.txtResponse.editText?.text
                        if (topic.isNullOrBlank() || userResponse.isNullOrBlank()) {
                            Toast.makeText(
                                this.requireActivity(),
                                "Please fill in all fields",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            binding.loadingIndicator.visibility = View.VISIBLE
                            val prompt =
                                "You are an IELTS assessor. Provide detailed feedback along an estimated IELTS score on this writing based on the task prompt. Use official IELTS band descriptors." +
                                        "task prompt is $topic" + " and writing is $userResponse"
                            Log.e("AI_ERROR", prompt)
                            lifecycleScope.launch {
                                try {
                                    val response = model.generateContent(prompt)
                                    binding.essayFeedback.text = response.text
                                    binding.loadingIndicator.visibility = View.GONE
                                    binding.essayFeedBackTitle.visibility = View.VISIBLE
                                    // use result
                                } catch (e: FirebaseAIException) {
                                    Log.e("AI_ERROR", "Generation failed: ${e.message}")
                                    // fallback or show message to user
                                }
                            }

                        }
                    }
                }
            } else {
                snackBar()
            }
        }
    }

    private fun snackBar() {
        Snackbar.make(binding.root, R.string.NoInternet, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(
                ContextCompat.getColor(
                    this.requireActivity(),
                    R.color.colorPrimary
                )
            )
            .show()
    }
}

