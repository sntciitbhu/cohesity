package com.example.needhelp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.needhelp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class Profile extends AppCompatActivity {

    private static final int IMAGE_REQUEST = 1;
    private static final int REQUEST_WRITE_PERMISSION = 12;
    private TextView name;
    private TextView email;
    private TextView phone;
    private TextView organisation;
    private LinearLayout call;
    public ImageView close, photo;
    private TextView addinfo;
    String phonee, datetime;
    private StorageReference postref;
    DatabaseReference reference;
    private Uri mImageUri;
    private ProgressDialog dialog;
    private StorageTask mUploadTask;
    String url;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.userrname);
        email = findViewById(R.id.emailid);
        phone = findViewById(R.id.phone_number);
        photo = findViewById(R.id.select_post_image);
        close = findViewById(R.id.close);
        call = findViewById(R.id.make_call);

        organisation = findViewById(R.id.org_display);
        addinfo = findViewById(R.id.upload_new);
        dialog = new ProgressDialog(this);
        postref = FirebaseStorage.getInstance().getReference("uploads");
        reference = FirebaseDatabase.getInstance().getReference("USERS").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        updateinfo();

        addinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, EditImage.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, Working.class));
                finish();
            }
        });

    }

    private void updateinfo() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String username = Objects.requireNonNull(dataSnapshot.child("username_item").getValue()).toString();
                String emaill = Objects.requireNonNull(dataSnapshot.child("email").getValue()).toString();
                phonee = Objects.requireNonNull(dataSnapshot.child("phone").getValue()).toString();
                url = Objects.requireNonNull(dataSnapshot.child("imageURL").getValue()).toString();
                String orgg = Objects.requireNonNull(dataSnapshot.child("organisation").getValue()).toString();
                Picasso.get()
                        .load(url)
                        .resize(100, 100)
                        .into(photo);
                name.setText(username);
                email.setText(emaill);
                phone.setText(phonee);
                organisation.setText(orgg);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
