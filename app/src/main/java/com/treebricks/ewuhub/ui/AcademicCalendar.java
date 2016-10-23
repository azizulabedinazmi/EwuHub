package com.treebricks.ewuhub.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.github.clans.fab.FloatingActionMenu;
import com.treebricks.ewuhub.R;
import com.treebricks.ewuhub.view.CalendarEvent;
import com.treebricks.ewuhub.view.CalendarExpandableAdapter;
import com.treebricks.ewuhub.view.CalendarParent;

import java.util.ArrayList;
import java.util.List;

public class AcademicCalendar extends AppCompatActivity {
    ActionBar actionBar;

    CalendarExpandableAdapter calendarExpandableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String undergraduate = "file://" + getBaseContext().getApplicationInfo().dataDir+"/html/undergraduate.html";
        final String undergraduatePharmacy = "file://" + getBaseContext().getApplicationInfo().dataDir+"/html/pharmacyundergraduate.html";
        final String graduate = "file://" + getBaseContext().getApplicationInfo().dataDir+"/html/graduate.html";
        final String graduatePharmacy = "file://" + getBaseContext().getApplicationInfo().dataDir+"/html/pharmacygraduate.html";
/*
        final ObservableWebView calendarWebView = (ObservableWebView) findViewById(R.id.calendar_web_view);
        if (calendarWebView != null) {
            calendarWebView.setWebViewClient(new WebViewClient());
            calendarWebView.loadUrl(undergraduate);
        }


        // Fab menu
        final FloatingActionMenu fabmenu = (FloatingActionMenu) findViewById(R.id.calendar_fab_menu);

        if (calendarWebView != null) {
            calendarWebView.setOnScrollChangeListener(new ObservableWebView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(WebView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if(oldScrollY < scrollY)
                    {
                        if (fabmenu != null) {
                            fabmenu.hideMenu(true);
                        }
                    }
                    else
                    {
                        if (fabmenu != null) {
                            fabmenu.showMenu(true);
                        }
                    }
                }
            });
        }

        final com.github.clans.fab.FloatingActionButton undergraduateFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.undergraduate);
        if (undergraduateFab != null) {
            undergraduateFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if (fabmenu != null) {
                        fabmenu.close(true);
                    }
                    if (calendarWebView != null) {
                        calendarWebView.loadUrl(undergraduate);
                    }
                }
            });
        }

        final com.github.clans.fab.FloatingActionButton pharmacyUndergraduateFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.pharmacyundergraduate);
        if (pharmacyUndergraduateFab != null) {
            pharmacyUndergraduateFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if (fabmenu != null) {
                        fabmenu.close(true);
                    }
                    if (calendarWebView != null) {
                        calendarWebView.loadUrl(undergraduatePharmacy);
                    }
                }
            });
        }

        final com.github.clans.fab.FloatingActionButton GraduateFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.graduate);
        if (GraduateFab != null) {
            GraduateFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if (fabmenu != null) {
                        fabmenu.close(true);
                    }
                    if (calendarWebView != null) {
                        calendarWebView.loadUrl(graduate);
                    }
                }
            });
        }

        final com.github.clans.fab.FloatingActionButton pharmacyGraduateFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.pharmacygraduate);
        if (pharmacyGraduateFab != null) {
            pharmacyGraduateFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if (fabmenu != null) {
                        fabmenu.close(true);
                    }
                    if (calendarWebView != null) {
                        calendarWebView.loadUrl(graduatePharmacy);
                    }
                }
            });
        }*/
        ArrayList<CalendarParent> allParents = new ArrayList<>();

        for(int i = 0; i < 10; i++)
        {
            ArrayList<CalendarEvent> anEvent = new ArrayList<>();
            anEvent.add(new CalendarEvent("This is calendar event : " + String.valueOf(i+1)));
            CalendarParent cp = new CalendarParent();
            cp.setEventDate(String.valueOf(i+1)+"/" + String.valueOf(i+1)+"/" + String.valueOf(i+1));
            cp.setEventDay("Day " + String.valueOf(i+1));
            cp.setChildList(anEvent);
            allParents.add(cp);
        }
        RecyclerView expanRecycler = (RecyclerView) findViewById(R.id.calendat_recyclerView);

        calendarExpandableAdapter = new CalendarExpandableAdapter(this, allParents);


        expanRecycler.setAdapter(calendarExpandableAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        expanRecycler.setLayoutManager(linearLayoutManager);






        actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }



}
