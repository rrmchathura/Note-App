package com.rrmchathura.note_app;

import androidx.cardview.widget.CardView;

import com.rrmchathura.note_app.Models.Notes;

public interface NotesClickListener {

    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
