package com.rrmchathura.note_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rrmchathura.note_app.Models.Notes;
import com.rrmchathura.note_app.databinding.ActivityNotesTakenBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakenActivity extends AppCompatActivity {

    ActivityNotesTakenBinding binding;
    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotesTakenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageViewSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = binding.editTextTitle.getText().toString();
                String description = binding.editTextNotes.getText().toString();

                if (description.isEmpty()){
                    binding.editTextNotes.setError("Please add some notes!");
                    return;
                }
                else {
                    SimpleDateFormat formatter = new SimpleDateFormat("EEE,d MMM yyyy HH:mm a");
                    Date date = new Date();

                    notes = new Notes();
                    notes.setTitle(title);
                    notes.setNotes(description);
                    notes.setDate(formatter.format(date));

                    Intent intent = new Intent();
                    intent.putExtra("note",notes);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}