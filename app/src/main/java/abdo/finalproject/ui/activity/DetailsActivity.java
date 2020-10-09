package abdo.finalproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import abdo.finalproject.R;
import abdo.finalproject.models.MobileModel;

public class DetailsActivity extends AppCompatActivity {

    ImageView imagedetails;
    TextView fullNamedetails, pricedetails, descriptiondetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
    }

    private void initView() {
        imagedetails = findViewById(R.id.description_details_iv);
        fullNamedetails = findViewById(R.id.fullName_details_tv);
        pricedetails = findViewById(R.id.price_description_details_tv);
        descriptiondetails = findViewById(R.id.description_details_tv);


        MobileModel mobileModel = (MobileModel)getIntent().getSerializableExtra("mobile");

        imagedetails.setImageResource(mobileModel.getImage());
        fullNamedetails.setText(mobileModel.getName()+" "+mobileModel.getLabel());
        pricedetails.setText(mobileModel.getPrice());
        descriptiondetails.setText(mobileModel.getDescription());
    }
}
//        String description = intent.getStringExtra("description");
//        int image = intent.getIntExtra("image", 0);
//        String price = intent.getStringExtra("price");
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");