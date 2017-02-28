package sda.sendemailgmail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText et_to;
    private EditText et_sub;
    private EditText et_text;
    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_to = (EditText) findViewById(R.id.editTextTo);
        et_sub = (EditText) findViewById(R.id.editTextSub);
        et_text = (EditText) findViewById(R.id.editTextMes);
        btn = (Button) findViewById(R.id.button_send);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                composeEmail(et_to.getText().toString(), et_sub.getText().toString(), et_text.getText().toString());
                Toast.makeText(MainActivity.this, "działa ?", Toast.LENGTH_SHORT).show();

            }
        });
    }
        public void composeEmail(String to, String subject , String body   ){
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String [] {to});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            if (intent.resolveActivity(getPackageManager()) !=null) {
                startActivity(intent);
            }
        }

}
