package com.udacity.gradle.jokeplatformapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import gradle.udacity.com.jokeplatformviewlib.JokeActivity;

public class InterstitialActivity extends Activity {
    PublisherInterstitialAd mPublisherInterstitialAd;
    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        joke = getIntent().getExtras().getString(JokeActivity.JOKE_STRING);
        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        mPublisherInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mPublisherInterstitialAd.show();
            }

            @Override
            public void onAdClosed() {
                Intent intent = new Intent(InterstitialActivity.this, JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_STRING, joke);
                startActivity(intent);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }
        });
        requestNewInterstitial();
        if (mPublisherInterstitialAd.isLoaded()) {
                    mPublisherInterstitialAd.show();
        }
    }

    private void requestNewInterstitial() {
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mPublisherInterstitialAd.loadAd(adRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPublisherInterstitialAd.isLoaded()) {
            mPublisherInterstitialAd.show();
        }
        else {
            onBackPressed();
        }
    }

}
