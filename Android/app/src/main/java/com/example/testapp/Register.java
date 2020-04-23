package com.example.testapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.files.BackendlessFile;

public class Register extends AppCompatActivity {
    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;
    EditText etName,etMail,etPass,etRe,etWeight,etHeight,etSos;
    Button btnReg,btnImage;
    Spinner spGender;
    Bitmap image;
    static final int REQUEST_TAKE_PHOTO = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);
        etName=findViewById(R.id.etname);
        etMail=findViewById(R.id.etMail);
        etPass=findViewById(R.id.etPass);
        etRe=findViewById(R.id.etRe);
        etWeight=findViewById(R.id.etWeight);
        etHeight=findViewById(R.id.etHeight);
        btnReg=findViewById(R.id.btnReg);
        btnImage=findViewById(R.id.btnImage);
        etSos=findViewById(R.id.etSos);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.gender,R.layout.support_simple_spinner_dropdown_item);
        spGender=findViewById(R.id.spGender);
        spGender.setAdapter(adapter);


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty()||etPass.getText().toString().isEmpty()||etRe.getText().toString().isEmpty()||etRe.getText().toString().isEmpty()||etWeight.getText().toString().isEmpty()||etHeight.getText().toString().isEmpty()||spGender.getSelectedItem().toString().equals("Please Select Your Gender"))
                {
                    Toast.makeText(Register.this, "Please Enter All Your Details", Toast.LENGTH_SHORT).show();
                }
               else {
                   if(etPass.getText().toString().equals(etRe.getText().toString()))
                    {
                        String name=etName.getText().toString();
                        String email=etMail.getText().toString();
                        String pass=etPass.getText().toString();
                        Integer height=Integer.parseInt(etHeight.getText().toString());
                        Integer weight=Integer.parseInt(etWeight.getText().toString());
                        String gender=spGender.getSelectedItem().toString();
                        final BackendlessUser user=new BackendlessUser();
                        user.setEmail(email);
                        user.setPassword(pass);
                        user.setProperty("name",name);
                        user.setProperty("weight",weight);
                        user.setProperty("height",height);
                        user.setProperty("gender",gender);
                        user.setProperty("sos",etSos.getText().toString());
                        Backendless.Files.Android.upload( image,
                                Bitmap.CompressFormat.PNG,
                                100, name+weight+height+".png",
                                "Image",
                                new AsyncCallback<BackendlessFile>() {
                                    @Override
                                    public void handleResponse(final BackendlessFile backendlessFile) {
                                        user.setProperty("Image",backendlessFile);
                                    }

                                    @Override
                                    public void handleFault(BackendlessFault backendlessFault) {
                                        Toast.makeText(Register.this, backendlessFault.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                        showProgress(true);
                        tvLoad.setText("Registering Wait Pls");
                        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                showProgress(false);
                                Toast.makeText(Register.this, "User succesfully registered", Toast.LENGTH_SHORT).show();
                                Register.this.finish();

                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                Toast.makeText(Register.this, "error"+fault.getMessage(), Toast.LENGTH_SHORT).show();
                                showProgress(false);

                            }
                        });
                    }
                    else
                   {
                       Toast.makeText(Register.this, "Both Passwords Are Not Same", Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });

    }
    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO&& resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();

            image = (Bitmap) extras.get("data");

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
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

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
