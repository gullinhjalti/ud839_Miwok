/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setOnClickListener to all Views in the root View that are instances of TextView
        ViewGroup vg = findViewById(R.id.main_activity_root);
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
            if (v instanceof TextView) {
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openList(v);
                    }
                });
            }
        }
    }

    //When a TextView is clicked the corresponding Activity should be started
    public void openList(View v) {
        Intent i;
        switch (v.getResources().getResourceEntryName(v.getId())) {
            case "numbers":
                i = new Intent(this, NumbersActivity.class);
                startActivity(i);
                break;
            case "colors":
                i = new Intent(this, ColorsActivity.class);
                startActivity(i);
                break;
            case "family":
                i = new Intent(this, FamilyActivity.class);
                startActivity(i);
                break;
            case "phrases":
                i = new Intent(this, PhrasesActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
