package kr.ac.hallym.seoseuofolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.seoseuofolio.databinding.FragmentDefyBinding


class DefyFragment : Fragment() {
    lateinit var binding: FragmentDefyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDefyBinding.inflate(layoutInflater)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDefyBinding.inflate(inflater,container,false)

        val contents1 = mutableListOf<Int>(
            R.drawable.defyone,
            R.drawable.defytwo,
            R.drawable.defythree,
        )

        val contents2 = mutableListOf<String>("누구나 즐길 수 있는 동아리","인트라뮤랄 조별리그 1위","정보과학대학 체육대회 우승")
        val contents3 = mutableListOf<String>("디파이는 축구를 좋아하는 학우라면 누구든지 가입하여 함께 운동 할 수 있는 훌륭한 동아리입니다.",
            "디파이는 인트라뮤랄리그 조별리그에서 한 경기도 패배하지 않고 메이저리그에 진출하였습니다. 이것은 동아리 첫 기록입니다.",
            "정보과학대학 체육대회 축구부문 11대 11 풀코트 부분에서 디파이는 상대편을 꺾어 체육대회 우승을 차지하였습니다.."
        )

        binding.recyclerviewDefy.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewDefy.adapter = AbleAdapter(contents1,contents2,contents3)
        binding.recyclerviewDefy.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        )

        // Inflate the layout for this fragment
        return binding.root
    }
}




