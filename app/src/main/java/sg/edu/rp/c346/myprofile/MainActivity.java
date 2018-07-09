package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;


    @Override
    protected void onPause() {
        super.onPause();

        //get text for display
        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        float floatGPA = Float.parseFloat(strGPA);
        int getRg = rgGender.getCheckedRadioButtonId();
        //Step 1a:
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 1b:
        SharedPreferences.Editor prefEdit = prefs.edit();

        // Step 1c:
        prefEdit.putString("Name", strName);
        prefEdit.putFloat("GPA", floatGPA);
        prefEdit.putInt("Gender", getRg);


        //Step 1d:
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a:
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 2b:
        String msg = prefs.getString("Name","");
        Float msgf = prefs.getFloat("GPA", 0);
        String strmsgf = msgf.toString();
        int rg = prefs.getInt("Gender",R.id.radioButtonGenderMale);


        //Step 2c:
        etName.setText(msg);
        etGPA.setText(strmsgf);
        rgGender.check(rg);

    }


}
