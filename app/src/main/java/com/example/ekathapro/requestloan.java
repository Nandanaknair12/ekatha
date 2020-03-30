package com.example.ekathapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class requestloan extends AppCompatActivity {

    EditText date,amount;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button reqloan;
    String currentdate;
    String date1;
    int amount1;
    String ward,unitno,username;
    Loanclass loanclass;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestloan);

        Calendar c=Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("yyyy,MM,dd");
        currentdate=df.format(c.getTime());


        date=(EditText)findViewById(R.id.date);
        amount=(EditText)findViewById(R.id.amount1);

        b1=(Button)findViewById(R.id.memberlist);
        b2=(Button)findViewById(R.id.requestloan);
        b3=(Button)findViewById(R.id.viewattendance);
        b4=(Button)findViewById(R.id.viewthrift);
        b5=(Button)findViewById(R.id.viewexpense);
        b6=(Button)findViewById(R.id.loandetails);
        b7=(Button)findViewById(R.id.paymentinfo);
        b8=(Button)findViewById(R.id.complaints);
        b9=(Button)findViewById(R.id.privacy);

        reqloan=(Button)findViewById(R.id.loanreg);

        SharedPreferences sharedPreferences=getSharedPreferences("Memlogin",MODE_PRIVATE);
        ward=sharedPreferences.getString("ward",null);
        unitno=sharedPreferences.getString("unitnum",null);
        username=sharedPreferences.getString("member",null);

        loanclass=new Loanclass();

        date.setText(currentdate);

        reqloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               amount1=Integer.parseInt(amount.getText().toString());

                if(date1.isEmpty())
                {
                    date.setError("enter date");
                    date.requestFocus();
                }
                else if(amount1<100)
                {
                    amount.setError("enter amount");
                    amount.requestFocus();
                }
                else
                {
                    databaseReference=FirebaseDatabase.getInstance().getReference().child(ward).child(unitno).child("Member").child(username).child("Loan");
                    loanclass.amount=amount1;
                    loanclass.date=currentdate;
                    loanclass.username=username;
                    databaseReference.setValue(loanclass).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"successfully submitted",Toast.LENGTH_LONG).show();

                        }
                    });

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),memlogged.class);
                startActivity(inten);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),viewattendance.class);
                startActivity(inten);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),viewthrift.class);
                startActivity(inten);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),viewexpense.class);
                startActivity(inten);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),loandetails.class);
                startActivity(inten);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),paymentinfo.class);
                startActivity(inten);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),complaints.class);
                startActivity(inten);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),privacy.class);
                startActivity(inten);
            }
        });
    }
}
