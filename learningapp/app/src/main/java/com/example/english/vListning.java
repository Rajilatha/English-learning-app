package com.example.english;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class vListning extends AppCompatActivity {

    MediaPlayer player;
    MediaPlayer xxx;
    MediaPlayer a;
    MediaPlayer b;
    MediaPlayer c;
    MediaPlayer d;
    MediaPlayer e;
    MediaPlayer f;
    MediaPlayer g;
    MediaPlayer h;
    MediaPlayer i;
    MediaPlayer j;
    MediaPlayer k;
    MediaPlayer l;
    MediaPlayer m;
    MediaPlayer n;
    MediaPlayer o;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_listning);
    }
    public void play2(View v) {
        if (a == null) {
            a = MediaPlayer.create(this, R.raw.versatileuk);

        }
        a.start();
    }
    public void us(View v) {
        if (xxx == null) {
            xxx = MediaPlayer.create(this, R.raw.agileus);

        }
        xxx.start();
    }
    public void play(View v) {
        if (b == null) {
            b = MediaPlayer.create(this, R.raw.agileuk);

        }
        b.start();
    }


    public void play3(View v) {
        if (c == null) {
            c = MediaPlayer.create(this, R.raw.versertileus);

        }
        c.start();
    }
    public void play4(View v) {
        if (d == null) {
            d = MediaPlayer.create(this, R.raw.fertileuk);

        }
        d.start();
    }
    public void play5(View v) {
        if (e== null) {
            e = MediaPlayer.create(this, R.raw.fertileus);

        }
        e.start();
    }
    public void play6(View v) {
        if (f == null) {
            f = MediaPlayer.create(this, R.raw.hostileuk);

        }
        f.start();
    }

    public void play8(View v) {
        if (g == null) {
        g = MediaPlayer.create(this, R.raw.hostileus);

        }
        g.start();
    }
    public void play9(View v) {
        if (h == null) {
            h= MediaPlayer.create(this, R.raw.mobileuk);

        }
        h.start();
    }
    public void play10(View v) {
        if (i == null) {
            i = MediaPlayer.create(this, R.raw.mobileus);

        }
        i.start();
    }
    public void play11(View v) {
        if (j == null) {
            j = MediaPlayer.create(this, R.raw.civilizationuk);

        }
        j.start();
    }
    public void play12(View v) {
        if (k== null) {
            k = MediaPlayer.create(this, R.raw.civilizationus);

        }
        k.start();
    }
    public void play13(View v) {
        if (l == null) {
            l = MediaPlayer.create(this, R.raw.organisationuk);

        }
        l.start();
    }
    public void play14(View v) {
        if( m == null) {
            m = MediaPlayer.create(this, R.raw.organisationus);

        }
        m.start();
    }
    public void play15(View v) {
        if (n == null) {
            n = MediaPlayer.create(this, R.raw.authorizationuk);

        }
        n.start();
    }
    public void play16(View v) {
        if (o == null) {
            o = MediaPlayer.create(this, R.raw.authorizationus);

        }
        o.start();
    }
}
