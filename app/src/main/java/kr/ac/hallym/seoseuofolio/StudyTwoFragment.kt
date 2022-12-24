package kr.ac.hallym.seoseuofolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.seoseuofolio.databinding.FragmentStudyTwoBinding


class StudyTwoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStudyTwoBinding.inflate(inflater,container,false)

        val contents1 = mutableListOf<String>(
            "2018년 1학년 1학기",
            "2018년 1학년 2학기",
            "2019년 2학년 1학기",
            "2019년 2학년 2학기",
            "2022년 3학년 1학기",)

        val contents2 = mutableListOf<String>(
            "2.31","2.5","1.88","4.32","4.3"
        )

        binding.recyclerviewScore.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewScore.adapter = SeoAdapter(contents1,contents2)
        binding.recyclerviewScore.addItemDecoration(
            DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        )

        return binding.root
    }

}