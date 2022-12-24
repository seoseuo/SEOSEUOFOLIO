package kr.ac.hallym.seoseuofolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.seoseuofolio.databinding.FragmentAbleBinding


class AbleFragment : Fragment() {
    lateinit var binding: FragmentAbleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAbleBinding.inflate(layoutInflater)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentAbleBinding.inflate(inflater,container,false)

        val contents1 = mutableListOf<Int>(
            R.drawable.ableone,
            R.drawable.ablesec,
            R.drawable.ablelast,
        )

        val contents2 = mutableListOf<String>("정보과학대학 축제 W.O.W","정보과학대학 체육대회","조경철 천문대 방문답사")
        val contents3 = mutableListOf<String>("22년도 여름 정보과학대학 학생회에서 주최한 W.O.W (워터밤) 축제를 진행하여 전교의 많은 학우들에게 즐거움을 선사하였습니다.",
            "체육부장으로서 정보과학대학 체육대회를 주최, 기획, 진행하였고 정과대 내의 다양한 운동 동아리와 학과들이 서로 스포츠 실력을 겨루며 준수한 성과를 내었습니다.",
            "A:BLE의 많은 행사, 사업들 중 마지막 행사였으며, 정과대 내의 학우들과 함께 조경철 천문대를 방문해 천체 망원경으로 달을 비롯한 태양계 행성들을 관측하며, 휴대폰 카메라로 별들을 찍으며 색다른 경험을 만들었습니다."
        )

        binding.recyclerviewAble.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewAble.adapter = AbleAdapter(contents1,contents2,contents3)
        binding.recyclerviewAble.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        )

        // Inflate the layout for this fragment
        return binding.root
    }
}




