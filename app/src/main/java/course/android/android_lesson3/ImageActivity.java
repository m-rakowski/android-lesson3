package course.android.android_lesson3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Michal on 03.05.2017.
 */

public class ImageActivity extends Activity {

    private boolean blueIsBeingShown = false;
    private boolean greenIsBeingShown = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        initGoBackButton();

        initChangePictureButton();
    }

    private void initChangePictureButton() {
        Button changePictureButton = (Button) findViewById(R.id.change_picture_button);
        Button previousPictureButton = (Button) findViewById(R.id.previous_picture_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView picture = (ImageView) findViewById(R.id.imageView);
                if (blueIsBeingShown) {
                    picture.setImageResource(R.mipmap.android_green);
                    blueIsBeingShown = false;
                    greenIsBeingShown = true;
                } else if (greenIsBeingShown) {
                    picture.setImageResource(R.mipmap.android_blue);
                    blueIsBeingShown = true;
                    greenIsBeingShown = false;
                }

            }
        };

        changePictureButton.setOnClickListener(listener);
        previousPictureButton.setOnClickListener(listener);
    }


    private void initGoBackButton() {
        Button goBackButton = (Button) findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
