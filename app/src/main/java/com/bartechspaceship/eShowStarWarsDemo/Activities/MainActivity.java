package com.bartechspaceship.eShowStarWarsDemo.Activities;

import a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.containter);
        setupViewPager(mViewPager);

    }.setAdapter(adapter);
    }


    public voiagmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }



}

