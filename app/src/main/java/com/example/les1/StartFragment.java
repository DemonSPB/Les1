package com.example.les1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class StartFragment extends Fragment {
    TextView textView;
    Button button;
    ImageView imageView, imageWinter;
    Button buttonGo;

    public static StartFragment newInstance() {
        return new StartFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonGo = view.findViewById(R.id.buttonGo);


        buttonGo.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("GOGO","clicked");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.rootContainer, Myfragment.newInstance())
                        .commit();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction()
//                        .add(R.id.rootContainer, Myfragment.newInstance())
//                        .commit();

            }
// textView.setText("XYINA");
        });
        imageWinter=view.findViewById(R.id.winterImage);
        textView = view.findViewById(R.id.textMine);
        button = view.findViewById(R.id.button2);
        imageView = view.findViewById(R.id.forestImage);
        imageView.getLayoutParams().width = 300;
        imageView.getLayoutParams().height = 150;
        imageView.requestLayout();

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          if (imageView.getVisibility() == View.VISIBLE) {
                                              imageView.setVisibility(View.GONE);
                                              imageWinter.setVisibility(View.VISIBLE);
                                          } else {
                                              imageView.setVisibility(View.VISIBLE);
                                              imageWinter.setVisibility(View.GONE);
                                          }

                                      }

                                  }
        );
    }
}
