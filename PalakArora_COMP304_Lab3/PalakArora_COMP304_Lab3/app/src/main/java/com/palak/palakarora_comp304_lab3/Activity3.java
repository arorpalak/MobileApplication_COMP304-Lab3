package com.palak.palakarora_comp304_lab3;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    ImageView reusableImageViewEarth = null;
    ImageView reusableImageViewSun = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        final Button onButton = (Button) findViewById(R.id.ButtonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        final Button offButton = (Button) findViewById(R.id.ButtonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation() {
        reusableImageViewSun = performAnimation(R.anim.spin, R.drawable.sun, R.id.ImageViewForSun);
        reusableImageViewEarth = performAnimation(R.anim.roundanimation, R.drawable.earth, R.id.ImageViewForEarth);
        //reusableImageViewEarth = performAnimation(R.anim.halfround2animation, R.drawable.earth, R.id.ImageViewForEarth);
    }

    private void stopAnimation() {
        reusableImageViewEarth.setAnimation(null);
        reusableImageViewEarth.setVisibility(View.INVISIBLE);
        reusableImageViewSun.setAnimation(null);
        reusableImageViewSun.setVisibility(View.INVISIBLE);
    }


    private ImageView performAnimation(int animationResourceID, int img, int imageView) {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView) findViewById(imageView);
        reusableImageView.setImageResource(img);
        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an = AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);

        return reusableImageView;
    }

    class MyAnimationListener implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            ImageView reusableImageView = (ImageView) findViewById(R.id.ImageViewForEarth);
            reusableImageView.setVisibility(View.INVISIBLE);
        }

        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }

        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running
        }

    }
}
