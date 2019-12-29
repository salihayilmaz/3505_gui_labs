package gui_labs.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PostActivity<img, btnCancel, txtMsg, btnOk> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    img = (ImageView) findViewById(R.id.imageView);
    img.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivityForResult(intent, CAPTURE_IMAGE);
            }
        }
    });


    txtMsg = (EditText)findViewById(R.id.txtMessage);
    btnOk = (ImageButton) findViewById(R.id.btnOk);
    btnOk.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("msg",txtMsg.getText());
            bundle.putParcelable("bitmap",((BitmapDrawable)img.getDrawable()).getBitmap());
            intent.putExtras(bundle);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
    });
    btnCancel = (ImageButton) findViewById(R.id.btnCancel);
    btnCancel.setOnClickListener(new View.OnClickListener()

    {

        public void onClick (View view){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
    }
}
