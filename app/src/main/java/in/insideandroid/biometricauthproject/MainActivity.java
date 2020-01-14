package in.insideandroid.biometricauthproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button button_authenticate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_authenticate = findViewById(R.id.button);
        button_authenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //perform biometric check
                new BiometricCheck(MainActivity.this, listener);
            }
        });
    }

    BiometricListener listener = new BiometricListener() {
        @Override
        public void onSuccess() {
            Toast.makeText(MainActivity.this, "User authentication successful",Toast.LENGTH_LONG).show();

            //turn button text green
            button_authenticate.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        }

        @Override
        public void onFailed() {

            //turn button text red
            button_authenticate.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    };
}
