package com.androidapp.fusedbloxxer.moto4rent;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {
    private TextView mTextViewFirstPhone, mTextViewSecondPhone,
            mTextViewEmail, mTextViewLocation, mTextViewBrand;
    private ImageView mImageViewLocation;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_contact, container, false);
        initView(itemView);
        setBehaviour();
        return itemView;
    }

    private void setBehaviour() {
        View.OnClickListener mapListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openLocation = new Intent(Intent.ACTION_VIEW);
                openLocation.setData(Uri.parse("geo:0,0?q=" +
                        getActivity().getString(R.string.moto4rent_address)));
                if (openLocation.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(openLocation);
                }
            }
        };

        mImageViewLocation.setOnClickListener(mapListener);
        mTextViewLocation.setOnClickListener(mapListener);

        View.OnClickListener phoneListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:" + v.getTag()));
                if (dial.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(dial);
                }
            }
        };

        mTextViewFirstPhone.setOnClickListener(phoneListener);
        mTextViewSecondPhone.setOnClickListener(phoneListener);

        mTextViewEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailTo = new Intent(Intent.ACTION_SENDTO);
                String message = "mailto:" + getActivity().getString(R.string.email_moto4rent)
                        + "?subject=" + Uri.encode("Moto4Rent - Contact");
                emailTo.setData(Uri.parse(message));
                if (emailTo.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(Intent
                            .createChooser(emailTo, getActivity().getString(R.string.emailto)));
                }
            }
        });

        mTextViewBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext(), R.style.AlertDialogStyle);

                alertDialog
                        .setTitle(getResources().getString(R.string.brand_details))
                        .setMessage(mTextViewBrand.getText().toString())
                        .setPositiveButton(getResources()
                                .getText(R.string.back_text), null)
                        .create()
                        .show();
            }
        });
    }

    private void initView(View itemView) {
        mTextViewFirstPhone = itemView.findViewById(R.id.text_view_phone_1);
        mTextViewSecondPhone = itemView.findViewById(R.id.text_view_phone_2);
        mTextViewEmail = itemView.findViewById(R.id.text_view_email);
        mTextViewLocation = itemView.findViewById(R.id.text_view_location);
        mImageViewLocation = itemView.findViewById(R.id.image_view_map);
        mTextViewBrand = itemView.findViewById(R.id.text_view_brand);
    }
}
