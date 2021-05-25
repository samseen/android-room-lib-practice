package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.db.AppDatabase;
import com.example.roomdatabase.db.User;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        EditText firstNameInput = findViewById(R.id.first_name_input);
        EditText lastNameInput = findViewById(R.id.last_name_input);
        Button saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewUser(firstNameInput.getText().toString(), lastNameInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String firstName, String lastName) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        db.userDao().insertUser(user);

        finish();

    }
}