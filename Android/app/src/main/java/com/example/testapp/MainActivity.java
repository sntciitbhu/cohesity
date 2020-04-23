package com.example.testapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;
    Button btnFit,btnIll,btnPdet,btnPedit,btnEedit,btnLogout,btnSos,btnSendsos;
    TextView tvFit,tvIll,tvTrack,tvddetails,tvKnow,tvKDet,tvPname,tvPheight,tvPweight,tvPpass,tvPmail;
    EditText tvEname,tvEpass,tvEmail,tvEweight,tvEheight;
    LinearLayout layFit,layIll,laySos,layMain,layAcc;
    ImageView dp;
    ConstraintLayout layPdata,layPchange;
    String name,email,gender,bidet,sos;
    Spinner spIll;
    Integer weight,height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);


        btnSos=findViewById(R.id.btnSos);
        btnSendsos=findViewById(R.id.btnSendsos);
        btnFit = findViewById(R.id.btnFit);
        btnIll = findViewById(R.id.btnIll);
        tvIll = findViewById(R.id.tvIll);
        tvFit = findViewById(R.id.tvFit);
        layFit = findViewById(R.id.layFit);
        layIll = findViewById(R.id.layIll);
        layMain = findViewById(R.id.layMain);
        spIll = findViewById(R.id.spIll);
        tvddetails = findViewById(R.id.tvddetails);
        tvKnow = findViewById(R.id.tvKnow);
        tvKDet = findViewById(R.id.tvKdet);
        btnPdet = findViewById(R.id.btnPdet);
        btnPedit = findViewById(R.id.btnPedit);
        tvPheight = findViewById(R.id.tvPheight);
        tvPname = findViewById(R.id.tvPname);
        tvPweight = findViewById(R.id.tvPweight);
        tvPpass = findViewById(R.id.tvPpass);
        tvPmail = findViewById(R.id.tvPmail);
        layPdata = findViewById(R.id.layPdata);
        tvEheight = findViewById(R.id.tvEheight);
        tvEpass = findViewById(R.id.tvEpass);
        tvEname = findViewById(R.id.tvEname);
        tvEweight = findViewById(R.id.tvEweight);
        tvEmail = findViewById(R.id.tvEmail);
        btnEedit = findViewById(R.id.btnEedit);
        layPchange = findViewById(R.id.layPedit);
        layAcc = findViewById(R.id.layAcc);
        btnLogout=findViewById(R.id.btnLogout);
        laySos=findViewById(R.id.laySos);

        tvKDet.setVisibility(View.GONE);
        tvddetails.setVisibility(View.VISIBLE);
        layFit.setVisibility(View.GONE);
        layIll.setVisibility(View.GONE);
        layAcc.setVisibility(View.GONE);
        laySos.setVisibility(View.GONE);


        gender = TestApplicationn.user.getProperty("gender").toString();
        name = TestApplicationn.user.getProperty("name").toString();
        email = TestApplicationn.user.getEmail();
        weight = Integer.parseInt(TestApplicationn.user.getProperty("weight").toString());
        height = Integer.parseInt(TestApplicationn.user.getProperty("height").toString());
        sos=TestApplicationn.user.getProperty("sos").toString();
        btnFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layMain.setBackground(getResources().getDrawable(R.mipmap.andpic));
                String bmi, bfitness;
                Double bi;
                bi = (double) (weight) * 10000 / (height * height);
                if (bi < 18.5) {
                    bfitness = "You are under weight.";
                    bidet = getResources().getStringArray(R.array.bmi)[0];
                } else if (bi < 25) {
                    bfitness = "You are Healthy";
                    bidet = getResources().getStringArray(R.array.bmi)[1];
                } else if (bi < 30) {
                    bfitness = "You are over Weight";
                    bidet = getResources().getStringArray(R.array.bmi)[2];
                } else {
                    bfitness = "You are obese";
                    bidet = getResources().getStringArray(R.array.bmi)[3];
                }
                tvFit.setText(String.format("Your BMI is %.2f", bi) + bfitness);
                layFit.setVisibility(View.VISIBLE);
                layIll.setVisibility(View.GONE);
                layAcc.setVisibility(View.GONE);
                laySos.setVisibility(View.GONE);
                tvKnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvKDet.setText(bidet);
                        if (tvKDet.getVisibility() == View.VISIBLE) {
                            tvKDet.setVisibility(View.GONE);
                        } else {
                            tvKDet.setVisibility(View.VISIBLE);
                        }

                    }
                });


            }
        });
        btnIll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layMain.setBackground(getResources().getDrawable(R.mipmap.andpic));
                layFit.setVisibility(View.GONE);
                layIll.setVisibility(View.VISIBLE);
                layAcc.setVisibility(View.GONE);
                laySos.setVisibility(View.GONE);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.disease, R.layout.support_simple_spinner_dropdown_item);
                spIll.setAdapter(adapter);

                spIll.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        tvddetails.setText(getResources().getStringArray(R.array.ddetails)[position]);
                        tvddetails.setVisibility(View.VISIBLE);
                        layMain.setBackgroundColor(getResources().getColor(R.color.white));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        tvddetails.setVisibility(View.GONE);

                    }
                });


            }
        });
        btnPdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layFit.setVisibility(View.GONE);
                layIll.setVisibility(View.GONE);
                layAcc.setVisibility(View.VISIBLE);
                laySos.setVisibility(View.GONE);

                layPdata.setVisibility(View.VISIBLE);
                layPchange.setVisibility(View.GONE);
                tvPheight.setText(height.toString() + " cm");
                tvPname.setText(name);
                tvPpass.setText("********");
               // String s="https://api.backendless.com/62B689E9-8DFD-1BD6-FF35-AE5B5CF72A00/console/vvooayyaooalxkfattzxkxhexrykuzqgjmrr/files/Image/" +name+"%"+weight+height+".png";
               //dp.setImageURI(Uri.parse("https://backendlessappcontent.com/62B689E9-8DFD-1BD6-FF35-AE5B5CF72A00/console/vvooayyaooalxkfattzxkxhexrykuzqgjmrr/files/view/Image/Siddhant%2015858.png"));
                tvPmail.setText(TestApplicationn.user.getEmail());

            }
        });
        btnPedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layFit.setVisibility(View.GONE);
                layIll.setVisibility(View.GONE);
                layAcc.setVisibility(View.VISIBLE);
                layPdata.setVisibility(View.GONE);
                layPchange.setVisibility(View.VISIBLE);
                laySos.setVisibility(View.GONE);


            }
        });


        btnEedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (tvEname.getText().toString().isEmpty()) {}


                  else {
                   name = tvEname.getText().toString();
                   TestApplicationn.user.setProperty("name", name);
               }


              if (tvEheight.getText().toString().isEmpty()) {

                } else {
                    height = Integer.parseInt(tvEheight.getText().toString());
                    TestApplicationn.user.setProperty("height", Integer.parseInt(tvEheight.getText().toString()));
                }
                if (tvEweight.getText().toString().isEmpty()) {

                } else {
                    weight = Integer.parseInt(tvEweight.getText().toString());
                    TestApplicationn.user.setProperty("weight", Integer.parseInt(tvEweight.getText().toString()));
                }
                if (tvEmail.getText().toString().isEmpty()) {

                } else {
                    TestApplicationn.user.setEmail(tvEmail.getText().toString());
                }
                if (tvEpass.getText().toString().isEmpty()) {

                } else {
                    TestApplicationn.user.setPassword(tvEpass.getText().toString());
                }
              showProgress(true);
               tvLoad.setText("Making Chnanges");
                Backendless.UserService.update(TestApplicationn.user, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(MainActivity.this, "Succesfully Changed", Toast.LENGTH_SHORT).show();
                        showProgress(false);
                        layFit.setVisibility(View.GONE);
                        layIll.setVisibility(View.GONE);
                        layAcc.setVisibility(View.VISIBLE);
                        laySos.setVisibility(View.GONE);


                        layPdata.setVisibility(View.VISIBLE);
                        layPchange.setVisibility(View.GONE);
                        tvPheight.setText(height.toString() + " cm");
                        tvPname.setText(name);
                        tvPpass.setText("********");
                        tvPweight.setText(weight.toString() + " Kg");


                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(MainActivity.this, "Error" + fault.getMessage(), Toast.LENGTH_SHORT).show();
                        showProgress(false);

                    }
                });
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress(true);
                Backendless.UserService.logout(new AsyncCallback<Void>() {
                    @Override
                    public void handleResponse(Void response) {
                        Toast.makeText(MainActivity.this, "Succesfully logged out", Toast.LENGTH_SHORT).show();
                        showProgress(false);
                        name=null;
                        email=null;
                        gender=null;
                        weight=null;
                        TestApplicationn.user=null;
                        startActivity(new Intent(MainActivity.this,login.class));

                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(MainActivity.this, "Error"+fault.getMessage(), Toast.LENGTH_SHORT).show();
                        showProgress(false);

                    }
                });
            }
        });
        btnSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layFit.setVisibility(View.GONE);
                layIll.setVisibility(View.GONE);
                layAcc.setVisibility(View.GONE);
                layPdata.setVisibility(View.GONE);
                layPchange.setVisibility(View.GONE);
                laySos.setVisibility(View.VISIBLE);

            }
        });
        btnSendsos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               try {
                   SmsManager sms = SmsManager.getDefault();
                   sms.sendTextMessage("sos", null, "I need help", null, null);
                   Toast.makeText(MainActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
               }
               catch (Exception e)
               {
                   Toast.makeText(MainActivity.this,"error:Please give sms permission to app in settings"+e.getMessage(), Toast.LENGTH_LONG).show();
               }
            }
        });
    }
    public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private ImageView imageView;

        public ImageLoadTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL urlConnection = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }

    }
    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_longAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}




