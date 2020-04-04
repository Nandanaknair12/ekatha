package com.example.ekathapro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class viewthrift extends AppCompatActivity {

    TextView date,amount;
    String datee;
    String sdate;
    String wardnum,unitnum,username;
    Button searchtrift;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    ThriftClass thriftClass;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewthrift);

        date=(TextView)findViewById(R.id.date1);
        amount=(TextView)findViewById(R.id.amount2);
        searchtrift=(Button)findViewById(R.id.searchthrift);
        b1=(Button)findViewById(R.id.memberlist);
        b2=(Button)findViewById(R.id.requestloan);
        b3=(Button)findViewById(R.id.viewattendance);
        b4=(Button)findViewById(R.id.viewthrift);
        b5=(Button)findViewById(R.id.viewexpense);
        b6=(Button)findViewById(R.id.loandetails);
        b7=(Button)findViewById(R.id.paymentinfo);
        b8=(Button)findViewById(R.id.complaints);
        b9=(Button)findViewById(R.id.privacy);

        thriftClass=new ThriftClass();

        SharedPreferences sharedPreferences=getSharedPreferences("Memlogin",MODE_PRIVATE);
        wardnum=sharedPreferences.getString("ward",null);
        unitnum=sharedPreferences.getString("unitnum",null);
        username=sharedPreferences.getString("member",null);


        final Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(calendar.YEAR);
        final int month=calendar.get(calendar.MONTH);
        final int day=calendar.get(calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(viewthrift.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month = month + 1;
                        String smonth = Integer.toString(month);
                        String sday = Integer.toString(dayOfMonth);
                        if (sday.length() == 1) {
                            sday = "0" + sday;
                        }
                        if (smonth.length() == 1) {
                            smonth = "0" + smonth;
                        }
                        datee = year + "," + smonth + "," + sday;
                        date.setText(datee);
                    }
                },year,month,day);
                datePickerDialog.show();
                    }
                });

        searchtrift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sdate=date.getText().toString();
                databaseReference= FirebaseDatabase.getInstance().getReference().child(wardnum).child(unitnum).child(username).child("Thrift").child(sdate);
                Query query=databaseReference.orderByChild("date").equalTo(datee);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if(dataSnapshot.exists())
                            {
                                thriftClass=dataSnapshot.getValue(ThriftClass.class);
                                amount.setText(thriftClass.amount);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Thrift is not available in this date",Toast.LENGTH_LONG).show();
                            }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
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
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getApplicationContext(),requestloan.class);
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
