package whats.app.artroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import whats.app.artroom.databinding.ActivityResutlBinding;

public class ResutlActivity extends AppCompatActivity {
    private ActivityResutlBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityResutlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        if (getIntent().getData()!=null){

            binding.image.setImageURI(getIntent().getData());
            binding.shareBtn.setVisibility(View.VISIBLE);
        }
        else {
            binding.image.setImageResource(R.drawable.no_image_selected);
            binding.shareBtn.setVisibility(View.GONE);
        }

        binding.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM, getIntent().getData());
                startActivity(Intent.createChooser(intent, "Share Image Using"));

            }
        });

        binding.homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResutlActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });




    }



}