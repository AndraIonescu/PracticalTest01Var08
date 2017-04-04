package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var08SecondaryActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;

    SumButtonListener sumButtonListener = new SumButtonListener();
    ProductButtonListener productButtonListener = new ProductButtonListener();

    private class SumButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Integer x1 = Integer.parseInt(text1.getText().toString());
            Integer x2 = Integer.parseInt(text2.getText().toString());
            Integer x3 = Integer.parseInt(text3.getText().toString());
            Integer x4 = Integer.parseInt(text4.getText().toString());
            Integer sum = 0;

            if (x1 != null && x2 != null && x3 != null && x4 != null) {
                sum += x1 + x2 + x3 + x4;

                Toast.makeText(getApplicationContext(), sum.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class ProductButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Integer x1 = Integer.parseInt(text1.getText().toString());
            Integer x2 = Integer.parseInt(text2.getText().toString());
            Integer x3 = Integer.parseInt(text3.getText().toString());
            Integer x4 = Integer.parseInt(text4.getText().toString());
            Integer product = 1;

            if (x1 != null && x2 != null && x3 != null && x4 != null) {
                product *= x1 * x2 * x3 * x4;

                Toast.makeText(getApplicationContext(), product.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secondary);

        text1 = (TextView)findViewById(R.id.textView1);
        text2 = (TextView)findViewById(R.id.textView2);
        text3 = (TextView)findViewById(R.id.textView3);
        text4 = (TextView)findViewById(R.id.textView4);

        Intent intent = getIntent();
        if (intent != null) {
            String t1 = intent.getStringExtra("editText1");
            String t2 = intent.getStringExtra("editText2");
            String t3 = intent.getStringExtra("editText3");
            String t4 = intent.getStringExtra("editText4");
            if (t1 != null) {
                text1.setText(t1);
            }

            if (t2 != null) {
                text2.setText(t2);
            }

            if (t3 != null) {
                text3.setText(t3);
            }

            if (t4 != null) {
                text4.setText(t4);
            }
        }

        Button sum = (Button)findViewById(R.id.sum);
        sum.setOnClickListener(sumButtonListener);
        Button product = (Button)findViewById(R.id.product);
        product.setOnClickListener(productButtonListener);



    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == 200) {
            setResult(resultCode, new Intent());
            finish();
        }
    }


}
