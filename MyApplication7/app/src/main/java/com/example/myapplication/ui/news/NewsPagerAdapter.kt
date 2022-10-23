package com.example.myapplication.ui.news

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class NewsPagerAdapter(private val fm:FragmentManager):FragmentPagerAdapter(fm) {

    private var arrayList = ArrayList<String>()
    private var fragments  =ArrayList<Fragment>()

    fun setTitle(arrayList: ArrayList<String>){
        this.arrayList = arrayList
    }
    fun setData(fragments: ArrayList<Fragment>) {
        this.fragments = fragments
    }


    override fun getCount(): Int  = arrayList.size

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getPageTitle(position: Int): CharSequence? {
        return arrayList[position]
    }
}