package com.example.priyamaurya.pocofscreen.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.priyamaurya.pocofscreen.Activity.CardActivity;
import com.example.priyamaurya.pocofscreen.Activity.MainActivity;
import com.example.priyamaurya.pocofscreen.Adpater.CardRecyclerViewAdpater;
import com.example.priyamaurya.pocofscreen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Priya Maurya on 1/6/2018.
 */

public class CardDialogFragment extends DialogFragment {

    private View view;

    private RecyclerView recyclerView;

    private Dialog dialog;

    private ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.dialog_fragmentcard,container,false);
        viewPager=view.findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),MainActivity.class);
                startActivity(i);
            }
        });

        return view;

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR);



       /* SnapHelper snapHelper=new PagerSnapHelper();
        recyclerView=dialog.findViewById(R.id.recycler_view);

        snapHelper.attachToRecyclerView(recyclerView);
        RecyclerView.LayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        CardRecyclerViewAdpater cardRecyclerViewAdpater=new CardRecyclerViewAdpater();

        recyclerView.setAdapter(cardRecyclerViewAdpater);
*/
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);




        return dialog;
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<CardPagerFragment> cardPagerFragments;

        CardPagerFragment cardPagerFragment;

        public void addFragments(CardPagerFragment cardPagerFragment){
            cardPagerFragments.add(cardPagerFragment);
        }


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);


            cardPagerFragments=new ArrayList<>();

           // cardPagerFragment=new CardPagerFragment();
            for (int i=0;i<5;i++){
                addFragments(new CardPagerFragment());
            }

        }

        @Override
        public Fragment getItem(int position) {


            return cardPagerFragments.get(position);
        }

        @Override
        public int getCount() {
            return cardPagerFragments.size();
        }
    }



}
