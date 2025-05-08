package com.yuki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yuki.gecis.R
import com.yuki.gecis.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    private var _binding: FragmentAnasayfaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGitA.setOnClickListener {
            findNavController().navigate(R.id.action_anasayfa_to_sayfaA)
        }

        binding.buttonGitX.setOnClickListener {
            findNavController().navigate(R.id.action_anasayfa_to_sayfaX)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
