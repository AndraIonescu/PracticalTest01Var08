package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {
     Button set;
     EditText editText1;
     EditText editText2;
     EditText editText3;
     EditText editText4;

    SetButtonListener setButtonListener = new SetButtonListener();

    private class SetButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01var08.intent.action.PracticalTest01Var08SecondaryActivity");
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08SecondaryActivity.class);

            String edit1 = editText1.getText().toString();
            String edit2 = editText2.getText().toString();
            String edit3 = editText3.getText().toString();
            String edit4 = editText4.getText().toString();

            if (!edit1.isEmpty() && !edit2.isEmpty() && !edit3.isEmpty() && !edit4.isEmpty()) {
                intent.putExtra("editText1", edit1);
                intent.putExtra("editText2", edit2);
                intent.putExtra("editText3", edit3);
                intent.putExtra("editText4", edit4);
                startActivityForResult(intent, 200);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);

        set = (Button)findViewById(R.id.button);
        set.setOnClickListener(setButtonListener);

        if ((savedInstanceState != null) && (savedInstanceState.getString("edit1") != null)) {
            editText1.setText(savedInstanceState.getString("edit1"));
        }

        if ((savedInstanceState != null) && (savedInstanceState.getString("edit2") != null)) {
            editText2.setText(savedInstanceState.getString("edit2"));
        }

        if ((savedInstanceState != null) && (savedInstanceState.getString("edit3") != null)) {
            editText3.setText(savedInstanceState.getString("edit3"));
        }

        if ((savedInstanceState != null) && (savedInstanceState.getString("edit4") != null)) {
            editText4.setText(savedInstanceState.getString("edit4"));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("edit1", editText1.getText().toString());
        outState.putString("edit2", editText2.getText().toString());
        outState.putString("edit3", editText3.getText().toString());
        outState.putString("edit4", editText4.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.getString("edit1") != null) {
            editText1.setText(savedInstanceState.getString("edit1"));
        }
        if (savedInstanceState.getString("edit2") != null) {
            editText2.setText(savedInstanceState.getString("edit2"));
        }
        if (savedInstanceState.getString("edit3") != null) {
            editText3.setText(savedInstanceState.getString("edit3"));
        }
        if (savedInstanceState.getString("edit4") != null) {
            editText4.setText(savedInstanceState.getString("edit4"));
        }


    }
}
