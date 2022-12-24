package kr.ac.hallym.seoseuofolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.seoseuofolio.databinding.FragmentGrimBinding


class GrimFragment : Fragment() {
    lateinit var binding: FragmentGrimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentGrimBinding.inflate(layoutInflater)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentGrimBinding.inflate(inflater,container,false)

        val contents1 = mutableListOf<Int>(
            R.drawable.grimone,
            R.drawable.grimtww,
            R.drawable.grimthree,
            R.drawable.grimtwo,
        )

        val contents2 = mutableListOf<String>("대동제 무대팀원 서승권","대학축제의 꽃 연예인 공연","무대설치와 리허설","무대 뒷 편 숨겨진 장면")
        val contents3 = mutableListOf<String>("코로나로 인해 침체되었던 한림대학교 대동제가 2년만에 개막을 다시 알렸습니다. 저는 축제준비위원회에서 무대팀 STAFF를 지원하여 축제를 진행하였습니다.",
            "대학교 축제의 꽃 연예인 공연에서 10cm가 무대 전방으로 달려들어 관객들과의 소통을 하는 모습을 안전통제를 하던 중 찍었습니다. 정말 즐겁고 멋있는 공연이었고, 그날 제가 본 장면은 잊을 수 없을 것 같습니다.",
            "축제를 진행하기에 앞서 무대 프로그램들을 리허설하고 동선을 파악하고 설치 물품들을 미리 설치하고 파악하여 원활한 진행과 안전에는 이상이 없는지 확인하고 회의를 통해 피드백하며 팀원간 열심히 최선을 다했습니다.",
            "큰 음악소리와 노랫소리, 관객들의 함성소리가 들려오는 무대의 뒷편에서는 스태프들이 식사 때 가 4,5시간은 지나 차가워진 도시락을 간간히 짬내여 먹는 모습도 연출됩니다. 바쁘고 정신이 없기에 배고픈줄도 모르는 바보가 됩니다."
        )

        binding.recyclerviewGrim.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewGrim.adapter = AbleAdapter(contents1,contents2,contents3)
        binding.recyclerviewGrim.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        )

        // Inflate the layout for this fragment
        return binding.root
    }
}




