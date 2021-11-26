package com.route.islami.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.Constants
import com.route.islami.R
import com.route.islami.Sura
import com.route.islami.ui.suraDetails.SuraDetailsActivity

class QuranFragment : Fragment() {
    val names = listOf<String>(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    );

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false);
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SuraNamesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.reycler_view);
        adapter = SuraNamesAdapter(getSurasList())

        adapter.onItemClickListener = object : SuraNamesAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, item: Sura) {
                showSuraDetails(position, item);
            }
        }
        recyclerView.adapter = adapter
    }

    private fun showSuraDetails(position: Int, sura: Sura) {
        val intent = Intent(requireContext(), SuraDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_SURA_NAME, sura.name)
        intent.putExtra(Constants.EXTRA_SURA_POS, position)
        startActivity(intent)

    }

    fun getSurasList(): List<Sura> {
        val suraList = names.map {
            return@map Sura(name = it)

        }
        return suraList;
//
//        val newList = mutableListOf<Sura>()
//        for (name in names) {
//            newList.add(Sura(name=name))
//        }
//
//        names.forEach {
//            newList.add(Sura(name=it))
//
//        }
//
    }
}