package com.example.saraa.mylocker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private EditText lockernumber1 , buildingnumbers1 , floornumbers1 ;
    private Button add;
    private Spinner size1,status1;
    DatabaseReference databaseLocker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseLocker= FirebaseDatabase.getInstance().getReference("locker");
        lockernumber1=(EditText)findViewById(R.id.lockernumber);
        buildingnumbers1=(EditText)findViewById(R.id.buildingnum);
        floornumbers1=(EditText)findViewById(R.id.floornum);
        status1=(Spinner) findViewById(R.id.status);
        size1=(Spinner) findViewById(R.id.size);
        add.setOnClickListener(this);
    }
    public void onClick (View v){

    }
    private void addlocker(){
        String ssize=size1.getSelectedItem().toString();
        String sstatus=status1.getSelectedItem().toString();
        int lockernum= Integer.parseInt(lockernumber1.getText().toString());
        int buildingnum= Integer.parseInt(buildingnumbers1.getText().toString());
        int floornum= Integer.parseInt(floornumbers1.getText().toString());
        if (!TextUtils.isEmpty((CharSequence) lockernumber1)) {
            databaseLocker.push();
        }else {
            Toast.makeText(this, "you should enter the size", Toast.LENGTH_LONG).show();

        }
        if (!TextUtils.isEmpty((CharSequence) buildingnumbers1)) {
            databaseLocker.push();
        }else {
            Toast.makeText(this, "you should enter the building number", Toast.LENGTH_LONG).show();//i have to add tid one

        }
        if (!TextUtils.isEmpty((CharSequence) floornumbers1)) {
            String id=databaseLocker.push().getKey();
            savedata locker= new savedata(lockernum,buildingnum,floornum,ssize,sstatus);
            databaseLocker.child(id).setValue(locker);//setValue(locker);
            Toast.makeText(this, "locker has been added", Toast.LENGTH_LONG).show();//i have to add tid one

        }else {
            Toast.makeText(this, "you should enter the floor number", Toast.LENGTH_LONG).show();//i have to add tid one

        }

    }
}

